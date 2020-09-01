package vaninside.eduplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "lecture")
public class Lecture {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id;
	
	int lecture; // ���� �ܷ�Ű ó�� ����
	String title;
	String description;
	String video;
	String document;
	
	public Lecture() {
		
	}
}
