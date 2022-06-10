package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.lang.model.element.Element;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.*;
import Dto.ActivityDto;
import Dto.ConDto;
import Dto.ExaminerDto;
import Dto.UserDto;

public class AllDelTableServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		PrintWriter out = resp.getWriter();/*�����ʾ��*/
		//1.��ȡ�ͻ����ύ�Ĳ���
		HttpSession s =req.getSession();
		String sSuper1 = req.getParameter("sSuper");
		Integer sSuper = Integer.valueOf(sSuper1);
		System.out.println("����������б�ɾ����");
		System.out.println("sSuper:"+sSuper);
		
		String Uname = new String(req.getParameter("Uname").getBytes("ISO-8859-1"));
		System.out.println("AllTableDelServlet������յ���Uname="+Uname);
		/*��������������Ա�˵���ʾ����*/
		s.setAttribute("sSuper", sSuper);
		s.setAttribute("Uname", Uname);
		//3.���ݷ��صĽ������
		
		/*��ѯ���б�*/
		/*�������л��*/
		ActivityDao a = new ActivityDao();
		Vector<ActivityDto> v1 = a.FindAllDelActivity();
		s.setAttribute("AllActivity", v1);

		/*�������л��������*/
		ConDao c = new ConDao();
		Vector<ConDto> v2 = c.FindAlDelCondition();
		s.setAttribute("AllCondition", v2);
		
		/*���������û�,����Ա�����ʸ񿴵������û�*/
		UserDao u = new UserDao();
		Vector<UserDto> v3 = u.AllDelUser();	
		s.setAttribute("AllUser", v3);
		
		/*�������������*/
		ExaminerDao e = new ExaminerDao();
		Vector<ExaminerDto> v4 = e.FindAllDelExaminer();
		s.setAttribute("AllExaminer", v4);

		
		
		if(sSuper !=0)
				/*out.print("<script>confirm('Welcome, administrator .');window.location.href='AllTable1.jsp'</script>");*/
				resp.sendRedirect(req.getContextPath()+"/admin/AllTable1_del.jsp");
			
		else
			out.print("<script>confirm('Fail!');window.location.href='../Login.jsp'</script>");
	}
}
