package quiz.dao;

import java.util.List;

import quiz.controller.QuestionDto;

public interface QuestionDao {

	void createQuestion(QuestionDto questionDto);

	List<QuestionDto> getAllQuestion();

}
