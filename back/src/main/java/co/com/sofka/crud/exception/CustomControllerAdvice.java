package co.com.sofka.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.NoSuchElementException;

public class CustomControllerAdvice {


        
        @ExceptionHandler(CustomErrorException.class) // exception handled
        public ResponseEntity<ErrorResponse> handleCustomException(
                        CustomErrorException e) {
                // ... potential custom logic

                e.getStatus();
                HttpStatus status = HttpStatus.I_AM_A_TEAPOT; // 404

                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                e.printStackTrace(printWriter);
                String stackTrace = stringWriter.toString();

                return new ResponseEntity<>(
                        new ErrorResponse(
                                status,
                                e.getMessage()),
                status);
        }

}
