package in.ineuron.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.exception.TouristNotFoundException;

@RestControllerAdvice
public class Exceptionhandler {
    @ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> TouristNotFoundException(TouristNotFoundException t){
		System.out.println("Exceptionhandler.TouristNotFoundException()");
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),t.getMessage(),"404");

		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> FoundException(Exception e){
    	System.out.println("Exceptionhandler.FoundException()");
    	ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),e.getMessage(),"problen in server.");
    	 e.printStackTrace();
    	return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
    }
    
	
	
}
