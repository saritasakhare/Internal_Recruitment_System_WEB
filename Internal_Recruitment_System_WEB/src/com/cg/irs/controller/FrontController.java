package com.cg.irs.controller;

import java.io.IOException;



import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.irs.entity.UserBean;
import com.cg.irs.service.IUserService;

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
		
		if(path.equals("/processLogin.mvc")||path.equals("/login.mvc"))
		{
			chain.doFilter(request, response);
			return ;
			
		}else if(!(path.endsWith(".jsp")||path.endsWith(".mvc")))
		{
				chain.doFilter(request, response);
				return;
		}
		else
		{
			
			HttpSession session = req.getSession(false);
				
			if(session!=null)
			{
				UserBean user = (UserBean) session.getAttribute("user");
				//System.out.println("user : "+user);
				if(user!=null)
				{
					chain.doFilter(req, res);
					return;
				}else
				{
					//System.out.print("\nuser null forwording to login.mvc");
					req.getRequestDispatcher("login.mvc").forward(request, response);
				}
			}else
			{
				//System.out.print("\nuser null forwording to login.mvc");
				req.getRequestDispatcher("login.mvc").forward(request, response);
			}
		}
	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
