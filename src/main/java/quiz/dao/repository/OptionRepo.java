package quiz.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quiz.dao.entity.OptionsEntity;

public interface OptionRepo extends JpaRepository<OptionsEntity, Long> {

	@Query(value = "select * from options where is_correct=?1", nativeQuery = true)
	List<OptionsEntity> getAllCorrectAnswers(Boolean isCorrect);

}
