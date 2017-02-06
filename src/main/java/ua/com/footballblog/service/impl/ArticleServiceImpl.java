package ua.com.footballblog.service.impl;

import ua.com.footballblog.entity.Article;
import ua.com.footballblog.entity.Comment;
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

        String sql = "select i.categoryid,\n" +
                "       i.count_comment,\n" +
                "       i.created,\n" +
                "       i.description,\n" +
                "       i.header,\n" +
                "       i.id articleid,\n" +
                "       i.text,\n" +
                "       i.url_img,\n" +
                "       c.name category_name\n" +
                "from (\n" +
                "       select a.categoryid,\n" +
                "              a.created,\n" +
                "              a.description,\n" +
                "              a.header,\n" +
                "              a.id,\n" +
                "              a.text,\n" +
                "              a.url_img,\n" +
                "              count(com.id) count_comment\n" +
                "       from article a\n" +
                "            LEFT OUTER JOIN comment com ON (a.id = com.articleid)\n" +
                "       group by a.categoryid,\n" +
                "                a.created,\n" +
                "                a.description,\n" +
                "                a.header,\n" +
                "                a.id,\n" +
                "                a.text,\n" +
                "                a.url_img\n" +
                "     ) i,\n" +
                "     category c\n" +
                "where i.categoryid = c.id " +
                "limit ? offset ?";
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
                listArticles.add(article);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listArticles;
    }

    @Override
    public Article getArticleById(int id) {
        String sql = "select a.created, a.header, a.text, a.url_img, c.name category_name " +
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

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return article;
    }

    @Override
    public List<Comment> getCommentsByArticle(int idArticle) {
        String sql = "select com.username, com.message, com.articleid " +
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
                commentList.add(comment);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return commentList;
    }

    private PreparedStatement createPreparedStatement(Connection c, String sql, Object... params) throws SQLException {
        PreparedStatement ps = c.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        return ps;
    }

    private int getOffset(int page, int limit) {
        return (page - 1) * limit;
    }
}











