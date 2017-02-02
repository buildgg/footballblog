package ua.com.footballblog.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by vov on 02.02.2017.
 */
@WebFilter(filterName = "ErrorHandler")
public class ErrorHandler implements Filter {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (Throwable e) {
     LOGGER.info("Error in app :: ", e.getMessage(), e);
        }
    }

    @Override
    public void destroy() {

    }
}
