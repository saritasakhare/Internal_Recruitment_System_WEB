package com.cg.irs.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;
import com.cg.irs.service.IUserService;
import com.cg.irs.service.UserServiceImpl;

@WebFilter("/FirstController")
public class FrontController implements Filter {
	
	@Autowired
	private IUserService userService;
	
	
    public FrontController() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res =(HttpServletResponse) response;
		String path = req.getServletPath();
		
		System.out.print("\n--filter in for - "+path);
		if(path.equals("/processLogin.mvc")||path.equals("/login.mvc"))
		{
			System.out.print("\nlogin process found.");
			chain.doFilter(request, response);
			System.out.println("returning");
			return ;
			
		}else if(!(path.endsWith(".jsp")||path.endsWith(".mvc")))
		{
				chain.doFilter(request, response);
				return;
		}
		else
		{
			String userId = req.getParameter("userId");
			String password = req.getParameter("password");
		
			System.out.print("\n "+userId+" "+password);
			
			HttpSession session = req.getSession(false);
				
			if(session!=null)
			{
				System.out.print("\nsession not null");
				UserBean user = (UserBean) session.getAttribute("user");
				System.out.println("user : "+user);
				if(user!=null)
				{
					chain.doFilter(req, res);
					return;
				}else
				{
					//b1
					
					System.out.print("\nuser null forwording to login.mvc");
					req.getRequestDispatcher("login.mvc").forward(request, response);
					System.out.print("\nafter forwording");
				}
			}else
			{
				System.out.print("\nuser null forwording to login.mvc");
				req.getRequestDispatcher("login.mvc").forward(request, response);
				System.out.print("\nafter forwording");
			}
		}
	
		//b2
		
		
		System.out.print("\nout filter -- for - "+req.getServletPath());
	}
	
	private UserBean validateCredinals(String userId,String password)
	{
		try {
			
			System.out.print("\ngetting user from database ");
			
			UserBean user = userService.login(new UserBean(userId,password));
			
			System.out.println("got user : "+user);
			
			return user;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}


/* b1
					if(userId!=null&&password!=null)
					{
						System.out.println("user :"+userId+" | "+password);
						
						 user = validateCredinals(userId, password);
						 
						if(user!=null)
						{
							System.out.print("\nuser verified forworing to home");
							//session = req.getSession(true);
							session.setAttribute("user",user);
							req.getRequestDispatcher("home.mvc").forward(req, res);
							return;
						}
					}
				
					}else if(userId!=null&&password!=null)
					{
					System.out.println("user null bt got credinals");
					
					UserBean user = validateCredinals(userId, password);
					if(user!=null)
					{
						System.out.print("\nuser verified forworing to home");
						session = req.getSession(true);
						session.setAttribute("user",user);
						req.getRequestDispatcher("home.mvc").forward(req, res);
					}
				}else
				{	*/





/* b2
 * 
 * String path = "Error";
		String key = null;
		key = req.getServletPath();
		System.out.println("Filter is Called"+key);
		switch (key) {
		case "homepage.jsp":
				req.getSession(true);
				path=key;
				System.out.println("case 1");
			break;			
		default:
			System.out.println("case 2");
		 		
			if(session==null)
				path="login.mvc";
			break;
		}*/

//req.getRequestDispatcher(path).forward(request, response);
//res.sendRedirect(path);