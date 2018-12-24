package org.lscx.test;

import org.lscx.factory.DAOFactory;
import org.lscx.pojo.Post;

public class TestInsertPost {
    public static void main(String[] args) {
        try {
            Post post = new Post();
            post.setPost_author(1);
            post.setPost_title("仅仅是一个测试");
            post.setPost_content("Meow Blog,Hello World!");
            DAOFactory.getPostDaoInstance().addPost(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
