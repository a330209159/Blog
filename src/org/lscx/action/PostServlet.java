package org.lscx.action;

import org.lscx.factory.DAOFactory;
import org.lscx.pojo.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
        urlPatterns = {"/admin/post"},
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
        Post post = new Post();
        try {
            String post_title = (String) req.getParameter("post_title");
            String post_content = (String) req.getParameter("post_content");
            int post_author = Integer.parseInt(req.getParameter("post_author"));
            post.setPost_title(post_title);
            post.setPost_content(post_content);
            post.setPost_author(post_author);
            flag = DAOFactory.getPostDaoInstance().addPost(post);
            req.setAttribute("post",post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag){
            req.getRequestDispatcher("status/success.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("status/failed.jsp").forward(req,resp);
        }
    }
}
