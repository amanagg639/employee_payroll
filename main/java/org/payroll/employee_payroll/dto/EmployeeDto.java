package org.payroll.employee_payroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z\\s]{2,50}$", message = "Name must be 2-50 letters and spaces")
    private String name;

    @Min(value = 500, message = "Min Wage should be more than 500")
    private int salary;

    @Pattern(regexp = "Male|Female", message = "Gender needs to be male or female")
    private String gender;

    @NotNull(message = "startDate should not be empty")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "startDate should be past or todays date")
    private LocalDate startDate;

    @NotBlank
    private String note;

    @NotBlank
    private String profilePicture;

    @NotNull(message = "department should not be empty")
    private List<String> departments;
}
