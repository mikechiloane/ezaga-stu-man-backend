package co.za.faboda.ezagastumanbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}
