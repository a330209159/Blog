package org.lscx.action.admin;

import org.lscx.factory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
        urlPatterns = {"/admin/delete.do"},
        name = "deletePostServlet"
)
public class DeletePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ID = Integer.valueOf(req.getParameter("id"));
        boolean flag = false;
        try {
            flag = DAOFactory.getPostDaoInstance().deletePostByID(ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag){
            resp.sendRedirect("showPosts.do");
        }else{
            System.out.println("delete post error.");
        }
    }
}
