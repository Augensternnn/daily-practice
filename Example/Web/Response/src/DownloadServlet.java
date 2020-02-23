import util.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件下载
 * 需求：1. 页面显示超链接
 * 	     2. 点击超链接后弹出下载提示框
 * 	     3. 完成图片文件下载
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数：文件名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        FileInputStream fis = new FileInputStream(realPath);
        //3.设置response响应头
        String mimeType = context.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        //解决中文文件名问题
        String agent = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent,filename);
        response.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len = 0;
        while ((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
