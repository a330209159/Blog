package org.lscx.test;

import org.lscx.factory.DAOFactory;
import org.lscx.pojo.User;

public class TestInsertUser {
    public static void main(String[] args) {
        User user;
        try{
            user = new User();
            user.setUser_login("damao");
            user.setUser_pass("123456");
            user.setUser_email("admin@lscx.org");
            user.setUser_nickname("BigCatmeow");
            DAOFactory.getUserDaoInstance().addUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
