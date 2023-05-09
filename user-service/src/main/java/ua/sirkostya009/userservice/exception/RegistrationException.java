package ua.sirkostya009.userservice.exception;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@StandardException
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class RegistrationException extends RuntimeException {
}
