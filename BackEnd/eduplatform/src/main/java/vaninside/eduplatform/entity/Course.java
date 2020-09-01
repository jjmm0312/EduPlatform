package vaninside.eduplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private int teacher; // ���� �ܷ�Ű�� ���� ����.
	
	public Course() {
		
	}
}
