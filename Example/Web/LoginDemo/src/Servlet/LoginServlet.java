package Servlet;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        String chenkCode = request.getParameter("checkCode");
        Map<String, String[]> map = new HashMap<String, String[]>(request.getParameterMap());
        map.remove("checkCode");
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.先判断验证码是否正确
        //3.1获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        //登录之前、获取验证码之后，要删除session中存储的验证码，保证只能用一次
        session.removeAttribute("checkCode_session");
        //3.2判断：忽略大小写，比较字符串，判断用户名和密码是否一致
        if(checkCode_session!=null && checkCode_session.equalsIgnoreCase(chenkCode)){
            //验证码一致
            UserDao dao = new UserDao();
            User user = dao.login(loginUser);
            if(user==null){//登录失败
                //存储提示信息到request
                request.setAttribute("login_error","用户名或密码错误");
                //转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {//登录成功
                //存储用户信息
                session.setAttribute("user",user);
                //重定向到successServlet
                response.sendRedirect(request.getContextPath()+"/successServlet");
            }
        }else {
            //验证码不一致
            //存储提示信息到request
            request.setAttribute("checkCode_error","验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
