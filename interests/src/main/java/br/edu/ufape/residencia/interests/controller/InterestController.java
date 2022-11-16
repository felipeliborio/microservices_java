package br.edu.ufape.residencia.interests.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.residencia.interests.dto.InterestRequest;
import br.edu.ufape.residencia.interests.dto.InterestResponse;
import br.edu.ufape.residencia.interests.facade.Facade;

@RestController
public class InterestController {
  @Autowired
  private Facade facade;

  @PostMapping(value = "/interest")
  public InterestResponse create(@RequestBody InterestRequest interest) {
    return facade.createInterest(interest);
  }

  @GetMapping(value = "/interest/user/{email}")
  public List<InterestResponse> getIntesrestsByUser(@PathVariable String email) {
    return facade.findInterestsByEmail(email);
  }

  @GetMapping(value = "/interest/product/{id}")
  public List<InterestResponse> getInterestsByProduct(@PathVariable long id) {
    return facade.findIntetestsByProduct(id);
  }

  @GetMapping(value = "/interest")
  public List<InterestResponse> listAll() {
    return facade.findAllInterests();
  }
}
