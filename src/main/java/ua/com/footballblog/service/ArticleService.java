package ua.com.footballblog.service;

import ua.com.footballblog.entity.Article;

import java.util.List;

/**
 * Created by vov on 02.02.2017.
 */
public interface ArticleService {
    List<Article> getArticlesOnPage(int page, int limit);
    Article getArticleById(int id);
}
