package org.payroll.employee_payroll.service;

import lombok.extern.slf4j.Slf4j;
import org.payroll.employee_payroll.dto.EmployeeDto;
import org.payroll.employee_payroll.exception.EmployeePayrollException;
import org.payroll.employee_payroll.exception.GlobalExceptionHandler;
import org.payroll.employee_payroll.model.Employee;
import org.payroll.employee_payroll.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getData() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeePayrollException("Employee with employeeId " + id + " does not exist"));
    }

    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findEmployeeByDepartment(department);
    }

    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto);
        log.debug("Creating employee " + employee.toString());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, EmployeeDto employeeDto) {
        Employee employee = getEmployeeById(id);
        employee.updateEmployeeData(employeeDto);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}
