package com.example.demo.presentation.responseentity;

import com.example.demo.presentation.responseentity.response.ServiceUnavailableResponseEntity;
import com.example.demo.presentation.responseentity.response.SuccessfulRequestResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityUtil {

    public static ResponseEntity<Object> generateSuccessfulRequestResponseEntity(
            SuccessfulRequestResponseEntity<?> successfulRequestResponseEntity
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(successfulRequestResponseEntity);
    }

    public static ResponseEntity<Object> generateUnavailableRequestResponseEntity(
            ServiceUnavailableResponseEntity<?> serviceUnavailableResponseEntity
    ) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(serviceUnavailableResponseEntity);
    }
}
