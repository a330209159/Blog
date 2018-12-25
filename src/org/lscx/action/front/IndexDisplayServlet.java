package org.lscx.action.front;

import org.lscx.factory.DAOFactory;
import org.lscx.pojo.Post;
import org.lscx.utils.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(
        urlPatterns = {"/index.do"},
        name = "indexDisplayServlet"
)
public class IndexDisplayServlet extends HttpServlet {

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
            for (Post item:posts){
                String text = Tools.Html2Text(item.getPost_content());
                if(text.length()>100){
                    item.setPost_content(text.substring(0,100)+"...");
                }else if (text.length()==0){
                    item.setPost_content("本文可能是由图片组成，请点击下面的按钮来查看全文。");
                }else{
                    item.setPost_content(text);
                }
            }
            req.setAttribute("posts",posts);
        }
        req.getRequestDispatcher("demo.jsp").forward(req,resp);
    }
}
