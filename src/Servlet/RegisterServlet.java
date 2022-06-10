package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Dto.UserDto;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean flag = false;
		String Uname = req.getParameter("Uname");
		byte source [] = Uname.getBytes("iso8859-1");
        Uname = new String (source,"UTF-8");
        
		String Password = req.getParameter("Password1");
		String sSuper = req.getParameter("sSuper");
		String Uid;
		int deletemark = 1;
		
		UserDao udao = new UserDao();
		UserDto udto = new UserDto();
		
		PrintWriter out = resp.getWriter();/*�����ʾ��*/

		if(udao.FindByUname(Uname) == false)
		{
		int ru = udao.GetRowForUser();/*��ȡ��¼����׼���Զ����*/
		if (ru < 9)// ���ݻ�����Զ����û���
			Uid = "u0" + (ru + 1);
		else
			Uid = "u" +  (ru + 1);
		
		System.out.println("��¼��"+ru);
		System.out.println("�Զ����ɵ�uidΪ"+Uid);
		System.out.println("ע�������sSuperΪ"+sSuper);
		udto.setAll(Uid, Uname, Password, Integer.parseInt(sSuper),deletemark);
		flag = udao.InsertUser(udto);/*����*/
		
		HttpSession s = req.getSession();
		s.setAttribute("Register", udto);
		
		
		if(flag)
			out.print("<script>confirm('Register success!');window.location.href='RegisterOk.jsp'</script>");
		else
			out.print("<script>alert('Register Fail!');window.location.href='Register.jsp'</script>");
		}

	else{
		out.print("<script>confirm('The username is exeist,please write username again!');window.location.href='Register.jsp'</script>");
		System.out.println("This username is exist��");
	}
		

}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
