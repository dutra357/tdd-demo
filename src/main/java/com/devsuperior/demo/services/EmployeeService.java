package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.entities.Employee;
import com.devsuperior.demo.repository.DepartmentRepository;
import com.devsuperior.demo.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository repository, DepartmentRepository departmentRepository) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll(Pageable pageable) {
        Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name").ascending());
        Page employeePage = repository.findAll(page).map(employee -> new EmployeeDTO(employee));

        return employeePage;
    }

    @Transactional
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());

        employee.setDepartment(departmentRepository.getReferenceById(employeeDTO.getDepartmentId()));

        return new EmployeeDTO(repository.save(employee));
    }
}
