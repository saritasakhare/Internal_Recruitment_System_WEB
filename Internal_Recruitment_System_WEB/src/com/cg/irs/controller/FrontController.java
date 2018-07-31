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

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Servlet Filter implementation class FirstController
 */
@WebFilter("/FirstController")
public class FrontController implements Filter {

    /**
     * Default constructor. 
     */
    public FrontController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res =(HttpServletResponse) response;
		String path = "Error";
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
			HttpSession session =req.getSession(false);		
			if(session==null)
				path="tologin.mvc";
			break;
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
