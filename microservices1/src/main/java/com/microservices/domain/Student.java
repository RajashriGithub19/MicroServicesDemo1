package com.microservices.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * @Author - Rajashri Rane
 * class represent Customer Domain entity
 * 
 */

@Entity
@Table(name = "student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3660146912348060214L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STUDENTID")
	private Integer studentId;

	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENTID"), inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "SUBJECTID"))
	private Set<Subject> subjects;

	public Student() {
	}	
	
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Student(Integer studentId, String firstName, String lastName, Set<Subject> subjects) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subjects = subjects;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {

		String student = "";

		JSONObject studentInfo = new JSONObject();
		try {
			studentInfo.put("Firstname", this.firstName);
			studentInfo.put("LastName", this.lastName);

			JSONArray subArr = new JSONArray();

			this.subjects.forEach(sub -> {
				JSONObject subObj = new JSONObject();
				try {
					subObj.put("name", ((Subject) sub).getName());
					subArr.put(subObj);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			studentInfo.put("subjects", subArr);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		student = studentInfo.toString();

		return student;
		// return "Student [studentId=" + studentId + ", firstName=" + firstName + ",
		// lastName=" + lastName + ", subjects="
		// + subjects + "]";
	}

}
