package com.devsuperior.demo.controller;

import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.services.DepartmentService;
import com.devsuperior.demo.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> findAll(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO newEmployee = service.save(employeeDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(newEmployee.getId()).toUri();

        return ResponseEntity.created(uri).body(newEmployee);
    }

}
