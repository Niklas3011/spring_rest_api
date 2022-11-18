package niklas.the_office_us;

import niklas.the_office_us.Exception.CarNotFoundException;
import niklas.the_office_us.entity.Car;
import niklas.the_office_us.entity.Employee;
import niklas.the_office_us.service.CarService;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TheOfficeUsApplication {

    //private CarService service;

    public static void main(String[] args) {
        SpringApplication.run(TheOfficeUsApplication.class, args);
    }

    /*@Bean
    public String getCarById(@NotNull CarService carService) throws CarNotFoundException {
        System.out.println("Bean startet");
        Car car = carService.getCarById(2L);
        System.out.println(car);
        System.out.println("Bean stoppt");
        return "fertig";
    }*/

    /*@Bean
    public String savingCar(@NotNull CarService service){
        System.out.println("Bean wurde gestartet");
        Employee employee = Employee.builder()
                .firstName("Lebron")
                .lastName("James")
                .age(40)
                .role("Player")
                .build();

        Car car = Car.builder()
                .Model("M5")
                .hp(400)
                .numberPlate("ME DV")
                .buildYear(2005)
                .employee(employee)
                .build();
        service.simepleSaveCar(car);
        System.out.println("Bean ist fertig");
        return "fetig";
    }*/



}
