package in.jatint4r.springbootcrudoperations.exception;

import in.jatint4r.springbootcrudoperations.dto.ExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> resourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request){
          ExceptionDto exceptionDto = new ExceptionDto(
                  LocalDateTime.now(),
                  HttpStatus.NOT_FOUND.value(),
                  HttpStatus.NOT_FOUND.getReasonPhrase(),
                  ex.getMessage(),
                  request.getRequestURI()

          );
           return ResponseEntity.
                  status(HttpStatus.NOT_FOUND).
                   body(exceptionDto);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ExceptionDto> duplicateException(DuplicateException ex, HttpServletRequest request){
        ExceptionDto exceptionDto = new ExceptionDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity.
                status(HttpStatus.CONFLICT).
                body(exceptionDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> argumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request){
        ExceptionDto exceptionDto = new ExceptionDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity.
                status(HttpStatus.CONFLICT).
                body(exceptionDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> genericException(Exception ex, HttpServletRequest request){
        ExceptionDto exceptionDto = new ExceptionDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(exceptionDto);
    }
}
