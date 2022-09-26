package com.doctransfer.userservice.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() { super("User not found."); }
}
