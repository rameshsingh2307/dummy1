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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Subjects")
public class Subjects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;
	
	private String subjectName;
	private String subjectAuther;
	private String subjectDetail;
	
	//@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			 //  fetch = FetchType.LAZY)
	//@JoinTable(name="teacher_subject",
	//joinColumns=@JoinColumn(name="subject_id"),
	//inverseJoinColumns= @JoinColumn(name="teacher_id")
			//)
	//private List<Teacher> teacher;
	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToOne
	@JoinTable(name="subject_class",
	joinColumns=@JoinColumn(name="subject_id"),
	inverseJoinColumns= @JoinColumn(name="class_id")
			)
	private Classes classes;

	public Subjects(int subjectId) {
		super();
		this.subjectId = subjectId;
	}
	
	
	
	public Subjects(String subjectName, String subjectAuther, String subjectDetail, Classes classes) {
		super();
		this.subjectName = subjectName;
		this.subjectAuther = subjectAuther;
		this.subjectDetail = subjectDetail;
		this.classes = classes;
	}



	public int getSubjectId() {
		return subjectId;
	}


	
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}



	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public String getSubjectName() {
		return subjectName;
	}

	
	public String getSubjectAuther() {
		return subjectAuther;
	}

	public void setSubjectAuther(String subjectAuther) {
		this.subjectAuther = subjectAuther;
	}

	public String getSubjectDetail() {
		return subjectDetail;
	}

	public void setSubjectDetail(String subjectDetail) {
		this.subjectDetail = subjectDetail;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}



	@Override
	public String toString() {
		return "Subjects [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectAuther=" + subjectAuther
				+ ", subjectDetail=" + subjectDetail + ", classes=" + classes + "]";
	}


	
	

}
