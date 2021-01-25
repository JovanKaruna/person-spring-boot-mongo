package com.demo.company.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {

	public static final String FIELD_DEPT_NO = "deptNo";
	public static final String FIELD_DEPT_NAME = "deptName";
	public static final String FIELD_LOC = "loc";

	@Field(value = Department.FIELD_DEPT_NO)
	private Integer deptNo;

	@Field(value = Department.FIELD_DEPT_NAME)
	private String deptName;

	@Field(value = Department.FIELD_LOC)
	private String loc;

}
