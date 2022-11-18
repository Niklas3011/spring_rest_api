package niklas.the_office_us.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Car does not exist")
public class CarNotFoundException extends Exception{
}
