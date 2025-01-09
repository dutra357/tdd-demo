package com.devsuperior.demo.dto;

import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDto {
    public Long id;
    public String name;
    public List<EmployeeDTO> employees = new ArrayList<>();

    public DepartmentDto() {}
    public DepartmentDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDto(Department department) {
        this.id = department.getId();
        this.name = department.getName();

        for (Employee employee : department.getEmployees()) {
            this.employees.add(new EmployeeDTO(employee));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }


}
