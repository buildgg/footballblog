package ua.com.footballblog.controller;

import ua.com.footballblog.entity.Comment;
import ua.com.footballblog.service.ArticleService;
import ua.com.footballblog.service.ServiceManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by vov on 02.02.2017.
 */
public abstract class AbstractController extends HttpServlet {
    private ArticleService articleService;
    @Override
    public void init() throws ServletException {
        articleService = ServiceManager.getInstance(getServletContext()).getArticleService();
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    protected Comment createdCommentFromRequest(HttpServletRequest request){
        Comment comment = new Comment();
        comment.setArticleId(Integer.parseInt(request.getParameter("id")));
        comment.setUserName(request.getParameter("user"));
        comment.setMessage(request.getParameter("comment"));
        return comment;
    }
 /*   private int getCountArticle(){
        return getArticleService().getCountArticle();
    }*/

    public final int getCountPage(int countArticle, int articleOnPage){
        int onPage = countArticle/articleOnPage;
       if (onPage * articleOnPage != countArticle){
        onPage++;
       }
        return onPage;
    }
    public final int getPageParam(HttpServletRequest request){
        try{
            return Integer.parseInt(request.getParameter("page"));
        }catch(NumberFormatException e){
            return 1;
        }
    }
}
