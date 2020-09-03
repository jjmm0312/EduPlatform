package vaninside.eduplatform.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data 

@Entity 
@Table(name = "academy")
public class Academy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String logo;
	private String pic;
	private String putter;
	private String intro;
	
	public Academy() {}
	
	public Academy(String name, String logo, String pic, String putter, String intro) {
		this.name = name;
		this.logo = logo;
		this.pic = pic;
		this.putter = putter;
		this.intro = intro;
	}
}
