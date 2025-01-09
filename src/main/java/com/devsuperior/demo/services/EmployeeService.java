package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.repository.DepartmentRepository;
import com.devsuperior.demo.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll() {
        Pageable pageable = PageRequest.of(0, 12, Sort.by("name").ascending());
        Page employeePage = repository.findAll(pageable).map(employee -> new EmployeeDTO(employee));

        return employeePage;
    }
}
