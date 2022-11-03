package br.edu.ufape.residencia.reviews.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String author;
	private String title;
	private String body;
	private long productId;
	@Min(value=1, message = "Nota inválida")
	@Max(value=5, message = "Nota inválida")
	@Column(columnDefinition = "integer default 5")
	private long rating;
}
