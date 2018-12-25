package org.lscx.action.admin;

import org.lscx.factory.DAOFactory;
import org.lscx.pojo.Post;
import org.lscx.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/admin/showPosts.do"},
        name = "showPostsServlet"
)

public class ShowPostsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Post> posts = null;
        try {
            posts = DAOFactory.getPostDaoInstance().showAllPosts();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(posts != null){
            req.setAttribute("posts",posts);
        }
        req.getRequestDispatcher("display.jsp").forward(req,resp);
    }
}
