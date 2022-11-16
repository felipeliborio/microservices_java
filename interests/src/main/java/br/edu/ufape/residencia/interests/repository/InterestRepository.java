package br.edu.ufape.residencia.interests.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.residencia.interests.model.Interest;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long>{
  public List<Interest> findByProductId(long productId);
  public List<Interest> findByEmail(String email);
}
