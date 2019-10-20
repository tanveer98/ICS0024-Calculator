package ee.taltech.team7.calculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "bad search id")
public class ObjectNotFoundException extends RuntimeException {

}
