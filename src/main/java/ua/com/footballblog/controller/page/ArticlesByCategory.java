package ua.com.footballblog.controller.page;

import ua.com.footballblog.controller.AbstractController;
import ua.com.footballblog.entity.Article;
import ua.com.footballblog.util.Constants;
import ua.com.footballblog.util.Route;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by vov on 13.02.2017.
 */
@WebServlet("/fblog/*")
public class ArticlesByCategory extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURI().substring("/fblog".length());
        int page = getPageParam(req);
        int countArticle = getArticleService().getCountArticleByCatogory(url);

        int countPage = getCountPage(countArticle, Constants.MAX_ARTICLES_ON_PAGE);

        req.setAttribute("count_page", countPage);
        req.setAttribute("current_page", page);

        List<Article> articleList =
                getArticleService().getArticlesByCatogory(url, page, Constants.MAX_ARTICLES_ON_PAGE);
        req.setAttribute("articles_on_page", articleList);

        Route.forwardToPage("articles.jsp", req, resp);

    }
}
