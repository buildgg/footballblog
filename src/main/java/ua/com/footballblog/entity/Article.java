package ua.com.footballblog.entity;

import java.sql.Date;
import java.util.List;

/**
 * Created by vov on 02.02.2017.
 */
public class Article extends AbstractEntity<Integer> {
    private String header;
    private String category;
    private Date created;
    private String description;
    private String text;
    private String urlImg;
    private int countComments;

    public int getCountComments() {
        return countComments;
    }

    public void setCountComments(int countComments) {
        this.countComments = countComments;
    }
    // private List<Comment> commentList;

   /* public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }*/

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return "Article{" +
                "header='" + header + '\'' +
                ", category='" + category + '\'' +
                ", created=" + created +
                ", description='" + description + '\'' +
                ", text='" + text + '\'' +
                ", urlImg='" + urlImg + '\'' +
               /* ", commentList=" + commentList +*/
                '}';
    }
}
