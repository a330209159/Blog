package org.lscx.action.admin;

import org.lscx.factory.DAOFactory;
import org.lscx.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/login"},
        name = "loginServlet"
)

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_login = req.getParameter("log");
        String user_pass = req.getParameter("pwd");
        String path = null;
        boolean flag = false;
        try{
            User user = DAOFactory.getUserDaoInstance().queryByUser_login(user_login);
            if(user != null){
                if(user_pass.equals(user.getUser_pass())){
                    req.getSession().setAttribute("user",user);
                    flag = true;
                }else {
                    req.setAttribute("states", "用户名或密码错误！");
                    path = "login.jsp";
                }
            }else{
                req.setAttribute("states","用户不存在，请检查！");
                path = "login.jsp";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        if(flag) {
            resp.sendRedirect("admin/index.jsp");
        }else{
            req.getRequestDispatcher(path).forward(req, resp);
        }

    }
}
