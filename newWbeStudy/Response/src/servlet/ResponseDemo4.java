package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 服务器输出字符数据到浏览器
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码：ISO-8859-1 设置为 GBK
            //response.setCharacterEncoding("utf-8");
        //告诉浏览器 服务器发送的消息体数据的编码，建议浏览器使用该编码解码
            //response.setHeader("content-type","text/html;charset=utf-8");//设置流的编码，告诉客户端当前使用的编码
        //简单的形式设置编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter pw = response.getWriter();
        //2.输出数据
//        pw.write("hello response");//hello response：响应消息体；若写的是html标签，浏览器会自动解析，展示相应的样式
//        pw.write("<h1>hello response</h1>");
        /* print()可以自动刷新，自动把数据写出缓冲区；
         * 在这里不用刷新，因为pw是response获取的，response在一次响应完成后会自动被销毁，其获取的流也会自动被关闭掉
         * 故在这里使用write也可以实现不刷新就把数据写出缓冲区
         */
        pw.write("你好呀");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
