package org.lscx.dao;

import org.lscx.pojo.Post;
import java.util.List;

public interface PostDao {
    boolean addPost(Post post) throws Exception;
    List<Post> showAllPosts() throws Exception;
    Post queryPostByID(int ID) throws Exception;
    boolean updatePostByID(Post post,int ID) throws Exception;
    Post queryPostByPost_title(String post_title) throws Exception;
    boolean deletePostByID(int ID) throws Exception;
    List<Post> limitQueryPostsByPage(int pageNum) throws Exception;
    List<Post> queryRecentPostsTitle(int numbers) throws Exception;
}
