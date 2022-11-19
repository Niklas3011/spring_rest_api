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

}
