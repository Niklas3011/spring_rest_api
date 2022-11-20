package niklas.office.service;

import niklas.office.Exception.EmployeeNotFoundException;
import niklas.office.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println("employees = " + employees);
    }

    @Test
    void saveEmployee() {
        Employee employee = Employee.builder()
                .role("tech")
                .age(20)
                .lastName("Super")
                .firstName("Mario")
                .build();
        employeeService.saveEmployee(employee);
    }

    @Test
    void getEmployeeById() throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeById(2L);
        System.out.println("employee = " + employee);
    }

    @Test
    void updateEmployeeById() {
        Employee employee = Employee.builder()
                .firstName("Kevin")
                .lastName("Hart")
                .age(20)
                .role("Comedian")
                .build();
        employeeService.updateEmployeeById(employee, 3L);
    }

    @Test
    void removeEmployeeById() {
        employeeService.removeEmployeeById(2L);
    }
}