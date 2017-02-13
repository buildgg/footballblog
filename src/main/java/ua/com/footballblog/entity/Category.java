package ua.com.footballblog.entity;

/**
 * Created by vov on 02.02.2017.
 */
public class Category extends AbstractEntity<Integer> {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
