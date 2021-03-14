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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table
public class Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classId;
	private String className;
	
	//@OneToMany
	//private List<Subjects> subject;
	
	//@OneToOne
	//private Student student;
	
	//@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			//   fetch = FetchType.LAZY)
	//@JoinTable(name="teacher_class",
	//joinColumns=@JoinColumn(name="class_id"), 
	//inverseJoinColumns= @JoinColumn(name="teacher_id")
	//)	
	//private List<Teacher> teacherList;
	
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classes(String className, List<Teacher> teacherList) {
		super();
		this.className = className;				
		//this.teacherList = teacherList;
	}

	public Classes(int classId) {
		this.classId = classId;
	}

	public int getClassId() {
		return classId;
	}
	
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}	


	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + "]";
	}

	
	
}
