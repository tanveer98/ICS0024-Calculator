package ee.taltech.team7.calculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "The return value has overflowed!")
public class OverflowedLongException extends RuntimeException {
    public OverflowedLongException(String msg) {
        super(msg);
    }
}
