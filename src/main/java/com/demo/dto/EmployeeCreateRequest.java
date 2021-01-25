package com.demo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateRequest implements Serializable {

	private Integer empNo;
	private String empName;
	private String job;
	private Integer mgr;
	private String hireDate;
	private Double sal;
	private Double comm;
	private DepartmentRequest department;
}
