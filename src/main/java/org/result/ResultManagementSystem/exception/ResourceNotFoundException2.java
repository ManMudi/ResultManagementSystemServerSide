package org.result.ResultManagementSystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public class ResourceNotFoundException2 extends RuntimeException{
    private HttpStatus httpStatus;
    private String message;
}
