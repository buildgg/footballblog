package ua.com.footballblog.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vov on 10.02.2017.
 */
public class JDBCUtil {

    public static <T> T  select (Connection c, String sql, ResultSetHandler<T> resultSetHandler, Object ... params){
        try(PreparedStatement ps = createPreparedStatement(c, sql, params);
            ResultSet rs = ps.executeQuery()){
            return resultSetHandler.handle(rs);

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createPreparedStatement(Connection c, String sql, Object... params)
            throws SQLException {
        PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        return ps;
    }
}