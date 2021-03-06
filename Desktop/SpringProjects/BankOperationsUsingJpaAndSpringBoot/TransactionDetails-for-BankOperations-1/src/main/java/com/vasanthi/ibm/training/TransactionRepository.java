package com.vasanthi.ibm.training;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions,Integer>  {

	List<Transactions> findByTransAccount(Integer transAccount);
}
