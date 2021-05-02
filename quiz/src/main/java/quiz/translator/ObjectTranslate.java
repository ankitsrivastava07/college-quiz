package quiz.translator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import quiz.controller.AnswersDto;
import quiz.controller.OptionDto;
import quiz.controller.QuestionDto;
import quiz.controller.question.CreateQuestion;
import quiz.dao.entity.OptionsEntity;
import quiz.dao.entity.QuestionEntity;

@Component
public class ObjectTranslate {

	ModelMapper mapper = new ModelMapper();

	public <D> D translate(Object source, Class<D> destinationType) {
		return mapper.map(source, destinationType);
	}

	public <S, T> List<T> translateToList(List<S> source, Class<T> destinationType) {

		return source.stream().map(obj -> mapper.map(obj, destinationType)).collect(Collectors.toList());

	}

	public QuestionDto translateToQuestionDto(CreateQuestion question) {
		int ascii = 65;
		QuestionDto questionDto = new QuestionDto();
		AnswersDto answer = new AnswersDto();
		List<OptionDto> list = new ArrayList<>();

		Map<String, OptionDto> map = new HashMap<>();

		OptionDto opt1 = new OptionDto();
		opt1.setOption((char) ascii++);
		opt1.setOpt(question.getOption1());
		opt1.setIsCorrect(Boolean.FALSE);
		map.put("option1", opt1);
		list.add(opt1);

		OptionDto opt2 = new OptionDto();
		opt2.setOption((char) ascii++);
		opt2.setOpt(question.getOption2());
		opt2.setIsCorrect(Boolean.FALSE);
		map.put("option2", opt2);
		list.add(opt2);

		OptionDto opt3 = new OptionDto();
		opt3.setOption((char) ascii++);
		opt3.setOpt(question.getOption3());
		opt3.setIsCorrect(Boolean.FALSE);
		map.put("option3", opt3);
		list.add(opt3);

		OptionDto opt4 = new OptionDto();
		opt4.setOption((char) ascii++);
		opt4.setOpt(question.getOption4());
		opt4.setIsCorrect(Boolean.FALSE);
		map.put("option4", opt4);
		list.add(opt4);

		OptionDto opt = map.get(question.getCorrectOption());
		opt.setIsCorrect(Boolean.TRUE);

		questionDto.setQuestion(question.getQuestion());

		questionDto.setOptions(list);

		return questionDto;
	}

	public QuestionEntity translateToQuestionEntity(QuestionDto questionDto) {

		QuestionEntity ques = new QuestionEntity();

		ques.setQuestion(questionDto.getQuestion());

		List<OptionsEntity> optionEntity = new ArrayList<>();
		questionDto.getOptions().stream().forEach(opt -> {

			OptionsEntity op = new OptionsEntity();
			op.setOption(opt.getOption());
			op.setOpt(opt.getOpt());
			op.setIsCorrect(opt.getIsCorrect());
			optionEntity.add(op);

		});

		ques.setOptions(optionEntity);
		return ques;

	}

}
