package com.demo.company.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.demo.base.MongoBaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = Employee.COLLECTION_NAME)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends MongoBaseEntity {

	public static final String COLLECTION_NAME = "employee";

	public static final String FIELD_EMP_NO = "empNo";
	public static final String FIELD_EMP_NAME = "empName";
	public static final String FIELD_JOB = "job";
	public static final String FIELD_MGR = "mgr";
	public static final String FIELD_HIRE_DATE = "hireDate";
	public static final String FIELD_SAL = "sal";
	public static final String FIELD_COMM = "comm";
	public static final String FIELD_DEPT= "department";

	@Field(value = Employee.FIELD_EMP_NO)
	private Integer empNo;

	@Field(value = Employee.FIELD_EMP_NAME)
	private String empName;

	@Field(value = Employee.FIELD_JOB)
	private String job;

	@Field(value = Employee.FIELD_MGR)
	private Integer mgr;

	@Field(value = Employee.FIELD_HIRE_DATE)
	private String hireDate;

	@Field(value = Employee.FIELD_SAL)
	private Double sal;

	@Field(value = Employee.FIELD_COMM)
	private Double comm;

	@Field(value = Employee.FIELD_DEPT)
	private Department department;

}
