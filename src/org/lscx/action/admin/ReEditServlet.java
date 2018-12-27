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
        urlPatterns = {"/admin/re-edit.do"},
        name = "reEditServlet"
)

public class ReEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Post post = null;
        int id = Integer.valueOf(req.getParameter("id"));
        try {
            post = DAOFactory.getPostDaoInstance().queryPostByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (post != null) {
            req.setAttribute("post", post);
            req.getRequestDispatcher("update.jsp").forward(req,resp);
        }
    }
}
