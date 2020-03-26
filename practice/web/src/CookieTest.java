import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cookie案例：
 
 
 * 需求：
 
 * 1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 * 分析：可以采用Cookie来完成
 *      在服务器中的Servlet判断是否有一个名为lastTime的cookie
 *          1.有：不是第一次访问
 * 				1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 * 				2. 写回Cookie：lastTime=2018年6月10日11:50:01
 * 			2. 没有：是第一次访问
 * 				1. 响应数据：您好，欢迎您首次访问
 * 				2. 写回Cookie：lastTime=2018年6月10日11:50:01
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应消息体的数据格式及编码
        response.setContentType("text/html;charset=utf-8");

        //获取所有Cookie并遍历Cookie数组
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//没有Cookie为lastTime
        if(cookies!=null && cookies.length>0){
            for (Cookie cookie : cookies) {
                //获取Cookie的名称
                String name = cookie.getName();
                //判断名称是否为lastTime
                if("lastTime".equals(name)){//有该Cookie，不是第一次访问
                    flag = true;//有Cookie为lastTime

                    //获取上次访问时间
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value,"utf-8");//URL解码

                    //重新设置Cookie的值，重新发送Cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String newDate = sdf.format(date);
                    newDate = URLEncoder.encode(newDate,"utf-8");//URL编码
                    cookie.setValue(newDate);
                    cookie.setMaxAge(60*60*24*30);//设置Cookie的存活时间
                    response.addCookie(cookie);

                    //响应数据
                    response.getWriter().write("<h2>欢迎回来！您上次访问时间为："+value+"</h2>");
                    break;
                }
            }
        }
        if(cookies==null || cookies.length==0 || flag==false){//第一次访问
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String value = sdf.format(date);
            value = URLEncoder.encode(value,"utf-8"); //URL编码
            Cookie cookie = new Cookie("lastTime",value);//Cookie
            cookie.setMaxAge(60*60*24*30);//设置Cookie的存活时间
            response.addCookie(cookie);
            response.getWriter().write("<h1>您好，欢迎您首次访问！</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
