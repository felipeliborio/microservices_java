package br.edu.ufape.residencia.interests.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.residencia.interests.dto.InterestRequest;
import br.edu.ufape.residencia.interests.dto.InterestResponse;
import br.edu.ufape.residencia.interests.model.Interest;
import br.edu.ufape.residencia.interests.repository.InterestRepository;

@Service
public class InterestService {
  @Autowired
  private InterestRepository repository;

  public InterestResponse createInterest(InterestRequest interestRequest) {
    return new InterestResponse(repository.save(interestRequest.toInterest()));
  }

  public List<InterestResponse> findAllInterests() {
    List <Interest> list = repository.findAll();
    return list
      .stream()
      .map(InterestResponse::new)
      .toList();
  }

  public List<InterestResponse> findInterestsByProduct(long productId) {
    List<Interest> list = repository.findByProductId(productId);
    return list
      .stream()
      .map(InterestResponse::new)
      .toList();
  }

  public List<InterestResponse> findInterestsByEmail(String email) {
    List<Interest> list = repository.findByEmail(email);
    return list
      .stream()
      .map(InterestResponse::new)
      .toList();
  }
}
