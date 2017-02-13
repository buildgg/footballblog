package ua.com.footballblog.service;

import ua.com.footballblog.entity.Article;
import ua.com.footballblog.entity.Category;
import ua.com.footballblog.entity.Comment;

import java.util.List;

/**
 * Created by vov on 02.02.2017.
 */
public interface ArticleService {
    List<Article> getArticlesOnPage(int page, int limit);
    Article getArticleById(int id);

    List<Comment> getCommentsByArticle(int idArticle);

    void addComment (Comment comment);

    int getCountArticle ();

    List<Category> getListCategory();

    List<Article> getArticlesByCatogory(String url, int page, int limit);
    int getCountArticleByCatogory (String url);


}
