package org.lscx.dao;

import org.lscx.pojo.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                "values(?,?,?,?,)";
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
}
