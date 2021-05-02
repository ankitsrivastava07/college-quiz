package quiz.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quiz.dao.entity.QuestionEntity;

public interface QuestionRepo extends JpaRepository<QuestionEntity, Long> {

	@Query(value = "select * from questions order by random()", nativeQuery = true)
	List<QuestionEntity> findAllQuestions();

	@Query(value="select count(id) from questions",nativeQuery = true)
	Long countTotalQuestions();
}