package com.learner.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	
	@OneToOne
	@JoinTable(name="student_class",
	joinColumns=@JoinColumn(name="student_id"), 
	inverseJoinColumns= @JoinColumn(name="class_id")
	)	
	private Classes classes;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentName,Classes classes) {
		super();
		this.studentName = studentName;
		this.classes = classes;
	}

	
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", classes=" + classes + "]";
	}
	
	
}
