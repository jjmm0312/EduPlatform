package vaninside.eduplatform.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data // lombok �ڵ� setter getter tostring ���� ���ؼ�

@Entity // Ư�� db ���̺�� ���εǴ� Ŭ������ ���̴� ������̼�
@Table(name = "course")

public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String picture;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private User teacher;
	
	/*
	@CreationTimestamp
    private Date created_at;
	*/
	
	public Course() {}
	
	public Course(String title, String description, String picture, User teacher) {
		this.title = title;
		this.description = description;
		this.picture = picture;
		this.teacher = teacher;
	}
}
