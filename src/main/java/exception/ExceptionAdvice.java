package exception;

import exception.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrors validate(MethodArgumentNotValidException exception) {
        var fields = exception.getBindingResult().getFieldErrors();

        ValidationErrors validationErrors = new ValidationErrors();

        fields.forEach(validationErrors::addFieldError);

        return validationErrors;
    }

//    @ExceptionHandler(Exception.class)
//    public String onException() {
//        return "internal error!";
//    }
}
