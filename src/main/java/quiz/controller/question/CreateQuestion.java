package quiz.controller.question;

import lombok.Data;

@Data
public class CreateQuestion {

	private String question;

	private String option1;
	private String option2;
	private String option3;
	private String option4;

	private String correctOption;

}
