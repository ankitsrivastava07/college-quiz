package quiz.service;

import java.util.List;

import quiz.controller.QuestionDto;
import quiz.controller.QuizSubmit;
import quiz.controller.TestResult;

public interface QuizService {

	TestResult submit(List<QuizSubmit> selectedOptions);

	List<QuestionDto> getAllQuestions();

	public void createQuestion(QuestionDto questionDto);
}