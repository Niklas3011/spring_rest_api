package niklas.the_office_us.service;

import niklas.the_office_us.Exception.CarNotFoundException;
import niklas.the_office_us.Exception.EmployeeNotFoundException;
import niklas.the_office_us.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarServiceImplTest {

    @Autowired
    private CarService carService;

    @Test
    void getCarById() throws CarNotFoundException {
        System.out.println(carService.getCarById(1L));
    }

    @Test
    void getCarsFromEmployee() throws EmployeeNotFoundException {
        List<Car> carList = carService.getCarsFromEmployee(15L);
        System.out.println("carList = " + carList);
    }

    @Test
    void saveCar() throws EmployeeNotFoundException {
        Car car = Car.builder()
                .numberPlate("ME N 500")
                .model("S 500")
                .hp(500)
                .buildYear(2005)
                .build();
        Car car1 = carService.saveCar(car, 2L);
        System.out.println("car1 = " + car1);
    }

    @Test
    void updateCarById() throws CarNotFoundException {
        Car car = Car.builder()
                .hp(120)
                .model("Toyota")
                .buildYear(2000)
                .numberPlate("ME E 302")
                .build();
        ResponseEntity<Car> responseEntity = carService.updateCarById(car, 1L);
        System.out.println("fertig");
        System.out.println(responseEntity);
    }

    @Test
    void removeCarById() throws CarNotFoundException {
        ResponseEntity<String> responseEntity = carService.removeCarById(4L);
        System.out.println("responseEntity = " + responseEntity);
    }

    @Test
    void removeCarsFromEmployee() throws EmployeeNotFoundException {
        ResponseEntity<String> responseEntity = carService.removeCarsFromEmployee(2L);
        System.out.println("responseEntity = " + responseEntity);
    }
}