package niklas.the_office_us.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee does not exist")
public class EmployeeNotFoundException extends Exception{
}
