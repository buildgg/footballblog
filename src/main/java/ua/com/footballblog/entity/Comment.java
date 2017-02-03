package ua.com.footballblog.entity;

/**
 * Created by vov on 02.02.2017.
 */
public class Comment extends AbstractEntity<Integer> {
    private int articleId;
    private String userName;
    private String message;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "articleId=" + articleId +
                ", userName='" + userName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
