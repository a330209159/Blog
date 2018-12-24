package org.lscx.test;

import org.lscx.factory.DAOFactory;
import org.lscx.pojo.Post;

public class TestUpdatePost {

        public static void main(String[] args) {
            try {
                Post post = new Post();
                post.setPost_title("仅仅是一个测试");
                post.setPost_content("Meow Blog,Hello World!");
                DAOFactory.getPostDaoInstance().updatePostByID(post,8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
