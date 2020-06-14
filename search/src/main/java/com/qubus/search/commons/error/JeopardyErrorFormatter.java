package com.qubus.search.commons.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JeopardyErrorFormatter {

    public static ResponseEntity<Object> of(final HttpStatus status, final String message) {
        return ResponseEntity.status(status)
                .body(JeopardyError.builder()
                        .message(message).build());
    }
}
