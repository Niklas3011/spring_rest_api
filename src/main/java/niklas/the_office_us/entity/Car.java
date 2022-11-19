package niklas.the_office_us.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
    private Long carId;
    private String numberPlate;
    private String model;
    private Integer hp;
    private Integer buildYear;

    @ManyToOne
    @JoinColumn(
            name = "fk_employee",
            referencedColumnName = "employeeId"
    )
    @ToString.Exclude
    private Employee employee;
}