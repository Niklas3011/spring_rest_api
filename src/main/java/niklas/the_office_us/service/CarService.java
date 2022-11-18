package niklas.the_office_us.service;

import niklas.the_office_us.Exception.CarNotFoundException;
import niklas.the_office_us.Exception.EmployeeNotFoundException;
import niklas.the_office_us.entity.Car;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarService {

    Car getCarById(Long id) throws CarNotFoundException;

    List<Car> getCarsFromEmployee(Long id) throws EmployeeNotFoundException;

    Car saveCar(Car car, Long id) throws EmployeeNotFoundException;

    //ResponseEntity<Car> updateCarByEmployee(Car car, Long id) throws EmployeeNotFoundException;

    ResponseEntity<Car> updateCarById(Car car, Long id) throws CarNotFoundException;

    ResponseEntity<String> removeCarById(Long id) throws CarNotFoundException;

    ResponseEntity<String> removeCarsFromEmployee(Long id) throws EmployeeNotFoundException;

}
