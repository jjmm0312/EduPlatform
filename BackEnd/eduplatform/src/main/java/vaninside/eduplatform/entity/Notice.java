package vaninside.eduplatform.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="notice")
public class Notice {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String title;
		private String content;
		
		@Column(name="date")
		private LocalDateTime time;
		
		Notice()
		{
			this.time = LocalDateTime.now();
			// 생성자에서 현재 시간을 저장한다
			// Default
		}
		
		public Notice(String title, String content)
		{
			this.title = title;
			this.content = content;
			this.time = LocalDateTime.now();
		}
}
