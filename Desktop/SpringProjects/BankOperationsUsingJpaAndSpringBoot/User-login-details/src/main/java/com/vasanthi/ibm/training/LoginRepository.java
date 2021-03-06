package com.vasanthi.ibm.training;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LoginRepository extends CrudRepository<Logindetails, Integer> {

	@Transactional
	@Modifying
	@Query(nativeQuery = true,value="update logindetails set status=\"active\" where accountNo=:accountNo")
	void updateStatus(@Param("accountNo") Integer accountNo);
	
	@Query(nativeQuery = true,value="select password from logindetails where accountNo=:accountNo")
	String getUserPassword(@Param("accountNo") Integer accountNo);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value="update logindetails set status=\"inactive\" where accountNo=:accountNo")
	void logoff(@Param("accountNo") Integer accountNo);

	@Query(nativeQuery = true,value="select status from logindetails where accountNo=:accountNo")
	String checkStatus(@Param("accountNo") Integer accountNo);
}
