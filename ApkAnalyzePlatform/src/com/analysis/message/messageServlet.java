package com.analysis.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.analysis.cfg.HibernateSessionFactory;
import com.analysis.hibernate.User;

/**
 * Servlet implementation class messageServlet
 */
@WebServlet("/ApkAnalyzePlatform/messageServlet")
public class messageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public messageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ok messagetPost success!");
		String password =request.getParameter("password");
		String password2 =request.getParameter("password2");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		System.out.println(username+" ok and "+password+" ok");
		//----------------------------------------------
		if(!password.equals(password2))
		{
			//response.setCharacterEncoding("UTF-8");
			response.getWriter().print("<script>alert(\"passwords should be the same\");window.history.back();</script>");
		}
		if(email.isEmpty())
		{
			response.getWriter().print("<script>alert(\"Email shouldn't be void.\");window.history.back();</script>");
		}
		else
		{
			Session session=HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setIsAdmin(false);
			user.setUpload(true);
			user.setDownload(true);
			user.setFileSize(1024);
			session.save(user);
			request.getRequestDispatcher("/dashboard.jsp").forward(request,response);
	        tx.commit();
	        HibernateSessionFactory.closeSession();
		}  
		
		
	}

}
