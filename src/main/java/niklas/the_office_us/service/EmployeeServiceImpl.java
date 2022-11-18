package niklas.the_office_us.service;

import lombok.AllArgsConstructor;
import niklas.the_office_us.Exception.EmployeeNotFoundException;
import niklas.the_office_us.entity.Employee;
import niklas.the_office_us.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }


    //problem: if you update a user, it will not return the updated user
    @Override
    public ResponseEntity<Employee> updateEmployeeById(Employee employeeNew, Long id) {
        Optional <Employee> current = employeeRepository.findById(id);
        if (current.isPresent()) {
            Employee employeeOld = current.get();
            employeeOld.setFirstName(employeeNew.getFirstName());
            employeeOld.setLastName(employeeNew.getLastName());
            employeeOld.setRole(employeeNew.getRole());
            employeeOld.setAge(employeeNew.getAge());
            employeeRepository.save(employeeOld);
            return new ResponseEntity<>(employeeOld, HttpStatus.OK);
        }
        else {
            employeeRepository.save(employeeNew);
            return new ResponseEntity<>(employeeNew, HttpStatus.CREATED);
        }
    }

    //status codes: 200 deleted successfully
    @Override
    public ResponseEntity<String> removeEmployeeById(Long id) {
        if(employeeRepository.findById(id).isPresent()){
            employeeRepository.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
