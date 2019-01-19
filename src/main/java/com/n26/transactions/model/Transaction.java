package com.n26.transactions.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.n26.transactions.constants.AppConstants;


/**
 * The Class Transaction.
 * @author sayedhamed
 */
@JsonInclude(Include.NON_NULL)
public class Transaction implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant TIME_DIFFERENCE_IN_MILLIS. */
	private static final long TIME_DIFFERENCE_IN_MILLIS = 60000;

	/** The amount. */
	private BigDecimal amount;
	
	/** The timestamp. */
	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT, timezone = AppConstants.N26_DEFAULT_TIMEZONE)
	private Date timestamp;
	
	public Transaction() {
	}

	/**
	 * Instantiates a new transaction.
	 *
	 * @param amount the amount
	 * @param timestamp the timestamp
	 */
	public Transaction(BigDecimal amount, Date timestamp) {
		this.amount = amount;
		this.timestamp = timestamp;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	
	/**
	 * Exceed limit.
	 *
	 * @return true, if successful
	 */
	public boolean exceedLimit() {
		
		return (System.currentTimeMillis() - timestamp.getTime() > TIME_DIFFERENCE_IN_MILLIS);
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", timestamp=" + timestamp + "]";
	}
	
	
	
}
