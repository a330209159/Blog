package org.lscx.test;

import org.lscx.factory.DAOFactory;
import org.lscx.pojo.User;

public class TestQueryUser {
    public static void main(String[] args) {
        User user;
        try{
            user = DAOFactory.getUserDaoInstance().queryByUser_login("damao");
            System.out.println(user.getUser_pass());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
