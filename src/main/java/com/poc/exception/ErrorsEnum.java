package com.poc.exception;

public enum ErrorsEnum {

    /**
     * ERR_MCS_POC
     */

    ERR_MCS_USER_USERNAME_EMPTY("Error occurred - Required field username not found"),
    ERR_MCS_USER_PASSWORD_EMPTY("Error occurred - Required field password not found"),
    ERR_MCS_USER_NOT_FOUND("Error occurred - No user found with this id"),
    ERR_MCS_USER_USERNAME_NOT_FOUND("Error occurred - No user found with this username"),
    ERR_MCS_ROLE_NOT_FOUND("Error occurred - No role found with this name"),
    ERR_MCS_USER_USERNAME_EXIST("Error occurred - Username is already taken"),
    ERR_MCS_USER_EMAIL_EXIST("Error occurred - Email is already in use"),
    ERR_MCS_EMAIL_INVALID("Error occurred - email invalid"),
    ERR_MCS_NOTE_NOT_FOUND("Error occurred - no Note found with this id");

    private final String errorMessage;

    private ErrorsEnum(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return " errorMessage : " + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
