package ua.com.footballblog.controller.ajax;

import org.json.JSONObject;
import ua.com.footballblog.controller.AbstractController;
import ua.com.footballblog.entity.Comment;
import ua.com.footballblog.util.Route;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vov on 08.02.2017.
 */
@WebServlet("/ajax/comment/add")
public class AddComment extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Comment comment = createdCommentFromRequest(req);
        getArticleService().addComment(comment);
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("newId", comment.getId());

        Route.sendJSON(jsonObject, req, resp);

      /*  resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);*/

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET ");
    }
}
