package com.example.MNCI.exceptions;

import org.springframework.mail.MailException;

import java.security.GeneralSecurityException;

public class SpringMNCIException extends RuntimeException {
    // Different than SR clone
    public SpringMNCIException(String exMessage, MailException e) {
        super(exMessage);
    }

    public SpringMNCIException(String invalid_token) {
    }

    public SpringMNCIException(String exMessage, GeneralSecurityException e) {
    }
}
