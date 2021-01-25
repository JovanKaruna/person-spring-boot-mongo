package com.demo.company.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.company.entity.Employee;
import com.demo.company.repository.EmployeeRepository;
import com.demo.config.data.Credential;

@Service
public class EmployeeServiceBean implements EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceBean.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void create(Employee employee) throws Exception {
		employee.setStoreId(MDC.get(Credential.CREDENTIAL_STORE_ID));
		employeeRepository.save(employee);
	}

	@Override
	public void update(Integer empNo, Employee employee) throws Exception {
		Employee oldEmp = employeeRepository.findFirstByEmpNoAndMarkForDeleteFalse(empNo);
		oldEmp.setEmpName(employee.getEmpName());
		oldEmp.setJob(employee.getJob());
		oldEmp.setMgr(employee.getMgr());
		oldEmp.setHireDate(employee.getHireDate());
		oldEmp.setSal(employee.getSal());
		oldEmp.setComm(employee.getComm());
		oldEmp.setDepartment(employee.getDepartment());
		employeeRepository.save(oldEmp);
	}

	@Override
	public void updateName(Integer empNo, Employee employee) throws Exception {
		Employee oldEmp = employeeRepository.findFirstByEmpNoAndMarkForDeleteFalse(empNo);
		oldEmp.setEmpName(employee.getEmpName());
		employeeRepository.save(oldEmp);
	}

	@Override
	public Page<Employee> find(Pageable pageable) throws Exception {
		return employeeRepository.findByMarkForDeleteFalse(pageable);
	}

	@Override
	public Employee findByCode(Integer code) throws Exception {
		return employeeRepository.findFirstByEmpNoAndMarkForDeleteFalse(code);
	}

	@Override
	public void deleteByEmpNo(Integer code) throws Exception {
		this.employeeRepository.deleteByEmpNo(code);
	}
}
