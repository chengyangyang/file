package com.china.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class queryServlet
 */
@WebServlet("/queryServlet")
public class queryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryServlet() {
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
		 response.setContentType("text/xml");//������Ӧ�ĸ�ʽ
		 request.setCharacterEncoding("UTF-8");//������������
	       response.setCharacterEncoding("UTF-8");
	       PrintWriter out=response.getWriter();//����һ�������
	       String name=request.getParameter("search");//��ò���ֵ
	       System.out.println(name);
	       List<String> list=new ArrayList<>();
	         list.add("�Ծ�");
	         list.add("�Կ�");
	         list.add("bbc");
	         list.add("bbq");
	         list.add("qaqa");
	         list.add("qqq");
	         
	         StringBuffer sb=new StringBuffer();
	         sb.append("<words>"); 
	         for (String str : list) {
				if(str.indexOf(name)==0){
					     sb.append("<word>");
					     sb.append(str);
					     sb.append("</word>");
				}
			}
	        	sb.append("</words>"); 
	        	
	        	out.print(sb);
	        	out.flush();
	        	out.close();
		
		
		
	}

}
