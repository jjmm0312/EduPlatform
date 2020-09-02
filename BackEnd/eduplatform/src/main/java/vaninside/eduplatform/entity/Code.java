package vaninside.eduplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity
@Table (name = "code")
public class Code {
	@Id
	int id;
	String student;
	String teacher;
	
	public Code() {}
	public Code(String s, String t) {
		student = s;
		teacher = t;
	}
}
