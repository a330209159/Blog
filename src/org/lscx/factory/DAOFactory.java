package org.lscx.factory;

import org.lscx.dao.PostDao;
import org.lscx.dao.UserDao;
import org.lscx.service.PostService;
import org.lscx.service.UserService;

public class DAOFactory {
    public static UserDao getUserDaoInstance() throws Exception {
        return new UserService();
    }
    public static PostDao getPostDaoInstance() throws Exception {
        return new PostService();
    }
}
