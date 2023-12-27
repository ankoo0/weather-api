package com.senla.weather.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ProblemDetail handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        ProblemDetail pd = e.getBody();
        pd.setProperty("Violations: ", mapFieldErrors(fieldErrors));
        return pd;
    }

    @ExceptionHandler(Exception.class)
    ProblemDetail handleGenericException(Exception e) {
        log.error(e.getMessage());
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(InvalidDateRangeException.class)
    ProblemDetail handleInvalidDateRangeException(InvalidDateRangeException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ProblemDetail handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String problemMessage = e.getRootCause().getMessage();
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, extractErrorMessage(problemMessage));
    }

    private List<ValidationErrorDetail> mapFieldErrors(List<FieldError> fieldErrors) {
        return fieldErrors.stream()
                .map(fe ->
                        new ValidationErrorDetail(
                                fe.getDefaultMessage(),
                                fe.getRejectedValue(),
                                fe.getField()
                        )
                )
                .toList();
    }

    private String extractErrorMessage(String errorMessage) {
        String[] lines = errorMessage.split("\\n");
        if (lines.length > 0) {
            return lines[0];
        }
        return errorMessage;
    }
}