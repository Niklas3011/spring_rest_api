package niklas.the_office_us.service;

import niklas.the_office_us.Exception.EmployeeNotFoundException;
import niklas.the_office_us.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException;

    public ResponseEntity<Employee> updateEmployeeById(Employee employee, Long id);

    public ResponseEntity<String> removeEmployeeById(Long id);
}
