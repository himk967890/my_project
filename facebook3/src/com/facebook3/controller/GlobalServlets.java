package com.facebook3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebook3.entity.FacebookEmployee;
import com.facebook3.service.FacebookService;
import com.facebook3.service.FacebookServiceInterface;

/**
 * Servlet implementation class GlobalServlets
 */
@WebServlet("/GlobalServlets")
public class GlobalServlets extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //to get result in html we use response.setcontenttype
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html><body>");
		String option=request.getParameter("ac");
		if(option.equals("register"))
		{
			String name=request.getParameter("name");
			String password=request.getParameter("pass");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			
			FacebookEmployee fe=new FacebookEmployee();
			fe.setName(name);
			fe.setPassword(password);
			fe.setEmail(email);
			fe.setAddress(address);
			
			FacebookServiceInterface fs=FacebookService.createServiceObject();
			int i=fs.createProfile(fe);
			if(i>0)
			{
				out.println("file is created");
			}
			else
			{
				out.println("file is not created");
			}
			
		}
		out.println("</body></html>");
	
	
	
	
	
	
	}

}
