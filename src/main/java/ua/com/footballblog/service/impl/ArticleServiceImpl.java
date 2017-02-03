package ua.com.footballblog.service.impl;

import ua.com.footballblog.entity.Article;
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
       try(Connection c = dataSource.getConnection();
           PreparedStatement ps = createPreparedStatement(c, sql, limit, offset);
           ResultSet rs = ps.executeQuery())
        {
          while(rs.next()){
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
           e.printStackTrace();
       }

        return listArticles;
    }

    @Override
    public Article getArticleById(int id) {
        return null;
    }

    private PreparedStatement createPreparedStatement(Connection c, String sql, Object ...params) throws SQLException {
        PreparedStatement ps = c.prepareStatement(sql);
        for (int i = 0; i < params.length; i++){
                    ps.setObject(i + 1, params[i]);
        }
        return ps;
    }
    private int getOffset(int page, int limit){
        return (page - 1) * limit;
    }
}











