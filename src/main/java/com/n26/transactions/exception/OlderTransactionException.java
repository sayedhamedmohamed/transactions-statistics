package com.n26.transactions.exception;

/**
 * The Class OlderTransactionException.
 * @author sayedhamed
 */
public class OlderTransactionException extends N26Exception{
	
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1;

    /**
     * Instantiates a new older transaction exception.
     */
    public OlderTransactionException() {
        super(204, "The transaction is older than 60 seconds");
    }

    /**
     * Instantiates a new older transaction exception.
     *
     * @param message the message
     */
    public OlderTransactionException(String message) {
        super(204, message);
    }
}
