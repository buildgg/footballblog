package ua.com.footballblog.controller;

import ua.com.footballblog.entity.Article;
import ua.com.footballblog.entity.Comment;
import ua.com.footballblog.util.Route;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by vov on 03.02.2017.
 */
@WebServlet("/current-article")
public class CurrentArticle extends AbstractController {
    public static final String CURRENT_ARTICLE = "CURRENT_ARTICLE";
    public static final String COMMENTSLIST_BY_ARTICLE = "COMMENTSLIST_BY_ARTICLE";
    public static final String COUNT_COMMENTS = "COUNT_COMMENTS";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Article article = getArticleService().getArticleById(id);
        List<Comment> commentList = getArticleService().getCommentsByArticle(id);

        req.setAttribute(CURRENT_ARTICLE, article);
        req.setAttribute(COMMENTSLIST_BY_ARTICLE, commentList);
        req.setAttribute(COUNT_COMMENTS, commentList.size());

        Route.forwardToPage("current-article.jsp",req, resp);

    }
}
