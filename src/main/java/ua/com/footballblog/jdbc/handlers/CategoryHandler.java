package ua.com.footballblog.jdbc.handlers;

import ua.com.footballblog.entity.Category;
import ua.com.footballblog.jdbc.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vov on 10.02.2017.
 */
public class CategoryHandler implements ResultSetHandler<List<Category>> {
    @Override
    public List<Category> handle(ResultSet rs) throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        while (rs.next()) {
            Category category = new Category();
            category.setName(rs.getString("name"));
            category.setId(rs.getInt("id"));
            category.setUrl(rs.getString("url"));
            categoryList.add(category);
        }
        return categoryList;
    }
}
