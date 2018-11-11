package com.sakshi.restws.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sakshi.restws.entities.Number;

public interface ProductRepository extends JpaRepository<Number, Integer> {
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("update Number c set c.id=c.id+1 ")
	void updateCount();

}
