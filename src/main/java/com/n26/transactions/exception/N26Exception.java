package com.n26.transactions.exception;

/**
 * The Class N26Exception.
 * @author sayedhamed
 */
public class N26Exception extends Exception {
	
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1;
    
    /** The message. */
    private final String message;
    
    /** The code. */
    private final Integer code;

    /**
     * Instantiates a new n 26 exception.
     *
     * @param code the code
     * @param message the message
     */
    public N26Exception(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public Integer getCode() {
        return this.code;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return this.message;
    }
}

