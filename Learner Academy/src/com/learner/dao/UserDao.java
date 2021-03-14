package com.learner.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learner.DB.HibernateConfig;
import com.learner.dto.AdminUser;
import com.learner.dto.Classes;
import com.learner.dto.Student;
import com.learner.dto.Subjects;
import com.learner.dto.Teacher;
import com.learner.dto.User;

public class UserDao {
	
	public boolean saveUser(AdminUser user) {
		boolean returnValue=false; 
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(user);
			System.out.println(user);
			// commit transaction
			transaction.commit();
			returnValue = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		return returnValue;
	}
	
	public boolean userLogin(User user)
	{
		boolean returnValue=false; 
		Transaction transaction=null;
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			Query query=session.createQuery("from AdminUser");
			transaction.commit();
			List<AdminUser> userList = query.list();
			
			for(AdminUser adminUser:userList)
			{
				if(adminUser.getRole().equalsIgnoreCase("admin"))
				{
					if(user.getLoginId().equals(adminUser.getLoginId()) && user.getPassword().equals(adminUser.getPassword()))
					{
						returnValue=true;
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return returnValue;
	}

	public boolean createSubject(Subjects subject) {		
		boolean returnValue=false; 
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(subject);			
			transaction.commit();	
			returnValue=true; 
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return returnValue;
	}

	public boolean createTeacher(Teacher teacher) {
		boolean returnValue=false; 
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(teacher);
			transaction.commit();
			returnValue = true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return returnValue;
	}

	public boolean createClass(Classes classes) {
		boolean returnValue=false; 
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(classes);
			transaction.commit();
			returnValue = true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return returnValue;
	}

	public boolean createStudent(Student student) {
		boolean returnValue=false; 
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			returnValue = true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return returnValue;
	}

	public List<Student> getStudentList() {
		Transaction transaction = null;
		List<Student> studentList = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Student");
			studentList = query.list();
			System.out.println(studentList);
			transaction.commit();			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return studentList;
	}

	public List<Classes> getClassList() {
		List<Classes> classesList = null;
		Transaction transaction =null;
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			Query query= session.createQuery("from Classes");
			classesList = query.list();
			transaction.commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return classesList;
	}

	public List<Subjects> getSubjectList() {
		List<Subjects> subjectList=null;
		Transaction transaction = null;
		System.out.println("++++++inside subject list+++++++++++++");
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			//Query query = session.createQuery("from Subjects");
			
			String sql = "select * from subjects";
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	        
			subjectList = query.list();
			transaction.commit();
			System.out.println("subject list " +subjectList);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return subjectList;
	}
	
	public List<Subjects> getSubjectListNull() {
		List<Subjects> subjectList=null;
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			String sql = "select * from subjects where subjectId not in (select subject_id from subject_class)";
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	         
			subjectList = query.list();
			transaction.commit();
			System.out.println(subjectList);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return subjectList;
	}

	public List<Subjects> getSubjectList(Classes classes) {
		List<Subjects> subjectList=null;
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			//Query query = session.createq
			
			//String strQuery = "select s.subjectName from Subjects s where s.subjectId in (select sc.subjectId from Subjects_Classes sc where sc.classId="+classes.getClassId()+")";
			//String strQuery = "select s.subjectName from Subjects s inner join Subjects_Classes sc on s.subjectId in (select sc.subjectId from Subjects_Classes sc where sc.classId="+classes.getClassId()+")";
			 String sql = "select s.subjectName from subjects s where s.subjectId in (select subject_id from subject_class where class_id="+classes.getClassId()+")";
	         
			 SQLQuery query = session.createSQLQuery(sql);
	         query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	         
			//Query query = session.createQuery(strQuery);
			subjectList = query.list();
			transaction.commit();
			System.out.println(subjectList);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return subjectList;
	}

	public List<Teacher> getTeacherList(Classes classes) {
		List<Teacher> TeacherList=null;
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			//Query query = session.createq
			
			//String strQuery = "select s.subjectName from Subjects s where s.subjectId in (select sc.subjectId from Subjects_Classes sc where sc.classId="+classes.getClassId()+")";
			//String strQuery = "select s.subjectName from Subjects s inner join Subjects_Classes sc on s.subjectId in (select sc.subjectId from Subjects_Classes sc where sc.classId="+classes.getClassId()+")";
			 String sql = "select teacherName from teacher where teacherId in (select teacher_Id from teacher_class where class_id="+classes.getClassId()+")";
	         SQLQuery query = session.createSQLQuery(sql);
	         query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	         
			//Query query = session.createQuery(strQuery);
	         TeacherList = query.list();
			transaction.commit();
			System.out.println(TeacherList);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return TeacherList;
	}

	public List<Student> getStudentList(Classes classes) {
		List<Student> studentList=null;
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			 String sql = "select studentName from student where studentId in (select student_Id from student_class where class_id="+classes.getClassId()+")";
	         SQLQuery query = session.createSQLQuery(sql);
	         query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	         
			//Query query = session.createQuery(strQuery);
	         studentList = query.list();
			transaction.commit();
			System.out.println(studentList);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return studentList;
	}

	public boolean assingClassToSubject(Subjects subject,Classes classes) {
		boolean returnValue=false;		
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			 SQLQuery insertQuery=session.createSQLQuery("insert into subject_class(class_id,subject_id) values(?,?)");
			 insertQuery.setParameter(1, classes.getClassId());
			 insertQuery.setParameter(2, subject.getSubjectId());
			 insertQuery.executeUpdate();			 	
			transaction.commit();
			returnValue=true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return returnValue;
	}

	public List<Teacher> getTeacherListNull() {
		List<Teacher> teacherList=null;
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			String sql = "select * from teacher where teacherId not in (select teacher_id from teacher_subject)";
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	         
	        teacherList = query.list();
			transaction.commit();
			System.out.println(teacherList);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return teacherList;
	}
	
	public List<Teacher> getTeacherListNullWithClass() {
		List<Teacher> teacherList=null;
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			String sql = "select * from teacher where teacherId not in (select teacher_id from teacher_class)";
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	         
	        teacherList = query.list();
			transaction.commit();
			System.out.println(teacherList);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return teacherList;
	}
	
	public boolean assingTeacherToSubject(Teacher teacher, List<Subjects> subjectList) {
		boolean returnValue=false;		
		Transaction transaction = null;
		
		List<String> list = new ArrayList<String>();
		
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			int i=0;
			for(Subjects subjects:subjectList)
			{
				
				 SQLQuery insertQuery=session.createSQLQuery("insert into teacher_subject(teacher_id,subject_id) values(?,?)");
				 System.out.println(subjects.getSubjectId());
				 insertQuery.setParameter(1, teacher.getTeacherId());
				 insertQuery.setParameter(2, subjects.getSubjectId());
				 insertQuery.executeUpdate();
			}			 		 	
			transaction.commit();
			returnValue=true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return returnValue;
	}

	public boolean assingTeacherToClasses(Teacher teacher, List<Classes> classList) {
		boolean returnValue=false;		
		Transaction transaction = null;			
		
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			int i=0;
			for(Classes classes:classList)
			{
				
				 SQLQuery insertQuery=session.createSQLQuery("insert into teacher_class(teacher_id,class_id) values(?,?)");
				 
				 insertQuery.setParameter(1, teacher.getTeacherId());
				 insertQuery.setParameter(2, classes.getClassId());
				 insertQuery.executeUpdate();
			}			 		 	
			transaction.commit();
			returnValue=true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return returnValue;
	}

	public List<Student> getStudentListNullWithClass() {
		List<Student> studentList=null;
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			String sql = "select * from student where studentId not in (select student_id from student_class)";
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	         
	        studentList = query.list();
			transaction.commit();
			System.out.println(studentList);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return studentList;
	}

	public boolean assingStudentToClass(Student student, Classes classes) {
		boolean returnValue=false;		
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			 SQLQuery insertQuery=session.createSQLQuery("insert into student_class(class_id,student_id) values(?,?)");
			 insertQuery.setParameter(1, classes.getClassId());
			 insertQuery.setParameter(2, student.getStudentId());
			 insertQuery.executeUpdate();			 	
			 transaction.commit();
			 returnValue=true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return returnValue;
	}
}
