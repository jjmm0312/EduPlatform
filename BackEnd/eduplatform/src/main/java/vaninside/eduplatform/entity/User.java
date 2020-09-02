package vaninside.eduplatform.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import vaninside.eduplatform.security.UserPrincipal;

@Data
@Entity
@Table(name = "user")
public class User{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	private String username;
	private String email;
	@JsonIgnore
	private String password;
	private String name;
	@JsonIgnore
	private String role;
    
	
	public User() {} 
	
	public User(String username, String email, String name) {
		this.username = username;
		this.email = email;
		this.name = name;
	}
}
