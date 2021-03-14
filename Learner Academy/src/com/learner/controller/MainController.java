package com.learner.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learner.dao.UserDao;
import com.learner.dto.AdminUser;
import com.learner.dto.Classes;
import com.learner.dto.Student;
import com.learner.dto.Subjects;
import com.learner.dto.Teacher;
import com.learner.dto.User;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String path=request.getServletPath();
		try
		{
			switch(path)
			{
				case "/new":				
					newUser(request, response);		
					break;
				case "/CreateUser":				
					CreateUser(request, response);		
					break;
				case "/login":				
					userLogin(request, response);		
					break;
				case "/loginCheck":				
					loginCheck(request, response);		
					break;
				case "/AddSubject":				
					subjectForm(request, response);		
					break;
				case "/AddClasses":				
					classForm(request, response);		
					break;
				case "/AddTeacher":				
					teacherForm(request, response);		
					break;
				case "/AddStudent":				
					studentForm(request, response);		
					break;
				case "/createSubject":				
					createSubject(request, response);		
					break;	
				case "/createTeacher":				
					createTeacher(request, response);		
					break;
				case "/createClass":				
					createClass(request, response);		
					break;
				case "/createStudent":				
					createStudent(request, response);		
					break;	
				case "/listStudent":				
					listStudent(request, response);		
					break;
				case "/viewReport":				
					viewReport(request, response);		
					break;
				case "/displayRepoprt":				
					displayRepoprt(request, response);		
					break;	
				case "/assignSubClass":				
					assignSubClass(request, response);		
					break;
				case "/assingClassToSubject":				
					assingClassToSubject(request, response);		
					break;	
				case "/assignTechSub":				
					assignTechSub(request, response);		
					break;
				case "/assingTeacherToSubject":				
					assingTeacherToSubject(request, response);		
					break;						
				case "/assignTechClass":				
					assignTechClass(request, response);		
					break;
				case "/assingTeacherToClass":				
					assingTeacherToClass(request, response);		
					break;
				case "/assignStudentClass":				
					assignStudentClass(request, response);		
					break;
				case "/assingStudentToClass":				
					assingStudentToClass(request, response);		
					break;
					
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}	
	
	private void assingStudentToClass(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter pw = response.getWriter();
		Student student = new Student();
		Classes classes = new Classes();
		student.setStudentId(Integer.parseInt(request.getParameter("students")));
		classes.setClassId(Integer.parseInt(request.getParameter("classes")));
		//student.setClasses(classes);
		System.out.println("Inside student to classes "+classes);
		UserDao user = new UserDao();
		if(user.assingStudentToClass(student, classes))			
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Student successfully assigned to class...</center></font></b>");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("AssignStudentForClass.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Details are not set correctly...</center></font></b>");
		}
	}

	private void assignStudentClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		UserDao user = new UserDao();
		
		List<Student> studentList=null;		
		studentList=user.getStudentListNullWithClass();
		
		List<Classes> classesList=null;		
		classesList=user.getClassList();
		if(!studentList.isEmpty())
		{
			request.setAttribute("studentList", studentList);
			request.setAttribute("classesList", classesList);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("AssignStudentForClass.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>All students to already assigned to classes...</center></font></b>");
		}
	}

	private void assingTeacherToClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Teacher teacher = new Teacher();
		List<Classes> classList = new ArrayList<Classes>();
		
		teacher.setTeacherId(Integer.parseInt(request.getParameter("teachers")));		
		
		String [] classesIdList=request.getParameterValues("classes");
		
		
		for(int i = 0;i<classesIdList.length;i++)
		{			
			classList.add(new Classes(Integer.parseInt(classesIdList[i])));
		}
		
		
		//teacher.setSubjects(subjectList);
		
		UserDao user = new UserDao();
		if(user.assingTeacherToClasses(teacher, classList))			
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Teacher successfully assigned to class...</center></font></b>");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("AssignTeacherForClass.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Details are not selected correctly...</center></font></b>");
		}
	}

	private void assignTechClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		UserDao user = new UserDao();
		
		List<Teacher> teacherList=null;		
		teacherList=user.getTeacherListNullWithClass();
		
		List<Classes> classesList=null;		
		classesList=user.getClassList();
		if(!teacherList.isEmpty())
		{
			request.setAttribute("teacherList", teacherList);
			request.setAttribute("classesList", classesList);
			
			RequestDispatcher rd = request.getRequestDispatcher("AssignTeacherForClass.jsp");
			rd.forward(request, response);								
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>All Teachers to already assigned to classes...</center></font></b>");
		}
	}

	private void assingTeacherToSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Teacher teacher = new Teacher();
		List<Subjects> subjectList = new ArrayList<Subjects>();
		
		teacher.setTeacherId(Integer.parseInt(request.getParameter("teachers")));		
		
		String [] subjectIdList=request.getParameterValues("subjects");
		
		
		for(int i = 0;i<subjectIdList.length;i++)
		{			
			subjectList.add(new Subjects(Integer.parseInt(subjectIdList[i])));
		}
		
		
		//teacher.setSubjects(subjectList);
		
		UserDao user = new UserDao();
		if(user.assingTeacherToSubject(teacher, subjectList))			
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Teacher successfully assigned to subject...</center></font></b>");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("AssignTeacherForSubject.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Details are not selected correctly...</center></font></b>");
		}
	}

	private void assignTechSub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		UserDao user = new UserDao();
		
		List<Teacher> teacherList=null;		
		teacherList=user.getTeacherListNull();
		
		List<Subjects> subjectList = null;
		
		
		System.out.println("Assign teacher to subject "+subjectList);
		subjectList = user.getSubjectList();
		if(!teacherList.isEmpty())
		{			
			request.setAttribute("teacherList", teacherList);
			request.setAttribute("subjectList", subjectList);
			
			RequestDispatcher rd = request.getRequestDispatcher("AssignTeacherForSubject.jsp");
			rd.forward(request, response);		
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>All Teachers to already assigned to subjects...</center></font></b>");
		}
	}
	
	private void assingClassToSubject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter pw = response.getWriter();
		Subjects subject = new Subjects();
		Classes classes = new Classes();
		subject.setSubjectId(Integer.parseInt(request.getParameter("subjects")));
		classes.setClassId(Integer.parseInt(request.getParameter("classes")));
		subject.setClasses(classes);
		UserDao user = new UserDao();
		if(user.assingClassToSubject(subject, classes))			
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Subject successfully assigned to class...</center></font></b>");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("AssignSubjectsForClass.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Details are not set correctly...</center></font></b>");
		}
	}

	private void assignSubClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		UserDao user = new UserDao();
		
		List<Classes> classesList=null;		
		classesList=user.getClassList();
		
		List<Subjects> subjectList = null;
		
		subjectList = user.getSubjectListNull();
		if(!subjectList.isEmpty())
		{
			request.setAttribute("classesList", classesList);
			request.setAttribute("subjectList", subjectList);
			
			RequestDispatcher rd = request.getRequestDispatcher("AssignSubjectsForClass.jsp");
			rd.forward(request, response);		
							
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>All subjects to already assigned to classes...</center></font></b>");
		}
	}

	private void displayRepoprt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Classes classes=new Classes();
		List<Subjects> subjectList = null;
		List<Teacher> teacherList = null;
		List<Student> studentList = null;
		if(request.getParameter("classes")!=null)
		{
			classes.setClassId(Integer.parseInt(request.getParameter("classes")));
			UserDao user = new UserDao();
			subjectList = user.getSubjectList(classes);		
			teacherList = user.getTeacherList(classes);
			studentList = user.getStudentList(classes);
			
			request.setAttribute("subjectList", subjectList);
			request.setAttribute("teacherList", teacherList);
			request.setAttribute("studentList", studentList);
			
			RequestDispatcher rd = request.getRequestDispatcher("displayRepoprt.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>There are no classes created. Please make class entry first..</center></font></b>");
		}
	}

	private void viewReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Classes> classesList=null;
		
		UserDao user = new UserDao();
		classesList=user.getClassList();
		
		System.out.println("view report " +classesList);
		request.setAttribute("classesList", classesList);
		RequestDispatcher rd = request.getRequestDispatcher("searchReport.jsp");
		rd.forward(request, response);
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter pw = response.getWriter();
		UserDao user = new UserDao();
		List<Student> studentList = user.getStudentList();
		
		request.setAttribute("studentList", studentList);
		RequestDispatcher rd = request.getRequestDispatcher("list-student.jsp");
		rd.forward(request, response);
	}

	private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter pw = response.getWriter();
		
		Student student = new Student();
		Classes classes = new Classes();
		student.setStudentName(request.getParameter("studentName"));
		
		if(request.getParameter("classes")!=null)
		{
			classes.setClassId(Integer.parseInt(request.getParameter("classes")));
			student.setClasses(classes);
		}
		//System.out.println(request.getParameter("studentName")+" "+Integer.parseInt(request.getParameter("classes")));
		
		UserDao user = new UserDao();
		
		if (user.createStudent(student))
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Student added successfully...</center></font></b>");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("studentForm.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\">Kindly enter student details correctly...</font></b>");
		}
	}

	private void createClass(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter pw = response.getWriter();
		
		Classes classes = new Classes();
		classes.setClassName(request.getParameter("className"));

		UserDao user = new UserDao();
		if (user.createClass(classes))
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Class added successfully...</center></font></b>");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("classForm.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\">Kindly enter class details correctly...</font></b>");
		}
	}

	private void createTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter pw = response.getWriter();
		
		Teacher teacher = new Teacher();
		List<Subjects> subjectList=new ArrayList<Subjects>();
		List<Classes> classList=new ArrayList<Classes>();
		
		Subjects subjects=new Subjects();
		
		teacher.setTeacherName(request.getParameter("teacherName"));
		teacher.setQualification(request.getParameter("qualification"));
		
		String [] subjectIdList=request.getParameterValues("subjects");
		
		if(subjectIdList!=null && subjectIdList.length>0)
		{
			for(int i = 0;i<subjectIdList.length;i++)
			{			
				subjectList.add(new Subjects(Integer.parseInt(subjectIdList[i])));
			}
			
			teacher.setSubjects(subjectList);
		}
		
		String [] classIdList = request.getParameterValues("classes");
		if(classIdList!=null && classIdList.length>0)
		{
			
			for(int i = 0;i<classIdList.length;i++)
			{			
				classList.add(new Classes(Integer.parseInt(classIdList[i])));
			}
			
			teacher.setClasses(classList);
		}
		UserDao user = new UserDao();
		
		if (user.createTeacher(teacher))
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Teacher added successfully...</center></font></b>");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("teacherForm.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\">Kindly enter teacher details correctly...</font></b>");
		}
		
		
	}

	private void createSubject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter pw = response.getWriter();
		Subjects subject = new Subjects();
		UserDao user = new UserDao();
		subject.setSubjectName(request.getParameter("subjectName"));
		subject.setSubjectAuther(request.getParameter("subjectAuther"));
		subject.setSubjectDetail(request.getParameter("subjectDetail"));
		String classId= request.getParameter("classes");
		if(classId!=null)
		{
			Classes classes = new Classes();		
			classes.setClassId(Integer.parseInt(request.getParameter("classes")));
			subject.setClasses(classes);
			System.out.println(classes);
		}
		
		
		if (user.createSubject(subject))
		{
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Subject added successfully...</center></font></b>");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Kindly enter subjects details correctly...</center></font></b>");
		}
	}

	private void studentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao user = new UserDao();
		List<Classes> classesList = user.getClassList();
		
		request.setAttribute("classesList", classesList);	
		
		RequestDispatcher rd = request.getRequestDispatcher("studentForm.jsp");
		rd.forward(request, response);
	}

	private void teacherForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subjects> subjectList = null;
		List<Classes> classList = null;
		
		UserDao user = new UserDao();
		
		subjectList = user.getSubjectList();
		
		classList = user.getClassList();
		
		request.setAttribute("subjectList",subjectList);
		request.setAttribute("classList",classList);
		
		RequestDispatcher rd = request.getRequestDispatcher("teacherForm.jsp");
		rd.forward(request, response);
	}

	private void classForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("classForm.jsp");
		rd.forward(request, response);
	}

	private void subjectForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao user1 = new UserDao();
		List<Classes> classList = null;
		classList = user1.getClassList();				
		request.setAttribute("classList",classList);
		
		RequestDispatcher rd = request.getRequestDispatcher("subjectForm.jsp");
		rd.forward(request, response);
	}

	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
	}
	
	private void loginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		UserDao userDao = new UserDao();
		User user = new User();
		
		user.setLoginId(request.getParameter("loginId"));
		user.setPassword(request.getParameter("password"));
		if (userDao.userLogin(user))
		{
			RequestDispatcher rd=request.getRequestDispatcher("MainPage.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>Kindly enter correct login credintials</center></font></b>");
		}
		
	}

	public void newUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		RequestDispatcher rd = request.getRequestDispatcher("NewUser.jsp");
		rd.forward(request, response);
	}
	
	public void CreateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw = response.getWriter();
		UserDao userDao = new UserDao();
		AdminUser adminUser = new AdminUser();
		adminUser.setName(request.getParameter("name"));
		adminUser.setLoginId(request.getParameter("loginId"));
		adminUser.setPassword(request.getParameter("password"));
		adminUser.setRole(request.getParameter("role"));
		System.out.println(adminUser);
		if(userDao.saveUser(adminUser))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);		
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Error_1.jsp");
			rd.include(request, response);
			pw.println("<b><font color=\"red\"><center>User not created. Try again..</center></font></b>");
		}
		
		
	}

}
