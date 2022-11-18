package niklas.the_office_us.controller;

import lombok.AllArgsConstructor;
import niklas.the_office_us.Exception.EmployeeNotFoundException;
import niklas.the_office_us.entity.Employee;
import niklas.the_office_us.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> fetchAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/employee/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") Long emloyeeId) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(emloyeeId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody @Valid Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody @Valid Employee employee){
        return employeeService.updateEmployeeById(employee, employeeId);
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        return employeeService.removeEmployeeById(employeeId);
    }

}
// $ curl -X POST http://localhost:8080/api/employees -H 'Content-type:application/json' -d '{"firstName": "Niklas", "lastName": "Voss", "age": 20, "role": "Software"}'
//for a get request: curl http://localhost:8080/api/employees