package quiz.controller;

import java.util.List;

import lombok.Data;

@Data
public class QuestionDto {

	private Long id;
	private String question;
	private List<OptionDto> options;
}
