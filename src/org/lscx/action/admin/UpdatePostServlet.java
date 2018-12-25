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
        urlPatterns = {"/admin/update.do"},
        name = "updatePostServlet"

)
public class UpdatePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean flag = false;
        String post_title = req.getParameter("post_title");
        String post_content = req.getParameter("post_content");
        String successMessage = String.format("恭喜,文章【%s】更新成功",post_title);
        String failedMessage = String.format("抱歉,文章【%s】更新失败",post_title);

        int ID = Integer.valueOf(req.getParameter("ID"));
        Post post = new Post();
        post.setID(ID);
        post.setPost_title(post_title);
        post.setPost_content(post_content);
        try {
            flag = DAOFactory.getPostDaoInstance().updatePostByID(post,ID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(flag){
            req.setAttribute("status",successMessage);
            req.setAttribute("post",post);
            req.getRequestDispatcher("status/success.jsp").forward(req,resp);
        }else{
            req.setAttribute("status",failedMessage);
            req.getRequestDispatcher("status/failed.jsp").forward(req,resp);
        }
    }
}
