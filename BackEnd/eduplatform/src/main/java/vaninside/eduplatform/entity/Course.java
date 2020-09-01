package vaninside.eduplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data // lombok 자동 setter getter tostring 설정 위해서

@Entity // 특정 db 테이블과 매핑되는 클래스에 붙이는 어노테이션
@Table(name = "course")

public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String picture;
	private int teacher; // 추후 외래키로 설정 예정.
	
	public Course() {
		
	}
}
