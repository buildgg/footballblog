package ua.com.footballblog.controller;

import ua.com.footballblog.util.Route;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vov on 03.02.2017.
 */
@WebServlet("/current-article")
public class CurrentArticle extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Route.forwardToPage("current-article.jsp",req, resp);

    }
}
