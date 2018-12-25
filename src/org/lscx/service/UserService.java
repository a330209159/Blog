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

    @Override
    public User queryByUser_login(String user_login) throws SQLException {
        User user = null;
        try{
            user = this.dao.queryByUser_login(user_login);
        }catch (Exception e){
            throw e;
        } finally {
            this.dbconn.close();
        }
        return user;

    }

    @Override
    public User queryUserByID(int ID) throws SQLException {
        User user;
        try{
            user = this.dao.queryUserByID(ID);
        }catch (Exception e){
            throw e;
        } finally {
            this.dbconn.close();
        }
        return user;
    }
}
