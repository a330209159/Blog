package org.lscx.test;

import org.lscx.factory.DAOFactory;
import org.lscx.pojo.Post;
import org.lscx.pojo.User;

import java.util.List;

public class TestShowPosts {
    public static void main(String[] args) {
        List<Post> posts ;
        try{
            posts = DAOFactory.getPostDaoInstance().showAllPosts();
            for(Post item:posts){
                System.out.println(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
