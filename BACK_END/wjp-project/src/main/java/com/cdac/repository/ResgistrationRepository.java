package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entity.Registration;


@Repository 
public interface ResgistrationRepository  extends JpaRepository<Registration, Integer>  {
	Registration findByFirstName(String firstname);
}
