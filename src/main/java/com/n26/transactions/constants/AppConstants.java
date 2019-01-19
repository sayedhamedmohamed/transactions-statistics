package com.n26.transactions.constants;

/**
 * The Class AppConstants.
 * @author sayedhamed
 */
public final class AppConstants {

	/**
	 * To avoid creating instance of AppConstants class.
	 */
	private AppConstants() {
		throw new IllegalStateException("AppConstants class are not meant to be instantiated.");
	}
	
	/** The Constant N26_DEFAULT_TIMEZONE. */
	public static final String N26_DEFAULT_TIMEZONE = "GMT";


	/** The Constant DEFAULT_DATE_FORMAT. */
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
}
