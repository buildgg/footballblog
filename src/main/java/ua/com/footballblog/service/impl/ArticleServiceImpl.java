package ua.com.footballblog.service.impl;

import ua.com.footballblog.entity.Article;
import ua.com.footballblog.entity.Category;
import ua.com.footballblog.entity.Comment;
import ua.com.footballblog.jdbc.JDBCUtil;
import ua.com.footballblog.jdbc.handlers.ArticlesOnPageHandler;
import ua.com.footballblog.jdbc.handlers.CategoryHandler;
import ua.com.footballblog.jdbc.handlers.CountHandler;
import ua.com.footballblog.service.ArticleService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vov on 02.02.2017.
 */
public class ArticleServiceImpl implements ArticleService {
    private DataSource dataSource;

    public ArticleServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Article> getArticlesOnPage(int page, int limit) {
        int offset = getOffset(page, limit);

        String sql = "select categoryid, count_comment, created, description, header, articleid, " +
                "text, url_img, category_name, category_url from varticlesonpage limit ? offset ? ";
        List<Article> listArticles = new ArrayList();
        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = createPreparedStatement(c, sql, limit, offset);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Article article = new Article();
                article.setCountComments(rs.getInt("count_comment"));
                article.setCreated(rs.getDate("created"));
                article.setDescription(rs.getString("description"));
                article.setHeader(rs.getString("header"));
                article.setId(rs.getInt("articleid"));
                article.setText(rs.getString("text"));
                article.setUrlImg(rs.getString("url_img"));
                article.setCategory(rs.getString("category_name"));
                article.setCategory_url(rs.getString("category_url"));
                listArticles.add(article);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listArticles;
    }

    @Override
    public Article getArticleById(int id) {
        String sql = "select a.id articleid, a.created, a.header, a.text, a.url_img, c.name category_name " +
                "from article a, category c " +
                "where a.categoryid = c.id and a.id = ?";
        Article article = new Article();
        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = createPreparedStatement(c, sql, id);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {

               /* article.setCountComments(rs.getInt("count_comment"));*/
                article.setCreated(rs.getDate("created"));
                article.setHeader(rs.getString("header"));
                article.setText(rs.getString("text"));
                article.setUrlImg(rs.getString("url_img"));
                article.setCategory(rs.getString("category_name"));
                article.setId(rs.getInt("articleid"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return article;
    }

    @Override
    public List<Comment> getCommentsByArticle(int idArticle) {
        String sql = "select com.username, com.message, com.articleid, com.id " +
                "from comment com where com.articleid = ?";

        List<Comment> commentList = new ArrayList<>();
        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = createPreparedStatement(c, sql, idArticle);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setArticleId(rs.getInt("articleid"));
                comment.setUserName(rs.getString("username"));
                comment.setMessage(rs.getString("message"));
                comment.setId(rs.getInt("id"));

                commentList.add(comment);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return commentList;
    }

    @Override
    public void addComment(Comment comment) {
        String sql = "insert into comment(id, username, articleid,  message) " +
                "values (nextval('comment_seq'),?,?,?)";

        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = createPreparedStatement(c, sql,
                     comment.getUserName(),
                     comment.getArticleId(),
                     comment.getMessage());
        ) {
            int result = ps.executeUpdate();
            if (result != 1) {
                throw new SQLException("Can't insert row to database. Result=" + result);
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                comment.setId(rs.getInt("id"));
                c.commit();
            } else {
                throw new RuntimeException("Error with Result Set");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getCountArticle() {
        String sql = "select count(*) from article";
        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = createPreparedStatement(c, sql);
             ResultSet rs = ps.executeQuery();) {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Category> getListCategory() {
        String sql = "select id, name, url from category";
        try (Connection c = dataSource.getConnection();) {
            List<Category> categoryList = JDBCUtil.select(dataSource.getConnection(), sql, new CategoryHandler());
            return categoryList;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Article> getArticlesByCatogory(String url, int page, int limit) {
      String sql = "select categoryid, count_comment, created, description, header, articleid, " +
              "text, url_img, category_name, category_url from varticlesonpage where category_url = ? " +
              " limit ? offset ? ";
        int offset = getOffset(page, limit);
        try(Connection c = dataSource.getConnection()) {
            return JDBCUtil.select(c,sql, new ArticlesOnPageHandler(), url, limit, offset);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getCountArticleByCatogory(String url) {
        String sql = "select count (a.id) count_article " +
                "from article a, category c " +
                "where a.categoryid = c.id " +
                "and c.url = ?";

        try (Connection c = dataSource.getConnection()) {
            return JDBCUtil.select(c, sql, new CountHandler(), url);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement createPreparedStatement(Connection c, String sql, Object... params)
            throws SQLException {
        PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        return ps;
    }

    private int getOffset(int page, int limit) {
        return (page - 1) * limit;
    }
}
