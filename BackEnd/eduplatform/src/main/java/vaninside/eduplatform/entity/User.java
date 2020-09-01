package vaninside.eduplatform.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
@Table(name = "test")
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String email;
	private String password;
	private String name;
	private String role;
	
	public User() {
		
	}
	
	public User(String username, String email, String name) {
		this.username = username;
		this.email = email;
		this.name = name;
	}

}
