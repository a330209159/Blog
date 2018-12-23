package org.lscx.dao;

import org.lscx.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    private Connection conn;
    private PreparedStatement pstmt = null;

    public UserDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean addUser(User user) throws SQLException {
        boolean flag = false;
        String sql = "insert into users(user_login,user_pass,user_nickname,user_email)" +
                "values(?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql); //实例化PrepareStatment对象
        // pstmt.setInt(1,user.getID()); //ID自增，无需设置
        pstmt.setString(1,user.getUser_login());
        pstmt.setString(2,user.getUser_pass());
        pstmt.setString(3,user.getUser_nickname());
        pstmt.setString(4,user.getUser_email());

        if(pstmt.executeUpdate()>0){
            flag = true;
        }
        this.pstmt.close();
        return flag;

    }

    @Override
    public User queryByUser_login(String user_login) throws SQLException {
        User user = null;
        String sql = "select ID,user_login,user_pass,user_nickname,user_email from users " +
                "where user_login = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1,user_login);
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()){
            user = new User();
            user.setID(rs.getInt(1));
            user.setUser_login(rs.getString(2));
            user.setUser_pass(rs.getString(3));
            user.setUser_nickname(rs.getString(4));
            user.setUser_email(rs.getString(5));
        }
        this.pstmt.close();
        return user;
    }

}
