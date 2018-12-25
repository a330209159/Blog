package org.lscx.action.admin;

import org.lscx.factory.DAOFactory;
import org.lscx.pojo.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
        urlPatterns = {"/admin/post.do"},
        name = "postServlet"
)
public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean flag = false;
        String successMessage = null,failedMessage = null;
        Post post = new Post();
        Post done_post=null;
        try {
            String post_title = (String) req.getParameter("post_title");
            String post_content = (String) req.getParameter("post_content");
            int post_author = Integer.parseInt(req.getParameter("post_author"));
            successMessage = String.format("恭喜,文章【%s】发布成功",post_title);
            failedMessage = String.format("抱歉,文章【%s】发布失败",post_title);
            post.setPost_title(post_title);
            post.setPost_content(post_content);
            post.setPost_author(post_author);
            flag = DAOFactory.getPostDaoInstance().addPost(post);
            done_post = DAOFactory.getPostDaoInstance().queryPostByPost_title(post_title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag && done_post !=null){
            req.setAttribute("post",done_post);
            req.setAttribute("status",successMessage);
            req.getRequestDispatcher("status/success.jsp").forward(req,resp);
        }else{
            req.setAttribute("status",failedMessage);
            req.getRequestDispatcher("status/failed.jsp").forward(req,resp);

        }
    }
}
