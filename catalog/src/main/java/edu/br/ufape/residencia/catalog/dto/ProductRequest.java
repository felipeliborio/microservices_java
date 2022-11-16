package edu.br.ufape.residencia.catalog.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import edu.br.ufape.residencia.catalog.model.Category;
import edu.br.ufape.residencia.catalog.model.Image;
import edu.br.ufape.residencia.catalog.model.Product;
import lombok.Data;

@Data
public class ProductRequest {
	@NotBlank(message = "A name is required")
	@Length(min = 3, max=35, message = "The name must have between 3 and 35 characters")
	private String name;
	@NotBlank(message = "Detailing is required")
	@Length(min = 3, max=255, message = "The details must have between 8 and 255 characters")
	private String detail;
	private Date releaseDate;
	private boolean status;
	private List<Image> images;
	@NotBlank
	private long categoryId;
	
	public Product toProduct() {
		return Product
			.builder()
			.name(name)
			.detail(detail)
			.releaseDate(releaseDate)
			.status(status)
			.images(images)
			.category(					
				Category
					.builder()
					.id(categoryId)
					.build()
			)
			.build();
	}
}
