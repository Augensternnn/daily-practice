package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        //1."创建"验证码图片
        BufferedImage image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);

        //2."画"验证码
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.orange);//设置画笔颜色
        g.fillRect(0,0,width,height);//填充背景色
        g.setColor(Color.red);
        g.drawRect(0,0,width-1,height-1);//画边框

        //"写验证码"
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        Random ran = new Random();
        StringBuilder s = new StringBuilder();
        for(int i = 1; i <= 4; i++){
            int index = ran.nextInt(str.length());//获取随机角标
            char ch = str.charAt(index);
            s.append(ch);
            g.drawString(ch+"",width/5*i,height/2);//"写验证码"
        }
        String checkCode_session = s.toString();
        request.getSession().setAttribute("checkCode_session",checkCode_session);//将生产的验证码存入session

        //"画"干扰线
        g.setColor(Color.gray);
        for(int i = 0; i < 10; i++){
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        //3.将验证码输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
