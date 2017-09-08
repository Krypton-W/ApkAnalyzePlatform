package com.analysis.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.analysis.hibernate.User;

/**
 * Servlet implementation class loginJudge
 */
@WebServlet(
		urlPatterns = { "/loginJudge" }, 
		initParams = { 
				@WebInitParam(name = "loginJudge", value = "")
		})
public class loginJudge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginJudge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password =request.getParameter("password");
		String username = request.getParameter("username");
		
		Configuration conf = new Configuration().configure();
		//2 根据配置信息,创建 SessionFactory对象
		SessionFactory sf = conf.buildSessionFactory();
		//3 获得session
		Session session = sf.openSession();
		//4 session获得操作事务的Transaction对象
		//获得操作事务的tx对象
		//Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的tx对象(建议使用)
		Transaction tx2 = session.beginTransaction();
		//----------------------------------------------
		User user = new User();  
        Query q = session.createQuery("from User where username=? and password=?");  
        q.setString(0, username);  
        q.setString(1, password);  
        user = (User)q.uniqueResult(); 
        List<User> list=q.list();
        if(list.size()>0)
        {
        	 response.setContentType("text/html;charset=UTF-8");  
             
             //返回html页面  
             response.getWriter().println("<html>");  
             response.getWriter().println("<head>");     
             response.getWriter().println("<title>登录信息</title>");      
             response.getWriter().println("</head>");    
             response.getWriter().println("<body>");     
             response.getWriter().println("欢迎【" + "】用户登录成功！！！");    
             response.getWriter().println("</body>");    
             response.getWriter().println("</html>");  
        }
        else
        {
        	
        }
		//----------------------------------------------
		tx2.commit();//提交事务
		//tx2.rollback();//回滚事务
		session.close();//释放资源
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Test
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password =request.getParameter("password");
		String username = request.getParameter("username");
		
		Configuration conf = new Configuration().configure();
		//2 根据配置信息,创建 SessionFactory对象
		SessionFactory sf = conf.buildSessionFactory();
		//3 获得session
		Session session = sf.openSession();
		//4 session获得操作事务的Transaction对象
		//获得操作事务的tx对象
		//Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的tx对象(建议使用)
		Transaction tx2 = session.beginTransaction();
		//----------------------------------------------
		User user = new User();  
        Query q = session.createQuery("from User where username=? and password=?");  
        q.setString(0, username);  
        q.setString(1, password);  
        user = (User)q.uniqueResult(); 
        List<User> list=q.list();
        if(list.size()>0)
        {
        	 response.setContentType("text/html;charset=UTF-8");  
             
             //返回html页面  
             response.getWriter().println("<html>");  
             response.getWriter().println("<head>");     
             response.getWriter().println("<title>登录信息</title>");      
             response.getWriter().println("</head>");    
             response.getWriter().println("<body>");     
             response.getWriter().println("欢迎【" + "】用户登录成功！！！");    
             response.getWriter().println("</body>");    
             response.getWriter().println("</html>");  
        }
        else
        {
        	
        }
		//----------------------------------------------
		tx2.commit();//提交事务
		//tx2.rollback();//回滚事务
		session.close();//释放资源
		
	}

}
