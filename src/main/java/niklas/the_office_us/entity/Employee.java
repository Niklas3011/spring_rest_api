package niklas.the_office_us.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long employeeId;

    @NotNull
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String firstName;

    @NotNull
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String lastName;

    @NotNull(message = "Age is mandatory")
    private Integer age;

    @NotNull(message = "role is mandatory")
    private String role;


    @OneToMany(mappedBy = "employee",
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @ToString.Exclude
    private List<Car> car;


}
