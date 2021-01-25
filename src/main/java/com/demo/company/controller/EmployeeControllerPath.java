package com.demo.company.controller;

public interface EmployeeControllerPath {

  String BASE_PATH = "/api/employees";
  String FIND_BY_CODE = "/{code}";
  String UPDATE_BY_CODE = "/{code}";
  String DELETE_BY_CODE = "/{code}";
  String UPDATE_NAME_BY_CODE = "/{code}/name";
  
}
