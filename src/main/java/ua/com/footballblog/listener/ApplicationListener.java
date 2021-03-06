package ua.com.footballblog.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.footballblog.entity.Category;
import ua.com.footballblog.service.ArticleService;
import ua.com.footballblog.service.ServiceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * Created by vov on 02.02.2017.
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);
    private ServiceManager serviceManager;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        serviceManager = ServiceManager.getInstance(sce.getServletContext());
        List<Category> categoryList = serviceManager.getArticleService().getListCategory();
        sce.getServletContext().setAttribute("categoryList", categoryList);


        LOGGER.info("::: Start FBlog contextInitialized ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        serviceManager.close();
        LOGGER.info("::: Destroyed FBlog");
    }
}
