package com.demo.company.repository;

import com.demo.company.entity.Employee;
import com.demo.company.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PersonRepository extends MongoRepository<Person, String> {

	Person findFirstByPersonCodeAndMarkForDeleteFalse(String personCode);

	Page<Person> findByMarkForDeleteFalse(Pageable pageable);

	void deleteByPersonCode(String personCode);
}
