package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.DepartmentDto;
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
    public List<DepartmentDto> findAll() {
        return repository.findAll().stream().map(department -> new DepartmentDto(department))
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).toList();
    }
}
