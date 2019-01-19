package com.n26.transactions.exception;


/**
 * The Class BadRequestException.
 * @author sayedhamed
 */
public class BadRequestException extends N26Exception {
	
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1;

    /**
     * Instantiates a new bad request exception.
     */
    public BadRequestException() {
        super(400, "The request is invalid");
    }

    /**
     * Instantiates a new bad request exception.
     *
     * @param message the message
     */
    public BadRequestException(String message) {
        super(400, message);
    }
}

