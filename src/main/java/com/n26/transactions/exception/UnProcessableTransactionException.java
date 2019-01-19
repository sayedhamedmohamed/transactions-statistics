package com.n26.transactions.exception;

/**
 * The Class UnProcessableTransactionException.
 *
 * @author sayedhamed
 */
public class UnProcessableTransactionException extends N26Exception{
	
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1;

    /**
     * Instantiates a new un processable transaction exception.
     */
    public UnProcessableTransactionException() {
        super(422, "the fields are not parsable or the transaction date is in the future");
    }

    /**
     * Instantiates a new un processable transaction exception.
     *
     * @param message the message
     */
    public UnProcessableTransactionException(String message) {
        super(422, message);
    }
}
