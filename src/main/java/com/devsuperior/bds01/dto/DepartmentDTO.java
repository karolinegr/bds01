package com.devsuperior.bds01.dto;

import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DepartmentDTO implements Serializable {
    private Long id;
    private String name;
    private List<EmployeeDTO> employees = new ArrayList<>();

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDTO(Department entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public DepartmentDTO(Department entity, Set<Employee> employees) {
        this(entity);
        employees.forEach(item -> this.employees.add(new EmployeeDTO(item)));
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
