package org.lscx.dao;

import org.lscx.pojo.Post;
import org.lscx.utils.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDaoImpl implements PostDao {
    private Connection conn;
    private PreparedStatement pstmt = null;

    public PostDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean addPost(Post post) throws Exception {
        boolean flag = false;
        String sql = "insert into posts(post_author,post_date,post_title,post_content,post_name) " +
                "values(?,?,?,?,?)";
        SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1,1);
        pstmt.setString(2,fmt.format(new Date()));
        pstmt.setString(3,post.getPost_title());
        pstmt.setString(4,post.getPost_content());
        pstmt.setString(5,"默认");
        if(pstmt.executeUpdate()>0){
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    @Override
    public List<Post> showAllPosts() throws Exception {
        List<Post> posts = new ArrayList<>();
        String sql="select * from posts";
        pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()){
            Post post = new Post();
            post.setID(rs.getInt(1));
            post.setPost_author(rs.getInt(2));
            post.setPost_date(rs.getString(3));
            post.setPost_title(rs.getString(4));
            post.setPost_content(rs.getString(5));
            post.setPost_name(rs.getString(6));
            posts.add(post);
        }
        return posts;
    }

    @Override
    public Post queryPostByID(int ID) throws Exception {
        Post post = null;
        String sql = "select * from posts " +
                "where ID = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1,ID);
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()){
            post = new Post();
            post.setID(rs.getInt(1));
            post.setPost_author(rs.getInt(2));
            post.setPost_date(rs.getString(3));
            post.setPost_title(rs.getString(4));
            post.setPost_content(rs.getString(5));
            post.setPost_name(rs.getString(6));
        }
        this.pstmt.close();
        return post;
    }

    @Override
    public boolean updatePostByID(Post post,int ID) throws Exception {
        boolean flag = false;
        String sql = "update posts set post_title=? ,post_content=? " +
                "where ID = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1,post.getPost_title());
        pstmt.setString(2,post.getPost_content());
        pstmt.setInt(3,ID);
        if(pstmt.executeUpdate()>0){
            flag = true;
        }
        return flag;

    }


}
