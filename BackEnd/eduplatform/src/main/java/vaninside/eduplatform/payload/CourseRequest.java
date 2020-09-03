package vaninside.eduplatform.payload;

import lombok.Data;

@Data
public class CourseRequest {
		private int userid;
	 	private String title;
	    private String description;
	    private String picture;
}
