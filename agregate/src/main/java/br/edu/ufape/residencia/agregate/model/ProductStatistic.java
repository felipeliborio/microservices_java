package br.edu.ufape.residencia.agregate.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ufape.residencia.util.dto.ReviewDto;
import lombok.Data;

@Data
public class ProductStatistic {
	private BigDecimal score;
	private Map<Integer, Integer> stars;

	public ProductStatistic(List<ReviewDto> reviews) {
		if(reviews.size() > 0) {
			long sum = reviews
        .stream()
        .map(r -> r.getRating())
        .reduce(0l, (a, b) -> a + b);

			score = BigDecimal.valueOf((double)sum/reviews.size()).setScale(2, RoundingMode.CEILING);

			stars = new HashMap<Integer, Integer>();
			for(int i = 1; i <=5; i++) {
				int filtro = i;
				int quantidade = (int) reviews.stream().filter(r -> r.getRating() == filtro).count();
				stars.put(i, quantidade);
			}
		} else {
			score = BigDecimal.valueOf(5);
			stars = new HashMap<Integer, Integer>();
			for(int i = 1; i <=5; i++)
				stars.put(i, 0);
		}

	}
}