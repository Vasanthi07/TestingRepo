package com.vasanthi.ibm.training;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomersRepository extends CrudRepository<Bankcustomers, Integer>{

	List<Bankcustomers> findByPhoneNo(String phoneNo);
	
	@Query(nativeQuery = true,value = "select amount from bankcustomers where accountNo=:accountNo" )
	Integer checkBalance(@Param("accountNo") Integer accountNo);

	@Transactional
	@Modifying
	@Query(nativeQuery = true,value="update bankcustomers set amount=:amount where accountNo=:accountNo")
	void updateMoney(@Param("accountNo") Integer accountNo, @Param("amount") Integer amount);
}
