package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;

/**
 * Servlet implementation class UsernameCheckServlet
 */
public class UsernameCheckServlet extends HttpServlet {


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao udao = new UserDao();
		String Uname = request.getParameter("Uname");
		boolean flag = udao.FindByUname(Uname);
		System.out.println("�ж��Ƿ��ظ���");
		if(flag){
			response.getWriter().print("true");
			System.out.println("�û���"+Uname+"�Ѵ���");
		}
		else
			response.getWriter().print("false");
	}

}
