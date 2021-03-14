package com.learner.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	private String teacherName;
	private String qualification;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			   fetch = FetchType.LAZY)
	@JoinTable(name="teacher_subject",
	joinColumns=@JoinColumn(name="teacher_id"), 
	inverseJoinColumns= @JoinColumn(name="subject_id")
	)	
	private List<Subjects> subjects;
	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			   fetch = FetchType.LAZY)
	@JoinTable(name="teacher_class",
	joinColumns=@JoinColumn(name="teacher_id"), 
	inverseJoinColumns= @JoinColumn(name="class_id")
	)	
	private List<Classes> classes;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String teacherName, List<Subjects> subjects, List<Classes> classes, String qualification) {
		super();
		this.teacherName = teacherName;
		this.subjects = subjects;
		this.qualification = qualification;
		this.classes = classes;
	}

	public int getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}
	
}
