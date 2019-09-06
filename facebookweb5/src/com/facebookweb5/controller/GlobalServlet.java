package com.facebookweb5.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb5.entity.FacebookEmployee;
import com.facebookweb5.service.FacebookService;
import com.facebookweb5.service.FacebookServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.setContentType("text/html");
     PrintWriter out=response.getWriter();
     out.println("<html><body>");
      String option=request.getParameter("ac");
      String a=null,b=null;
      FacebookEmployee fe=new FacebookEmployee(); 
      if(option.equals("register"))
      {
    	  
    	  String name=request.getParameter("name");
    	  String password=request.getParameter("password");
    	  String email=request.getParameter("email");
    	  String address=request.getParameter("address");
      
       
        fe.setName(name);
        fe.setPassword(password);
        fe.setEmail(email);
        fe.setAddress(address);
        a=fe.getName();b=fe.getPassword();
        FacebookServiceInterface fs=FacebookService.createServiceObject("f");
        int i=fs.createProfileService(fe);
        if(i>0)
        	out.println("profile created<a href=login.html> login</a>");
        else
        	out.println("not created");
      
      
      }
      if(option.equals("login"))
    	  
      {   
    	  out.println(a+" "+b);
    	  String username=request.getParameter("username");
    	  String pass=request.getParameter("pass1");
    	  if(a==username&&b==pass)
    	  {
    	  out.println("yoyo");
    	  }
    	  else
    		  out.println("babau");
      }
      out.println("</body></html>");
	
	}

}
