package com.qubus.search.commons;

import com.qubus.search.commons.error.JeopardyErrorFormatter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@NoArgsConstructor
@Slf4j
@RestController
public class DefaultErrorController {

    @RequestMapping(method = {GET, DELETE, PUT}, path = "${server.error.path:${error.path:/error}}")
    public ResponseEntity<Object> handle(ServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            return JeopardyErrorFormatter.of(HttpStatus.valueOf(Integer.valueOf(status.toString())), "Server unable to process the request due to some internal error.");
        }
        return JeopardyErrorFormatter.of(HttpStatus.INTERNAL_SERVER_ERROR, "Server unable to process the request due to some internal error.");
    }
}