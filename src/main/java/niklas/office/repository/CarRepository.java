package niklas.office.repository;

import niklas.office.entity.Car;
import niklas.office.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarsByEmployee(Employee employee);

    void deleteCarsByEmployee(Employee employee);

    /*
    @Query("select c from Car c where c.employee = :employeeId")
    public Car getCar(@Param("employeeId") Long employeeId);*/
}
