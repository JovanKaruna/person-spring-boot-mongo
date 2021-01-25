package com.demo.company.repository;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.demo.company.entity.Employee;

public class EmployeeRepositoryImpl implements EmployeeCustomRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Page<Employee> findByStoreIdAndEmpNameMarkForDeleteFalse(String storeId, String empName, Pageable pageable) {
		Query query = new Query();
		Criteria criteria = Criteria.where("storeId").is(storeId).and("markForDelete").is(false);
		if (Objects.nonNull(empName)) {
			criteria.and("empName").regex("*empName*", "i");
		}
		query.addCriteria(criteria);
		Long totalElements = this.mongoTemplate.count(query, Profile.class);
		query.with(pageable);
		List<Employee> employees = this.mongoTemplate.find(query, Employee.class);
		return new PageImpl<>(employees, pageable, totalElements);
	}
}
