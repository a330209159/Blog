package org.lscx.service;

import org.lscx.dao.PostDao;
import org.lscx.dao.PostDaoImpl;
import org.lscx.db.DBConnection;
import org.lscx.pojo.Post;

public class PostService implements PostDao {
    private DBConnection dbconn;
    private PostDao dao;

    public PostService() throws Exception {
        this.dbconn = new DBConnection();
        this.dao = new PostDaoImpl(dbconn.getConnection());
    }

    @Override
    public boolean addPost(Post post) throws Exception {
        boolean flag = false;
        try{
            if(true){
                flag = dao.addPost(post);
            }
        }catch (Exception e){
            throw e;
        }finally {
            dbconn.close();
        }
        return flag;
    }
}
