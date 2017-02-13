package ua.com.footballblog.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vov on 10.02.2017.
 */
public interface ResultSetHandler<T>  {
    T handle(ResultSet rs) throws SQLException;
}
