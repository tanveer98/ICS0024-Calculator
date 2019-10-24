package ee.taltech.team7.calculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "invalid parameter")
public class NullParameterException extends RuntimeException {
}
