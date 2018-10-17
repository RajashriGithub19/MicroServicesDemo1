package com.microservices.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table(name="subject")
public class Subject implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SUBJECTID")
	private int subjectId;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToMany(mappedBy = "subjects", fetch = FetchType.EAGER)
	private Set<Student> students;

	public Subject(){
    }
	
	public Subject(int subjectId, String name, Set<Student> students) {
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.students = students;
	}
	
	public Subject(String name, Set<Student> students){
    	this.name = name;
    	this.students = students;
    }

	public Subject(String name){
    	this.name = name;
    }    
   
	public int getId() {
		return subjectId;
	}

	public void setId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString(){
		String info = "";
		JSONObject jsonInfo = new JSONObject();
		try {
			jsonInfo.put("name",this.name);
		
			JSONArray studentArray = new JSONArray();
			if(this.students != null && students.size() > 0){
				this.students.forEach(student->{
					JSONObject subJson = new JSONObject();
					try {
						subJson.put("Name", student.getFirstName()+" " + student.getLastName());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					studentArray.put(subJson);
				});
			}
			jsonInfo.put("students", studentArray);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		info = jsonInfo.toString();
		return info;
	}
}
