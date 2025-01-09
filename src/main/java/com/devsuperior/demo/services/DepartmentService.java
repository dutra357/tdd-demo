package com.devsuperior.demo.services;

import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Department> findAll() {
        return repository.findAll();
    }
}
