package ua.com.footballblog.controller;

import ua.com.footballblog.service.ArticleService;
import ua.com.footballblog.service.ServiceManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by vov on 02.02.2017.
 */
public class AbstractController extends HttpServlet {
    private ArticleService articleService;
    @Override
    public void init() throws ServletException {
        articleService = ServiceManager.getInstance(getServletContext()).getArticleService();
    }

    public ArticleService getArticleService() {
        return articleService;
    }
}
