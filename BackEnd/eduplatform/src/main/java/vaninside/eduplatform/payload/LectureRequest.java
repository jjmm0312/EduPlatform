package vaninside.eduplatform.payload;

import lombok.Data;

@Data
public class LectureRequest {
	String title;
	String description;
	String video;
	String document;
	int courseId;
}
