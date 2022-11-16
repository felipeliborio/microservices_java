package br.edu.ufape.residencia.interests.dto;

import br.edu.ufape.residencia.interests.model.Interest;
import lombok.Data;

@Data
public class InterestResponse {
  private long id;
  private String name;
  private String email;
  private long productId;

  public InterestResponse(Interest interest) {
    this.id = interest.getId();
    this.name = interest.getName();
    this.email = interest.getEmail();
    this.productId = interest.getProductId();
  }
}
