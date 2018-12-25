package org.lscx.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Post implements Serializable {
    private int ID;
    private int post_author;
    private String post_date;
    private String post_title;
    private String post_content;
    private String post_name;

    private String s_post_author;

    public String getS_post_author() {
        return s_post_author;
    }

    public void setS_post_author(String s_post_author) {
        this.s_post_author = s_post_author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "ID=" + ID +
                ", post_author=" + post_author +
                ", post_date='" + post_date + '\'' +
                ", post_title='" + post_title + '\'' +
                ", post_content='" + post_content + '\'' +
                ", post_name='" + post_name + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPost_author() {
        return post_author;
    }

    public void setPost_author(int post_author) {
        this.post_author = post_author;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date.replace(".0","");
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }
}
