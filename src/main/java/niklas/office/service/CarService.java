package niklas.office.service;

import niklas.office.Exception.CarNotFoundException;
import niklas.office.Exception.EmployeeNotFoundException;
import niklas.office.entity.Car;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarService {

    Car getCarById(Long id) throws CarNotFoundException;

    List<Car> getCarsFromEmployee(Long id) throws EmployeeNotFoundException;

    Car saveCar(Car car, Long id) throws EmployeeNotFoundException;

    ResponseEntity<Car> updateCarById(Car car, Long id) throws CarNotFoundException;

    ResponseEntity<String> removeCarById(Long id) throws CarNotFoundException;

    ResponseEntity<String> removeCarsFromEmployee(Long id) throws EmployeeNotFoundException;

}
