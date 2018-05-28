package com.china.imgservlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class imgservlet
 */
@WebServlet("/imgservlet")
public class imgservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imgservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random ran = new Random();
		//设置图片大小
		int w = 100;
		int h = 30;
		//设置验证码中的字体的大小
		Font font = new Font("宋体",Font.ITALIC,20);
		
		//设置背景颜色
		int r = ran.nextInt(225);
		int g = ran.nextInt(225);
		int b = ran.nextInt(225);
		Color color = new Color(r,g,b);
		//生成图片
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		//图片中添加字体
		Graphics pen = img.getGraphics();//所有图像上下文的基类
		pen.setColor(color);//设定颜色
		pen.fillRect(0, 0, w, h);//填充指定的矩形
		pen.setFont(font);//设置上下文的字体
		String str = "";//设置一个空的字符串
		
		for(int i = 0; i<4;i++){//产生4个随机的字符
			String temp = getnumber();
			str +=temp;
			pen.setColor(new Color(ran.nextInt(120)+20));
		}
		
		for(int i = 0;i<4;i++){
			int x = ran.nextInt(12);
			int y = ran.nextInt(12);
			int x1 = ran.nextInt(w-12);
			int y1 = ran.nextInt(h-12);
			pen.drawLine(x, y, x1, y1);
			
		}
		pen.drawString(str, ran.nextInt(10)+20, 20);//随机字符x y 坐标
		ImageIO.write(img, "jpg", response.getOutputStream());  
	}
	
	private String getnumber(){//创建获取随机数。字母的方法
		String str01 = null;//创建一个空的字符串
		char ch ;
		int temp;
		int ran =(int) (Math.random()*3);
		if(ran==0){
			temp = (int)(Math.random()*26)+65;//随机大写字母对应的ASCII数字
			ch =(char)(temp);
			str01 = String.valueOf(ch);
		}
		if(ran==1){
			temp = (int)(Math.random()*26)+97;//随机小写字母
			ch =(char)(temp);
			str01 = String.valueOf(ch);
		}
		if(ran==2){
			temp = (int)(Math.random()*10);//随机数字
			str01 = String.valueOf(temp);
		}
		
		
		return str01;
	}
	

}
