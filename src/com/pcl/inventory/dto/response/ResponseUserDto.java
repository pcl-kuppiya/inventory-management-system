package com.pcl.inventory.dto.response;

public class ResponseUserDto {
    private String email;
    private String name;
    private String statusCode;
    private String message;

    public ResponseUserDto() {
    }

    public ResponseUserDto(String email, String name, String statusCode, String message) {
        this.email = email;
        this.name = name;
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
