package com.n26.transactions.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.n26.transactions.exception.N26Exception;
import com.n26.transactions.exception.OlderTransactionException;
import com.n26.transactions.exception.UnProcessableTransactionException;
import com.n26.transactions.model.Statistics;
import com.n26.transactions.model.Transaction;

/**
 * The Class N26TransactionServiceImp.
 * @author sayedhamed
 */
@Service
public class N26TransactionServiceImp implements N26TransactionService{

	/** The transactions map. */
	private static ConcurrentHashMap<String, Transaction> transactionsMap = new ConcurrentHashMap<>();

	/** The logger. */
	Logger logger = LogManager.getLogger(this.getClass());

	/* (non-Javadoc)
	 * @see com.n26.transactions.service.N26TransactionService#savetransaction(com.n26.transactions.model.Transaction)
	 */
	@Override
	public void savetransaction(Transaction transaction) throws N26Exception {

		validateTransactionData(transaction);

		transactionsMap.put(UUID.randomUUID().toString(), transaction);

		logger.info(transactionsMap.size());
	}

	/* (non-Javadoc)
	 * @see com.n26.transactions.service.N26TransactionService#calculateStatistics()
	 */
	@Override
	public Statistics calculateStatistics() throws N26Exception {

		if(transactionsMap.isEmpty())
            return new Statistics("0.00", "0.00", "0.00", "0.00", 0);
		
		transactionsMap.values().removeIf(Transaction::exceedLimit);

		ConcurrentHashMap<String, Transaction> transactionsMapForStatistics = transactionsMap;

		BigDecimal sum = BigDecimal.valueOf(transactionsMapForStatistics.values().stream().
				mapToDouble(t -> t.getAmount().doubleValue()).sum()).setScale(2, RoundingMode.HALF_UP);

		BigDecimal average = sum.divide(new BigDecimal(transactionsMapForStatistics.size()), RoundingMode.HALF_UP);

		BigDecimal max = Collections.max(transactionsMapForStatistics.values(), 
				Comparator.comparingDouble(t -> t.getAmount().doubleValue())).getAmount().setScale(2, RoundingMode.HALF_UP);

		BigDecimal min = Collections.min(transactionsMapForStatistics.values(), 
				Comparator.comparingDouble(t -> t.getAmount().doubleValue())).getAmount().setScale(2, RoundingMode.HALF_UP);

		return new Statistics(sum.toString(), average.toString(), max.toString(), min.toString(), transactionsMapForStatistics.size());
	}

	/* (non-Javadoc)
	 * @see com.n26.transactions.service.N26TransactionService#deleteTransactions()
	 */
	@Override
	public void deleteTransactions() {

		transactionsMap.clear();

		logger.info(transactionsMap.size());
	}
	
	/**
	 * Validate transaction data.
	 *
	 * @param transaction the transaction
	 * @throws UnProcessableTransactionException the un processable transaction exception
	 * @throws OlderTransactionException the older transaction exception
	 */
	private void validateTransactionData(Transaction transaction) throws UnProcessableTransactionException, OlderTransactionException {

		if(new Date().before(transaction.getTimestamp()))
			throw new UnProcessableTransactionException();

		logger.info(System.currentTimeMillis() - transaction.getTimestamp().getTime());

		if(transaction.exceedLimit())
			throw new OlderTransactionException();
	}
}
