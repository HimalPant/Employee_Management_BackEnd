package com.employee.service.serviceImpl;

import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepo;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public Employee createEmp(Employee employee) {
        Employee save = this.employeeRepo.save(employee);
        return save;
    }

    @Override
    public List<Employee> listAllEmp() {
        List<Employee> all = this.employeeRepo.findAll();
        return all;
    }

    @Override
    public Employee getEmpById(Integer empId) {
        Employee employee = this.employeeRepo.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee","Employee Id", empId));
        return employee;
    }

    @Override
    public Employee updateEmp(Employee employee,Integer empId) {
        Employee employee1 = this.employeeRepo.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "employee Id", empId));
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmailId(employee.getEmailId());
        Employee save = employeeRepo.save(employee);
        return save;

    }

    @Override
    public void deleteEmp(Integer empId) {
        Employee employee = this.employeeRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee", "employee Id", empId));
        this.employeeRepo.delete(employee);
    }
}
