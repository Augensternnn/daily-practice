package servlet;

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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//设置编码
        //获取参数
        String checkCode = request.getParameter("checkCode");//用户输入的验证码
        Map map = new HashMap<>(request.getParameterMap());
        map.remove("checkCode");
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //先判断验证码是否正确
        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");//自动生成的验证码
        session.removeAttribute("checkCode_session");//删除session中存储的验证码，保证只能用一次
        //忽略大小写判断
        if(checkCode_session!=null && checkCode_session.equalsIgnoreCase(checkCode)){//验证码一致
            //判断用户名、密码是否正确
            UserDao dao = new UserDao();
            User user = dao.login(loginUser);
            if(user==null){//登录失败
                request.setAttribute("login_error","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);//转发到登录页面
            }else {//登录成功
                session.setAttribute("user",user);//存储用户信息
                response.sendRedirect(request.getContextPath()+"/SuccessServlet");//重定向到SuccessServlet
            }
        }else {//验证码不一致
            request.setAttribute("checkCode_error","验证码错误");//存储提示信息到request
            request.getRequestDispatcher("/login.jsp").forward(request,response);//转发到登录页面
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
