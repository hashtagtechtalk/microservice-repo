package controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@ControllerAdvice
@RestController
public class CustomExceptionHandle  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleHttpRequestMethodNotSupported(Exception ex,  WebRequest request) {
        CustomResponse custumResponse = new CustomResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),new Date().toString());
        return new ResponseEntity(custumResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
