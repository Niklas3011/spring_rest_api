package niklas.office.controller;


import lombok.AllArgsConstructor;
import niklas.office.Exception.CarNotFoundException;
import niklas.office.Exception.EmployeeNotFoundException;
import niklas.office.entity.Car;
import niklas.office.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CarController {

    private CarService carService;

    @GetMapping("/employee/{employeeId}/cars")
    public String getCarsFromEmployee(@PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException {
        List<Car> cars = carService.getCarsFromEmployee(employeeId);
        return cars.toString();
    }

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

    @PutMapping("/car/{carId}")
    public ResponseEntity<Car> updateCarById(@PathVariable("carId") Long carId, @RequestBody @Valid Car car) throws CarNotFoundException {
        return carService.updateCarById(car, carId);
    }

    @DeleteMapping("/employee/{employeeId}/cars")
    public ResponseEntity<String> removeCarsFromEmployee(@PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException {
        return carService.removeCarsFromEmployee(employeeId);
    }

    @DeleteMapping("/car/{carId}")
    public ResponseEntity<String> removeCarById(@PathVariable("carId") Long carId) throws CarNotFoundException {
        return carService.removeCarById(carId);
    }

}
