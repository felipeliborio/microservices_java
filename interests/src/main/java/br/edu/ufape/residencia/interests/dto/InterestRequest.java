package br.edu.ufape.residencia.interests.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.edu.ufape.residencia.interests.model.Interest;
import lombok.Data;

@Data
public class InterestRequest {
  @NotBlank(message = "A name is required")
  @Length(min = 3, max = 35, message = "The maximum length for the name is 35 characters")
  private String name;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  @Min(value=1)
  private long productId;

  public Interest toInterest() {
    return Interest.builder()
      .name(name)
      .email(email)
      .productId(productId)
      .build();
  }
}
