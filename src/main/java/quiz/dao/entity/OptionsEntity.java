package quiz.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "options")
public class OptionsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String opt;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "qid", referencedColumnName = "id")
	private QuestionEntity qid;

	@Column(name = "is_correct", columnDefinition = "boolean default false")
	private Boolean isCorrect;
	@Column(name = "option")
	private Character option;
}