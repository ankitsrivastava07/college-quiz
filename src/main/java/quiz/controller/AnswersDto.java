package quiz.controller;

import lombok.Data;

@Data
public class AnswersDto {

	private QuestionDto question;
	private String answer;
}
