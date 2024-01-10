package com.blackcode.springbootcurdsimple.service.Impl;

import com.blackcode.springbootcurdsimple.dto.EmployeeDto;
import com.blackcode.springbootcurdsimple.entity.Employee;
import com.blackcode.springbootcurdsimple.exception.ResourceNotFoundException;
import com.blackcode.springbootcurdsimple.mapper.EmployeeMapper;
import com.blackcode.springbootcurdsimple.repository.EmployeeRepository;
import com.blackcode.springbootcurdsimple.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee is not exist with given id :"+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id:"+employeeId)
        );
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Employee updateEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exist with given id :"+employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
