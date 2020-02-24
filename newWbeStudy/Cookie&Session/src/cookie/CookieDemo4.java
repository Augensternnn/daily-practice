package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie在浏览器中保存时间
 * 1. 默认情况下，当浏览器关闭后，Cookie数据被销毁[即保存在浏览器的内存里]
 * 2. 持久化存储：
 * 	    setMaxAge(int seconds)
 * 		    1. 正数：将Cookie数据写到硬盘的文件中，持久化存储；并指定cookie存活时间seconds，时间到后，cookie文件自动失效
 * 			2. 负数：默认值，Cookie数据存在浏览器的内存中，浏览器关闭Cookie数据被销毁
 * 			3. 零：删除cookie信息
 */
@WebServlet("/CookieDemo4")
public class CookieDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie c = new Cookie("msg","setMaxAge");
        //2.设置Cookie的存活时间
//        c.setMaxAge(30);//将Cookie持久化到硬盘，30秒后会自动删除Cookie文件
//        c.setMaxAge(-1);//默认值
        c.setMaxAge(0);
        //3.发送Cookie
        response.addCookie(c);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
