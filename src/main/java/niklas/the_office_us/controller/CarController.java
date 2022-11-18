package niklas.the_office_us.controller;


import lombok.AllArgsConstructor;
import niklas.the_office_us.Exception.CarNotFoundException;
import niklas.the_office_us.Exception.EmployeeNotFoundException;
import niklas.the_office_us.entity.Car;
import niklas.the_office_us.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CarController {

    private CarService carService;

    /**
     * @param employeeId
     * @return Convert List to String, so the api doesnt return the whole employee object for every car returned
     * @throws EmployeeNotFoundException
     */
    @GetMapping("/employee/{employeeId}/cars")
    public String getCarsFromEmployee(@PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException {
        List<Car> cars = carService.getCarsFromEmployee(employeeId);
        return cars.toString();
    }

    /**
     *
     * @param carId
     * @return doesnt work, if i return: return carService.getCarById(carId);
     * @throws CarNotFoundException
     */
    @GetMapping("/car/{carId}")
    public String getCarById(@PathVariable("carId") Long carId) throws CarNotFoundException {
        Car car = carService.getCarById(carId);
        return car.toString();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/employee/{employeeId}/car")
    public Car saveCar(@PathVariable("employeeId") Long employeeId, @RequestBody @Valid Car car) throws EmployeeNotFoundException{
        return carService.saveCar(car, employeeId);
    }

    /*@PutMapping("/employee/{employeeId}/car")
    public ResponseEntity<Car> updateCarByEmployee(@PathVariable("employeeId") Long employeeId,@RequestBody @Valid Car car) throws EmployeeNotFoundException{
        return carService.updateCarByEmployee(car, employeeId);
    }*/

    //funktioniert, gibt aber error message: org.apache.http.ConnectionClosedException: Premature end of chunk coded message body: closing chunk expected
    @PutMapping("/car/{carId}")
    public ResponseEntity<Car> updateCarById(@PathVariable("carId") Long carId, @RequestBody @Valid Car car) throws CarNotFoundException {
        return carService.updateCarById(car, carId);
    }

    //funktioniert generell nicht
    //gibt internal Server error
    //class java.lang.Integer cannot be cast to class niklas.the_office_us.entity.Car
    @DeleteMapping("/employee/{employeeId}/cars")
    public ResponseEntity<String> removeCarsFromEmployee(@PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException {
        return carService.removeCarsFromEmployee(employeeId);
    }

}
