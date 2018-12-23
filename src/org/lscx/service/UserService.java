package org.lscx.service;

import org.lscx.dao.UserDao;
import org.lscx.dao.UserDaoImpl;
import org.lscx.db.DBConnection;
import org.lscx.pojo.User;

import java.sql.SQLException;

public class UserService implements UserDao {
    private DBConnection dbconn;
    private UserDao dao;

    public UserService() throws Exception {
        this.dbconn = new DBConnection();
        this.dao = new UserDaoImpl(dbconn.getConnection());
    }

    @Override
    public boolean addUser(User user) throws SQLException {
        boolean flag = false;
        try{
            if(true){
                flag = dao.addUser(user);
            }
        } catch (Exception e){
            throw e;
        } finally {
            this.dbconn.close();
        }

        return flag;
    }
}
