package com.learner.DB;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.learner.dto.AdminUser;
import com.learner.dto.Classes;
import com.learner.dto.Student;
import com.learner.dto.Subjects;
import com.learner.dto.Teacher;

public class HibernateConfig {
	
	private static SessionFactory sessionFactory;

	 public static SessionFactory getSessionFactory() {
	  if (sessionFactory == null) {
	   try {
	    Configuration configuration = new Configuration();

	    // Hibernate settings equivalent to hibernate.cfg.xml's properties
	    Properties settings = new Properties();
	    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/DB_LearnAcademy?useSSL=false");
	    settings.put(Environment.USER, "root");
	    settings.put(Environment.PASS, "root");
	    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

	    settings.put(Environment.SHOW_SQL, "true");

	    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	    settings.put(Environment.HBM2DDL_AUTO, "update");

	   configuration.setProperties(settings);
	   configuration.addAnnotatedClass(AdminUser.class);
	   configuration.addAnnotatedClass(Subjects.class);
	   configuration.addAnnotatedClass(Teacher.class);
	   configuration.addAnnotatedClass(Classes.class);
	   configuration.addAnnotatedClass(Student.class);
	    
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	      .applySettings(configuration.getProperties()).build();
	    System.out.println("Hibernate Java Config serviceRegistry created");
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;

	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  return sessionFactory;
	 }
}
