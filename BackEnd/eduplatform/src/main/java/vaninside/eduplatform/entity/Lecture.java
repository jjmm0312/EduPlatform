package vaninside.eduplatform.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table (name = "lecture")
public class Lecture {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	Course course; 
	
	String title;
	String description;
	String video;
	String document;
	
	@CreationTimestamp
    private Timestamp date;
	
	public Lecture() {}
	
	public Lecture(String title, String description, String video, String document, Course course) {
		this.title = title;
		this.description = description;
		this.video = video;
		this.document = document;
		this.course = course;
	}
}
