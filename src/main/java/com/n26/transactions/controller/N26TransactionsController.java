package com.n26.transactions.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.transactions.exception.N26Exception;
import com.n26.transactions.model.Statistics;
import com.n26.transactions.model.Transaction;
import com.n26.transactions.service.N26TransactionServiceImp;

/**
 * The Class N26TransactionsController.
 * @author sayedhamed
 */

@RestController
public class N26TransactionsController {

	/** The logger. */
	Logger logger = LogManager.getLogger(this.getClass());
	
	/** The n 26 transaction service imp. */
	@Autowired
	private N26TransactionServiceImp n26TransactionServiceImp;
	
	/**
	 * Save transaction.
	 *
	 * @param transaction the transaction
	 * @return the response entity
	 * @throws N26Exception the n 26 exception
	 */
	@PostMapping(value = "/transactions", consumes = { "application/json" })
	protected ResponseEntity<Object> saveTransaction(@Validated @RequestBody Transaction transaction) throws N26Exception {

		n26TransactionServiceImp.savetransaction(transaction);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	/**
	 * Gets the statistics.
	 *
	 * @return the statistics
	 * @throws N26Exception the n 26 exception
	 */
	@GetMapping(value = "/statistics")
	protected ResponseEntity<Object> getStatistics() throws N26Exception {

		Statistics statistics = n26TransactionServiceImp.calculateStatistics();
		
		return new ResponseEntity<>(statistics, HttpStatus.OK);
	}
	
	/**
	 * Delete all transactions.
	 *
	 * @return the response entity
	 */
	@DeleteMapping(value = "/transactions")
	protected ResponseEntity<Object> deleteAllTransactions() {

		n26TransactionServiceImp.deleteTransactions();

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}

