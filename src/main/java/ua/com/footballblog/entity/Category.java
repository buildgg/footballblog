package ua.com.footballblog.entity;

/**
 * Created by vov on 02.02.2017.
 */
public class Category extends AbstractEntity<Integer> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
