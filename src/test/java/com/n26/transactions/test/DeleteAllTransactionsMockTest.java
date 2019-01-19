package com.n26.transactions.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.n26.transactions.controller.N26TransactionsController;
import com.n26.transactions.exception.handlers.OlderTransactionExceptionHandler;
import com.n26.transactions.exception.handlers.UnProcessableTransactionExceptionHandler;

/**
 * The Class DeleteAllTransactionsMockTest.
 * @author sayedhamed
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteAllTransactionsMockTest {

	/** The mock mvc. */
	private MockMvc mockMvc;

	/** The controller. */
	@Autowired
	private N26TransactionsController controller;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).
				setControllerAdvice(new OlderTransactionExceptionHandler()
						, new UnProcessableTransactionExceptionHandler()).build();
	}

	/**
	 * Test success transaction.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testSuccessTransaction() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/transactions");

		MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();

		assertEquals(204, response.getStatus());

	}

	/**
	 * Test get statistics after delete.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetStatisticsAfterDelete() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/statistics");

		MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();

		assertEquals(200, response.getStatus());

	}
}
