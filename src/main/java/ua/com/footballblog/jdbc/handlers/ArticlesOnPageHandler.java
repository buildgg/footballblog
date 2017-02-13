package ua.com.footballblog.jdbc.handlers;

import ua.com.footballblog.entity.Article;
import ua.com.footballblog.jdbc.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vov on 13.02.2017.
 */
public class ArticlesOnPageHandler implements ResultSetHandler<List<Article>> {
    @Override
    public List<Article> handle(ResultSet rs) throws SQLException {
        List<Article> articles = new ArrayList<>();
        while (rs.next()){
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
            articles.add(article);
        }
      return articles;
    }
}
