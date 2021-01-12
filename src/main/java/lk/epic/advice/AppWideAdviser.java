package lk.epic.advice;

import lk.epic.util.StrandedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideAdviser {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity handler(RuntimeException e) {
        return new ResponseEntity(new StrandedResponse(5, e.getMessage(), null), HttpStatus.OK);
    }
}
