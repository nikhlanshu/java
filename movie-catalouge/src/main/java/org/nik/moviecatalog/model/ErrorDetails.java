package org.nik.moviecatalog.model;

import java.util.Date;

public class ErrorDetails {
    private Throwable reason;
    private Date date;
    private String errorCode;
    private String message;

    public ErrorDetails(Throwable reason, Date date, String errorCode, String message) {
        this.reason = reason;
        this.date = date;
        this.errorCode = errorCode;
        this.message = message;
    }

    public Throwable getReason() {
        return reason;
    }

    public Date getDate() {
        return date;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
