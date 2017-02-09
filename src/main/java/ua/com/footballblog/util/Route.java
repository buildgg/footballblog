package ua.com.footballblog.util;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vov on 02.02.2017.
 */
public final class Route {
    private static final String PAGE = "PAGE";

    public static final void forwardToPage(String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(PAGE, "page/" + jspPage);
        req.getRequestDispatcher("/WEB-INF/jsp/page-template.jsp").forward(req, resp);

    }
    public static final void redirect(String url, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(url);
    }
    public static final void sendJSON(JSONObject json, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.getWriter().print(json.toString());
        response.getWriter().close();
    }
}
