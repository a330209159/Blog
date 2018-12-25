package org.lscx.dao;

import org.lscx.pojo.User;

import java.sql.SQLException;

public interface UserDao {
    boolean addUser(User user) throws SQLException;
    User queryByUser_login(String user_login) throws SQLException;
    User queryUserByID(int ID) throws SQLException;
}
