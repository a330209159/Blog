package org.lscx.action.front;

import com.google.gson.Gson;
import org.lscx.factory.DAOFactory;
import org.lscx.pojo.Post;
import org.lscx.utils.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/load.do"},
        name = "loadPostServlet"
)
public class LoadPostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNum = Integer.valueOf(req.getParameter("pagenum"));
        List<Post> posts=null;

        try {
            posts = DAOFactory.getPostDaoInstance().limitQueryPostsByPage(pageNum+1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Tools.processContent(posts);
        Gson gson = new Gson();
        String json = gson.toJson(posts);
        resp.getWriter().print(json);


    }
}
