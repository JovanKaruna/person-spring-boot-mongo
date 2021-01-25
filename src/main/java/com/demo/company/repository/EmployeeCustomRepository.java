package com.demo.company.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.company.entity.Employee;

public interface EmployeeCustomRepository {

	Page<Employee> findByStoreIdAndEmpNameMarkForDeleteFalse(String storeId, String empName, Pageable pageable);
	
}

