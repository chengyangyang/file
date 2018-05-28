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
		//����ͼƬ��С
		int w = 100;
		int h = 30;
		//������֤���е�����Ĵ�С
		Font font = new Font("����",Font.ITALIC,20);
		
		//���ñ�����ɫ
		int r = ran.nextInt(225);
		int g = ran.nextInt(225);
		int b = ran.nextInt(225);
		Color color = new Color(r,g,b);
		//����ͼƬ
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		//ͼƬ���������
		Graphics pen = img.getGraphics();//����ͼ�������ĵĻ���
		pen.setColor(color);//�趨��ɫ
		pen.fillRect(0, 0, w, h);//���ָ���ľ���
		pen.setFont(font);//���������ĵ�����
		String str = "";//����һ���յ��ַ���
		
		for(int i = 0; i<4;i++){//����4��������ַ�
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
		pen.drawString(str, ran.nextInt(10)+20, 20);//����ַ�x y ����
		ImageIO.write(img, "jpg", response.getOutputStream());  
	}
	
	private String getnumber(){//������ȡ���������ĸ�ķ���
		String str01 = null;//����һ���յ��ַ���
		char ch ;
		int temp;
		int ran =(int) (Math.random()*3);
		if(ran==0){
			temp = (int)(Math.random()*26)+65;//�����д��ĸ��Ӧ��ASCII����
			ch =(char)(temp);
			str01 = String.valueOf(ch);
		}
		if(ran==1){
			temp = (int)(Math.random()*26)+97;//���Сд��ĸ
			ch =(char)(temp);
			str01 = String.valueOf(ch);
		}
		if(ran==2){
			temp = (int)(Math.random()*10);//�������
			str01 = String.valueOf(temp);
		}
		
		
		return str01;
	}
	

}
