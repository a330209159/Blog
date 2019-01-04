package org.lscx.service;

import org.lscx.dao.PostDao;
import org.lscx.dao.PostDaoImpl;
import org.lscx.db.DBConnection;
import org.lscx.pojo.Post;

import java.util.List;

public class PostService implements PostDao {
    private DBConnection dbconn;
    private PostDao dao;

    public PostService() throws Exception {
        this.dbconn = new DBConnection();
        this.dao = new PostDaoImpl(dbconn.getConnection());
    }

    @Override
    public boolean addPost(Post post) throws Exception {
        boolean flag;
        try{
            if(true){
                flag = dao.addPost(post);
            }
        }catch (Exception e){
            throw e;
        }finally {
            dbconn.close();
        }
        return flag;
    }

    @Override
    public List<Post> showAllPosts() throws Exception {
        List<Post> posts = null;
        try{
            if(true){
                posts = dao.showAllPosts();
            }
        }catch (Exception e){
            throw e;
        }finally {
            dbconn.close();
        }
        return posts;
    }

    @Override
    public Post queryPostByID(int ID) throws Exception {
        Post post;
        try{
            if(true){
                post = dao.queryPostByID(ID);
            }
        }catch (Exception e){
            throw e;
        }finally {
            dbconn.close();
        }
        return post;
    }

    @Override
    public boolean updatePostByID(Post post, int ID) throws Exception {
        boolean flag;
        try{
            if(true){
                flag = dao.updatePostByID(post,ID);
            }
        }catch (Exception e){
            throw e;
        }finally {
            dbconn.close();
        }
        return flag;
    }

    @Override
    public Post queryPostByPost_title(String post_title) throws Exception {
        Post post;
        try{
            if(true){
                post = dao.queryPostByPost_title(post_title);
            }
        }catch (Exception e){
            throw e;
        }finally {
            dbconn.close();
        }
        return post;
    }

    @Override
    public boolean deletePostByID(int ID) throws Exception {
        boolean flag = false;
        try{
            if(true){
                flag = dao.deletePostByID(ID);
            }
        }catch (Exception e){
            throw e;
        }finally {
            dbconn.close();
        }
        return flag;
    }

    @Override
    public List<Post> limitQueryPostsByPage(int pageNum) throws Exception {
        List<Post> posts = null;
        try{
            if(true){
                posts = dao.limitQueryPostsByPage(pageNum);
            }
        }catch (Exception e){
            throw e;
        }finally {
            dbconn.close();
        }
        return posts;
    }

    @Override
    public List<Post> queryRecentPostsTitle(int numbers) throws Exception {
        List<Post> posts = null;
        try{
            if(true){
                posts = dao.queryRecentPostsTitle(numbers);
            }
        }catch (Exception e){
            throw e;
        }finally {
            dbconn.close();
        }
        return posts;
    }
}
