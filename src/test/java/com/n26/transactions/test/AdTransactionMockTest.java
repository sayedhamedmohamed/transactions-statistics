package com.n26.transactions.test;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.n26.transactions.constants.AppConstants;
import com.n26.transactions.controller.N26TransactionsController;
import com.n26.transactions.exception.handlers.OlderTransactionExceptionHandler;
import com.n26.transactions.exception.handlers.UnProcessableTransactionExceptionHandler;


/**
 * The Class AdTransactionMockTest.
 * @author sayedhamed
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdTransactionMockTest {

	/** The mock mvc. */
	private MockMvc mockMvc;

	/** The controller. */
	@Autowired
	private N26TransactionsController controller;

	/** The sdf. */
	private SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.DEFAULT_DATE_FORMAT);

	String successTransaction = "{\n" + 
			"  \"amount\": \"01.3222\",\n" + 
			"  \"timestamp\": \""
			+ sdf.format(new Date(new Date().getTime() - (1000 * 60 * 60 * 2)))
			+ " +\"\n" + 
			"}"	;


	String badTransaction = "{\n" + 
			"  \"amount\": 01.3222,\n" + 
			"  \"timestamp\": \"2019-01-19T06:16:14.312Z\"\n" + 
			"}"	;

	String unParsableTransaction = "{\n" + 
			"  \"amount\": \"01.3222\",\n" + 
			"  \"timestamp\": \""
			+ sdf.format(new Date(new Date().getTime() + (1000 * 60 * 60 * 24)))
			+ " +\"\n" + 
			"}"	;
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

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/transactions").content(successTransaction)
				.contentType(MediaType.APPLICATION_JSON);

		MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();

		assertEquals(201, response.getStatus());

	}

	/**
	 * Test bad transaction.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testBadTransaction() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/transactions").content(badTransaction)
				.contentType(MediaType.APPLICATION_JSON);

		MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();

		assertEquals(422, response.getStatus());

	}

	/**
	 * Test unparsable transaction.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testUnparsableTransaction() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/transactions").content(unParsableTransaction)
				.contentType(MediaType.APPLICATION_JSON);

		MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();

		assertEquals(422, response.getStatus());

	}
}
