package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import com.devsuperior.bds01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAllPaged(Pageable pageRequest) {
        Page<Employee> pagedList = this.employeeRepository.findAll(pageRequest);
        return pagedList.map(EmployeeDTO::new);
    }

    @Transactional
    public EmployeeDTO insert(EmployeeDTO newEmployee){
        Employee newEmployeeEntity = new Employee();
        newEmployeeEntity.setName(newEmployee.getName());
        newEmployeeEntity.setEmail(newEmployee.getEmail());

        Department department = this.departmentRepository.getOne(newEmployee.getDepartmentId());
        newEmployeeEntity.setDepartment(department);

        newEmployeeEntity = this.employeeRepository.save(newEmployeeEntity);
        return new EmployeeDTO(newEmployeeEntity);
    }
}
