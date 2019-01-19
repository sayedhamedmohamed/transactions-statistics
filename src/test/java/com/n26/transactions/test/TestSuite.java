package com.n26.transactions.test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The Class TestSuite.
 * @author sayedhamed
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	AdTransactionMockTest.class,
	GetStatisticsMockTest.class,
	DeleteAllTransactionsMockTest.class,
})
public class TestSuite {

}