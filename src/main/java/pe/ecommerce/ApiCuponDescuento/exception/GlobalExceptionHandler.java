
package pe.ecommerce.ApiCuponDescuento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.ecommerce.ApiCuponDescuento.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    
    public ResponseEntity<ErrorResponseDto>
            andleEntityNotFound(EntityNotFoundException ex){
            var status = HttpStatus.NOT_FOUND;
            var errorResponse=new ErrorResponseDto(status,
                    ex.getMessage(), ex.toString());
            return new ResponseEntity<>(errorResponse,status);
       }
    
}
