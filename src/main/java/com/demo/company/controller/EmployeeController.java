package com.demo.company.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.base.BaseResponse;
import com.demo.base.ListBaseResponse;
import com.demo.base.Metadata;
import com.demo.base.SingleBaseResponse;
import com.demo.company.entity.Department;
import com.demo.company.entity.Employee;
import com.demo.company.service.EmployeeService;
import com.demo.dto.DepartmentRequest;
import com.demo.dto.DepartmentResponse;
import com.demo.dto.EmployeeCreateRequest;
import com.demo.dto.EmployeeResponse;
import com.demo.dto.EmployeeUpdateRequest;
import com.demo.dto.EmployeeUpdateNameRequest;

@RestController
@RequestMapping(value = EmployeeControllerPath.BASE_PATH)
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse create(@RequestParam String storeId, @RequestParam String channelId,
			@RequestParam String clientId, @RequestParam String requestId, @RequestParam String username,
			@RequestBody EmployeeCreateRequest request) throws Exception {
		this.employeeService.create(toEmployee(request));
		return new BaseResponse(null, null, true, requestId);
	}

	@RequestMapping(value = EmployeeControllerPath.UPDATE_BY_CODE, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse updateByEmpNo(@RequestParam String storeId, @RequestParam String channelId,
			@RequestParam String clientId, @RequestParam String requestId, @RequestParam String username, @PathVariable Integer code,
			@RequestBody EmployeeUpdateRequest request) throws Exception {
		this.employeeService.update(code, toEmployee(request));
		return new BaseResponse(null, null, true, requestId);
	}

	@RequestMapping(value = EmployeeControllerPath.UPDATE_NAME_BY_CODE, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse updateNameByEmpNo(@RequestParam String storeId, @RequestParam String channelId,
			@RequestParam String clientId, @RequestParam String requestId, @RequestParam String username, @PathVariable Integer code,
			@RequestBody EmployeeUpdateNameRequest request) throws Exception {
		Employee employee = Employee.builder().build();
		BeanUtils.copyProperties(request, employee);
		this.employeeService.updateName(code, employee);
		return new BaseResponse(null, null, true, requestId);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ListBaseResponse<EmployeeResponse> findEmployees(@RequestParam String storeId, @RequestParam String channelId,
			@RequestParam String clientId, @RequestParam String requestId, @RequestParam String username,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size)
			throws Exception {
		Pageable pageable = PageRequest.of(page, size);
		Page<Employee> employees = this.employeeService.find(pageable);
		List<EmployeeResponse> employeeResponses = employees.getContent().stream().map(this::toEmployeeResponse).collect(Collectors.toList());
		return new ListBaseResponse<>(null, null, true, requestId, employeeResponses,
				new Metadata(page, size, employees.getTotalElements()));
	}

	@RequestMapping(value = EmployeeControllerPath.FIND_BY_CODE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SingleBaseResponse<EmployeeResponse> findByEmpNo(@RequestParam String storeId,
			@RequestParam String channelId, @RequestParam String clientId, @RequestParam String requestId,
			@RequestParam String username, @PathVariable Integer code) throws Exception {
		Employee employee = this.employeeService.findByCode(code);
		EmployeeResponse employeeResponse = Optional.ofNullable(employee).map(this::toEmployeeResponse).orElse(null);
		return new SingleBaseResponse<>(null, null, true, requestId, employeeResponse);
	}

	@RequestMapping(value = EmployeeControllerPath.DELETE_BY_CODE, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse deleteByEmpNo(@RequestParam String storeId, @RequestParam String channelId,
			@RequestParam String clientId, @RequestParam String requestId, @RequestParam String username,
			@RequestParam Integer code) throws Exception {
		this.employeeService.deleteByEmpNo(code);
		return new BaseResponse(null, null, true, requestId);
	}
	
	
	private EmployeeResponse toEmployeeResponse(Employee employee) {
		return Optional.ofNullable(employee).map(e -> {
			EmployeeResponse employeeResponse = EmployeeResponse.builder().build();
			BeanUtils.copyProperties(e, employeeResponse);
			employeeResponse.setDepartment(toDepartmentResponse(employee.getDepartment()));
			return employeeResponse;
		}).orElse(null);
	}
	
	private DepartmentResponse toDepartmentResponse(Department department) {
		return Optional.ofNullable(department).map(d -> {
			DepartmentResponse departmentResponse = DepartmentResponse.builder().build();
			BeanUtils.copyProperties(d, departmentResponse);
			return departmentResponse;
		}).orElse(null);
	}
	
	private Employee toEmployee(EmployeeUpdateRequest request) {
		return Optional.ofNullable(request).map(e -> {
			Employee employee = Employee.builder().build();
			BeanUtils.copyProperties(e, employee);
			employee.setDepartment(toDepartment(request.getDepartment()));
			return employee;
		}).orElse(null);
	}
	
	private Employee toEmployee(EmployeeCreateRequest request) {
		return Optional.ofNullable(request).map(e -> {
			Employee employee = Employee.builder().build();
			BeanUtils.copyProperties(e, employee);
			employee.setDepartment(toDepartment(request.getDepartment()));
			return employee;
		}).orElse(null);
	}

	private Department toDepartment(DepartmentRequest request) {
		return Optional.ofNullable(request).map(d -> {
			Department department = Department.builder().build();
			BeanUtils.copyProperties(d, department);
			return department;
		}).orElse(null);
	}
}
