package niklas.office.service;

import niklas.office.Exception.EmployeeNotFoundException;
import niklas.office.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Long id) throws EmployeeNotFoundException;

    ResponseEntity<Employee> updateEmployeeById(Employee employee, Long id);

    ResponseEntity<String> removeEmployeeById(Long id);
}
