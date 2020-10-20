package com.springboot.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LoanDao {
	  
	  @PersistenceContext
	  private EntityManager entityManager;
	
	  public void create(Loan loan) {
		  entityManager.persist(loan);
	  }
	  
	  public void createAll(List<Loan> loanList) {
		  for(Loan loan:loanList)
			  entityManager.persist(loan);
	  }
	  
	  public Loan getLoan(int loanNumber) {
		  return entityManager.find(Loan.class, loanNumber);
	  }
	  
	  public List<Loan> getLoans() {
		  return entityManager.createQuery("from Loan").getResultList();
	  }
}
