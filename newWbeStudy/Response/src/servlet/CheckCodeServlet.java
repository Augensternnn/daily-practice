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

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        //1.创建一个对象，在内存中代表一个图片(验证码图片对象)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.PINK);//设置画笔颜色
        g.fillRect(0,0,width,height);//Graphics的方法：fillXxx()-->填充；drawXxx()-->画
        //2.2画边框(边框本来有1px的宽度)
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);//(x,y)==(0,0)->坐标点 --> 图片里的坐标点指的是左上角的点
        //2.3写验证码
        //2.3.1生成随机的验证码
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random ran = new Random();
        for(int i = 1; i <= 4; i++){
            int index = ran.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//随机字符
            //写验证码
            g.drawString(ch+"",width/5*i,height/2);
        }
        /*g.drawString("A",20,25);
        g.drawString("B",40,25);
        g.drawString("C",60,25);
        g.drawString("D",80,25);*/
        //2.3.2画干扰线
        g.setColor(Color.CYAN);
        //随机生成坐标点
        for(int i = 0; i < 10; i++){
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());//将内存中的图片写到任意流里面去
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
