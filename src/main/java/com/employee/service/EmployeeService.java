package com.employee.service;

import com.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    // create employee record
    Employee createEmp(Employee employee);

    // list all the employees
    List<Employee> listAllEmp();

    // Get one employee by using employee Id
    Employee getEmpById(Integer empId);

    // Update employee
    Employee updateEmp(Employee employee,Integer empId);

    // Delete employee record
    void deleteEmp(Integer empId);



}
