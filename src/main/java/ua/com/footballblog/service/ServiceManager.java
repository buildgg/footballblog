package ua.com.footballblog.service;


import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.footballblog.service.impl.ArticleServiceImpl;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServiceManager {
    private static final String SERVICE_MANAGER = "SERVICE_MANAGER";
    private final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);
    private final BasicDataSource dataSource;
    private final ArticleService articleService;
    private final Properties properties = new Properties();

    public ServiceManager() {
        loadApplicationProperties();
        dataSource = getDataSource();
        articleService = new ArticleServiceImpl(dataSource);
    }

    public static ServiceManager getInstance(ServletContext servletContext) {
        ServiceManager serviceManager = (ServiceManager) servletContext.getAttribute(SERVICE_MANAGER);
        if (serviceManager == null) {
            serviceManager = new ServiceManager();
            servletContext.setAttribute(SERVICE_MANAGER, serviceManager);
        }
        return serviceManager;
    }

    private BasicDataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDefaultAutoCommit(false);
        dataSource.setRollbackOnReturn(true);
        dataSource.setUsername(getPropertyByKey("db.username"));
        dataSource.setUrl(getPropertyByKey("db.url"));
        dataSource.setPassword(getPropertyByKey("db.password"));
        dataSource.setDriverClassName(getPropertyByKey("db.driver"));
        dataSource.setInitialSize(Integer.parseInt(getPropertyByKey("db.pool.initSize")));
        dataSource.setMaxTotal(Integer.parseInt(getPropertyByKey("db.pool.maxSize")));

        return dataSource;
    }

    private void loadApplicationProperties() {
        try (InputStream in = ServiceManager.class.getClassLoader().getResourceAsStream("Application.properties")) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getPropertyByKey(String key) {
        return properties.getProperty(key);
    }

    public ArticleService getArticleService() {
        return articleService;
    }
}
