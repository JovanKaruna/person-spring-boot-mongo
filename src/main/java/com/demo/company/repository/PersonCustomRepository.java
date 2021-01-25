package com.demo.company.repository;

import com.demo.company.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonCustomRepository {

	Page<Person> findByStoreIdAndPersonNameMarkForDeleteFalse(String storeId, String personName, Pageable pageable);
	
}

