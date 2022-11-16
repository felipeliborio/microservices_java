package br.edu.ufape.residencia.interests.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.residencia.interests.dto.InterestRequest;
import br.edu.ufape.residencia.interests.dto.InterestResponse;
import br.edu.ufape.residencia.interests.service.InterestService;

@Service
public class Facade {
  @Autowired
  private InterestService interestService;
  
  public InterestResponse createInterest(InterestRequest interestRequest) {
    return interestService.createInterest(interestRequest);
  }

  public List<InterestResponse> findAllInterests() {
    return interestService.findAllInterests();
  }

  public List<InterestResponse> findIntetestsByProduct(long productId) {
    return interestService.findInterestsByProduct(productId);
  }

  public List<InterestResponse> findInterestsByEmail(String email) {
    return interestService.findInterestsByEmail(email);
  }
}
