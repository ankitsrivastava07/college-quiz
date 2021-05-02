package quiz.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import quiz.service.QuizService;

@RestController
@RequestMapping("quiz")
@AllArgsConstructor
public class QuizController {

	private QuizService quizService;

	@PostMapping("/submit")
	public ResponseEntity<?> submit(@RequestBody List<QuizSubmit> selectedOptions) {

		return new ResponseEntity<>(quizService.submit(selectedOptions), HttpStatus.OK);

	}
}
