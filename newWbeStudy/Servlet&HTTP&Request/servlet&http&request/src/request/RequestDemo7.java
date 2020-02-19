package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * 获取请求参数
 */
@WebServlet("/requestDemo7")
public class RequestDemo7 extends HttpServlet {
    //post方式获取
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置流的编码
        request.setCharacterEncoding("utf-8");//regist2.html参数提交到这里，故这里的编码应该regist2.html编码相同

        //获取请求参数username
        String username = request.getParameter("username");
        System.out.println(username);
    }

    //get方式获取
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
