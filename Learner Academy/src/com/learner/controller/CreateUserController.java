package com.learner.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learner.dao.UserDao;
import com.learner.dto.AdminUser;


@WebServlet("/UserController")
public class CreateUserController extends HttpServlet {	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter pw = response.getWriter();
		AdminUser user=new AdminUser();
		user.setLoginId(request.getParameter("loginId"));
		user.setLoginId(request.getParameter("name"));
		user.setLoginId(request.getParameter("password"));
		user.setLoginId(request.getParameter("role"));
		
		UserDao userDao = new UserDao();
		userDao.saveUser(user);
				
		pw.print("Registered successfully!!!!");
	}

}
