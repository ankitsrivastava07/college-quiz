package quiz.controller.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class HomeController {

	@GetMapping("/home")
	public ModelAndView home() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");

		return mv;
	}

	@GetMapping("/register")
	public ModelAndView register() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");

		return mv;
	}

}