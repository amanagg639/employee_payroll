package org.payroll.employee_payroll.model;


import jakarta.persistence.*;
import lombok.*;
import org.payroll.employee_payroll.dto.EmployeeDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Entity
@Data
@NoArgsConstructor
@Scope("prototype")
@ToString
@Table(name = "employee_payrollService")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private long employee_id;
    private String name;
    private int salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePicture;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

    public Employee(EmployeeDto employeeDto) {
        this.updateEmployeeData(employeeDto);
    }

    public void updateEmployeeData(EmployeeDto employeeDto) {
        this.name = employeeDto.getName();
        this.salary = employeeDto.getSalary();
        this.gender = employeeDto.getGender();
        this.startDate = employeeDto.getStartDate();
        this.note = employeeDto.getNote();
        this.profilePicture = employeeDto.getProfilePicture();
        this.departments = employeeDto.getDepartments();
    }
}

