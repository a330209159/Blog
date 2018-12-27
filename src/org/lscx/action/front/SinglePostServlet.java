package org.lscx.action.front;

import org.lscx.dao.PostDao;
import org.lscx.factory.DAOFactory;
import org.lscx.pojo.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/single"},
        name = "singlePostServlet"
)
public class SinglePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Post post = null;
        List<Post> posts = null;
        int id = Integer.valueOf(req.getParameter("id"));
        try {
            post = DAOFactory.getPostDaoInstance().queryPostByID(id);
            posts = DAOFactory.getPostDaoInstance().showAllPosts();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(post != null && posts != null){
            req.setAttribute("post",post);
            req.setAttribute("posts",posts);
            req.getRequestDispatcher("single.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("error-404.html");
        }
    }
}
