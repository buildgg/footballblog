package ua.com.footballblog.controller.page;

import ua.com.footballblog.controller.AbstractController;
import ua.com.footballblog.entity.Article;
import ua.com.footballblog.util.Constants;
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
        /*if (req.getParameter("page") != null)*/
        int page = getPageParam(req);
        List<Article> articleList = getArticleService().getArticlesOnPage(page, Constants.MAX_ARTICLES_ON_PAGE);

        int countArticle = getArticleService().getCountArticle();
        req.setAttribute("count_page", getCountPage(countArticle, Constants.MAX_ARTICLES_ON_PAGE));
        req.setAttribute("current_page",page);

        req.setAttribute("articles_on_page", articleList);
        Route.forwardToPage("articles.jsp", req, resp);
    }
}
