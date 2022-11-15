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
	@NotBlank(message = "O nome é obrigatório")
	@Length(min = 3, max=35, message = "O nome deve ter entre 3 e 35 letras")
	private String name;
	@NotBlank(message = "A descrição é obrigatória")
	@Length(min = 3, max=35, message = "A descrição deve ter entre 3 e 254 letras")
	private String detail;
	private Date releaseDate;
	private boolean status;
	private List<Image> images;
	@NotBlank
	private long categoryId;
	
	public Product toProduct() {
		return Product.builder()
				.name(name)
				.detail(detail)
				.releaseDate(releaseDate)
				.status(status)
				.images(images)
				.category(					
					Category.builder()
						.id(categoryId)
						.build()
				)
				.build();
	}
}
