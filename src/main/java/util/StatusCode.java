package util;

public enum StatusCode {
    OK("200", "OK"),
    FOUND("302", "REDIRECT"),
    NOT_FOUND("404", "NOT FOUND");

    private String statusCode;
    private String statusMessage;

    StatusCode(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
