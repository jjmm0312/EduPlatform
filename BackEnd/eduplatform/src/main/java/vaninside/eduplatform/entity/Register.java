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
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@Table (name = "register")

public class Register {
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		int id;
		
		@ManyToOne
		@JoinColumn(name = "course_id")
		Course course;
		
		@ManyToOne
		@JoinColumn(name = "student_id")
		User student;
		
		@CreationTimestamp
	    private Timestamp date;
		
		int agree;
		
		public Register() {}
		public Register(Course course, User user) {
			this.course = course;
			this.student = user;
			this.agree = 0; // ½ÂÀÎ ´ë±â
		}

}
