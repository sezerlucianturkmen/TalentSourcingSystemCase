package com.sezer.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    ENTITY_NOT_SAVED(2002, "Invalid Parameter Error", BAD_REQUEST),

    CANDIDATE_NOT_CREATED(2010, "Invalid Parameter Error", BAD_REQUEST),
    INTERACTION_NOT_CREATED(2011, "Invalid Parameter Error", BAD_REQUEST),
    CONTACT_INFORMATION_NOT_CREATED(2012, "Invalid Parameter Error", BAD_REQUEST),

    CANDIDATE_NOT_UPDATED(2020, "Invalid Parameter Error", BAD_REQUEST),
    INTERACTION_NOT_UPDATED(2021, "Invalid Parameter Error", BAD_REQUEST),
    CONTACT_INFORMATION_NOT_UPDATED(2022, "Invalid Parameter Error", BAD_REQUEST),


    CANDIDATE_NOT_FOUND(2030, "Invalid Parameter Error", BAD_REQUEST),
    INTERACTION_NOT_FOUND(2031, "Invalid Parameter Error", BAD_REQUEST),
    CONTACT_INFORMATION_FOUND(2032, "Invalid Parameter Error", BAD_REQUEST);


    private int code;
    private String message;
    HttpStatus httpStatus;

}