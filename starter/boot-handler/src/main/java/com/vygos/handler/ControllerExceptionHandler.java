package com.vygos.handler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    ResponseError response = ResponseError.builder()
        .status(status.value())
        .error(((HttpStatus)status).getReasonPhrase())
        .timestamp(ZonedDateTime.now())
        .errors(new ArrayList<>())
        .build();

    for (FieldError fieldError : ex.getFieldErrors()) {
      ResponseFieldError responseFieldError = ResponseFieldError.builder()
          .fieldName(fieldError.getField())
          .error(fieldError.getDefaultMessage())
          .build();

      response.getErrors().add(responseFieldError);
    }
    return handleExceptionInternal(ex, response, headers, status, request);
  }

  @Builder
  @Getter
  @Setter
  public static class ResponseError {
    private ZonedDateTime timestamp;
    private int status;
    private String error;
    private List<ResponseFieldError> errors;
  }

  @Builder
  @Getter
  @Setter
  public static class ResponseFieldError {
    private String fieldName;
    private String error;
  }
}
