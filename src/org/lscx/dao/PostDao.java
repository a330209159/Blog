package org.lscx.dao;

import org.lscx.pojo.Post;
import java.util.List;

public interface PostDao {
    boolean addPost(Post post) throws Exception;
    List<Post> showAllPosts() throws Exception;
    Post queryPostByID(int ID) throws Exception;
    boolean updatePostByID(Post post,int ID) throws Exception;

}
