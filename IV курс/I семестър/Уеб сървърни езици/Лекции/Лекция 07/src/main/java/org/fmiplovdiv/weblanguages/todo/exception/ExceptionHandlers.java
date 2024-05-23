package org.fmiplovdiv.weblanguages.todo.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler({NoSuchElementException.class})
	public ResponseEntity<Object> handleNoSuchElement(Exception ex, WebRequest wr) {
		return new ResponseEntity<Object>(
				"No such element found!", 
				new HttpHeaders(),
				HttpStatus.BAD_REQUEST
				);
	}
}
