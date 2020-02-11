package com.dinuras.RDBMS.Service;

import com.dinuras.RDBMS.Repository.EmployeeRepository;
import com.dinuras.RDBMS.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeRepository repository;

    public void add(Employee employee) {

        repository.save(employee);

    }

    public void delete(Integer id) {

        repository.deleteById(id);

    }

    public List<Employee> getEmployees() {

        return (List<Employee>) repository.findAll();

    }

    /*
    public Employee getEmployeeById(long id) {

        Optional<Employee> optionalEmployee = repository.findById(id);

        return optionalEmployee.orElseThrow(() -> new EmployeeNotFoundException("Couldn't find a Employee with id: " + id));

    }

    private Employee toEntity(EmployeeDto dto) {

        Employee entity = new Employee();

        entity.setName(dto.getName());

        entity.setAge(dto.getAge());

        return entity;

    }

     */
}
