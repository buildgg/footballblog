package ua.com.footballblog.jdbc.handlers;

import ua.com.footballblog.jdbc.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vov on 13.02.2017.
 */
public class CountHandler implements ResultSetHandler<Integer> {
    @Override
    public Integer handle(ResultSet rs) throws SQLException {
        if (rs.next()){
            return rs.getInt(1);
        }else {
            return 0;
        }
    }
}
