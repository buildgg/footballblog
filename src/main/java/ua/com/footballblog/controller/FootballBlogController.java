package ua.com.footballblog.controller;

import ua.com.footballblog.entity.Article;
import ua.com.footballblog.util.Route;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by vov on 31.01.2017.
 */
@WebServlet("/fblog")
public class FootballBlogController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articleList = getArticleService().getArticlesOnPage(1, 3);
        req.setAttribute("articles_on_page", articleList);
        Route.forwardToPage("articles.jsp", req, resp);
    }
}
