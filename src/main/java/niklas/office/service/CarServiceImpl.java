package niklas.office.service;

import lombok.AllArgsConstructor;
import niklas.office.Exception.CarNotFoundException;
import niklas.office.Exception.EmployeeNotFoundException;
import niklas.office.entity.Car;
import niklas.office.entity.Employee;
import niklas.office.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CarServiceImpl implements CarService{

    private CarRepository carRepository;
    private EmployeeService employeeService;


    @Override
    public Car getCarById(Long id) throws CarNotFoundException {
        return carRepository.findById(id).orElseThrow(CarNotFoundException::new);
    }

    @Override
    public List<Car> getCarsFromEmployee(Long id) throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeById(id);
        return carRepository.findCarsByEmployee(employee);
    }

    @Override
    public Car saveCar(Car car, Long id) throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeById(id);
        car.setEmployee(employee);
        return carRepository.save(car);
    }

    @Override
    public ResponseEntity<Car> updateCarById(Car car, Long id) throws CarNotFoundException {
        Optional<Car> current = carRepository.findById(id);
        if(current.isPresent()) {
            Car carOld = current.get();
            carOld.setHp(car.getHp());
            carOld.setModel(car.getModel());
            carOld.setBuildYear(car.getBuildYear());
            carOld.setNumberPlate(car.getNumberPlate());
            carRepository.save(carOld);
            return new ResponseEntity<>(carOld, HttpStatus.OK);
        }
        else {
            throw new CarNotFoundException();
        }
    }

    @Override
    public ResponseEntity<String> removeCarById(Long id) throws CarNotFoundException {
        if(carRepository.findById(id).isPresent()) {
            carRepository.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }


    @Override
    public ResponseEntity<String> removeCarsFromEmployee(Long id) throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeById(id);
        carRepository.deleteCarsByEmployee(employee);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }
}