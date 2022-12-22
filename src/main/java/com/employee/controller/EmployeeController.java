package com.employee.controller;

import com.employee.model.Employee;
import com.employee.payloads.ApiResponse;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create/emps")
    public ResponseEntity<Employee> createEmp(@Valid @RequestBody Employee employee){
        Employee emp = this.employeeService.createEmp(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @GetMapping("/emps")
    public ResponseEntity<List<Employee>> getAllEmps(){
        List<Employee> employees = this.employeeService.listAllEmp();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @GetMapping("/emp/{empId}")
    public ResponseEntity<Employee> getEmp(@PathVariable Integer empId){
        Employee empById = this.employeeService.getEmpById(empId);
        return new ResponseEntity<>(empById, HttpStatus.OK);
    }

    @PutMapping("/update/emp/{empId}")
    public ResponseEntity<Employee> updateEmp(@Valid
                                                  @PathVariable Integer empId,
                                              @RequestBody Employee employee){
        Employee employee1 = this.employeeService.updateEmp(employee, empId);
        return new ResponseEntity<>(employee1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/emp/{empId}")
    public ResponseEntity<ApiResponse> deleteEmp(@PathVariable Integer empId){
        this.employeeService.deleteEmp(empId);
        return new ResponseEntity<>(new ApiResponse("Employee with employee Id : "
                + empId + " is deleted successfully",true),HttpStatus.OK);
    }


}
