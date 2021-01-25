package com.demo.company.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.company.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>, EmployeeCustomRepository {

	Employee findFirstByEmpNoAndMarkForDeleteFalse(Integer empNo);

	Page<Employee> findByMarkForDeleteFalse(Pageable pageable);

	void deleteByEmpNo(Integer empNo);

	// Contoh penggunaan lainnya
	Page<Employee> findByEmpNameContainingIgnoreCaseAndMarkForDeleteFalse(String empName, Pageable pageable);

	Page<Employee> findByDepartment_DeptNameContainingIgnoreCaseAndMarkForDeleteFalse(String deptName,
			Pageable pageable);

	@Query("{$and: [{storeId: ?0},{empNo: {$in: ?1}}]}")
	Page<Employee> findByStoreIdAndEmpNosAndMarkForDeleteFalse(String storeId, String empNo, Pageable pageable);

	@Query(fields = "{'sal' : 0}")
	Employee findByStoreIdAndEmpNoAndMarkForDeleteFalse(String storeId, String empNo);
}
