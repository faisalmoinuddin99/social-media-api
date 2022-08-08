package com.in28minutes.rest.webservices.restfullwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
    // timestamp
    // message
    // detail

    private final Date timeStamp ;
    private final String message ;
    private final String detail ;

    public ExceptionResponse(Date timeStamp, String message, String detail) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.detail = detail;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }
}
