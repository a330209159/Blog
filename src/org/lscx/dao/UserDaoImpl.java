package org.lscx.dao;

import org.lscx.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
