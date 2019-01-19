package com.n26.transactions.service;

import com.n26.transactions.exception.N26Exception;
import com.n26.transactions.model.Statistics;
import com.n26.transactions.model.Transaction;

/**
 * The Interface N26TransactionService.
 * @author sayedhamed
 */
public interface N26TransactionService {
	
	/**
	 * Savetransaction.
	 *
	 * @param transaction the transaction
	 * @throws N26Exception the n 26 exception
	 */
	public void savetransaction(Transaction transaction) throws N26Exception;
	
	/**
	 * Calculate statistics.
	 *
	 * @return the statistics
	 * @throws N26Exception the n 26 exception
	 */
	public Statistics calculateStatistics() throws N26Exception;
	
	/**
	 * Delete transactions.
	 */
	public void deleteTransactions();

}
