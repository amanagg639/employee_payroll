package org.payroll.employee_payroll;

import jakarta.validation.Valid;
import org.payroll.employee_payroll.dto.EmployeeDto;
import org.payroll.employee_payroll.model.Employee;
import org.payroll.employee_payroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/employeepayrollservice")
@Validated
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Employee>> getEmployeeDetails() {
        return ResponseEntity.ok(employeeService.getData());
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(empId));
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable String department) {
        return ResponseEntity.ok(employeeService.getEmployeeByDepartment(department));
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeDto));
    }

    @PutMapping("/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, @RequestBody @Valid EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(empId, employeeDto));
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empId) {
        employeeService.deleteEmployee(empId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
