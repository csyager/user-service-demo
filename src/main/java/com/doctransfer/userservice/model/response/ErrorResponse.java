package com.doctransfer.userservice.model.response;

public record ErrorResponse(String message, ErrorType errorType) {
}
