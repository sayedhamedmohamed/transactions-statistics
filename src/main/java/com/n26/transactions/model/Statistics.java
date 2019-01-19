package com.n26.transactions.model;


/**
 * The Class Statistics.
 * @author sayedhamed
 */
public class Statistics {
	
	/** The sum. */
	private String sum;
	
	/** The avg. */
	private String avg;

	/** The max. */
	private String max;

	/** The min. */
	private String min;

	/** The count. */
	private Integer count;

	/**
	 * Instantiates a new statistics.
	 *
	 * @param sum the sum
	 * @param avg the avg
	 * @param max the max
	 * @param min the min
	 * @param count the count
	 */
	public Statistics(String sum, String avg, String max, String min, Integer count) {
		this.sum = sum;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.count = count;
	}

	/**
	 * Gets the sum.
	 *
	 * @return the sum
	 */
	public String getSum() {
		return sum;
	}

	/**
	 * Gets the avg.
	 *
	 * @return the avg
	 */
	public String getAvg() {
		return avg;
	}

	/**
	 * Gets the max.
	 *
	 * @return the max
	 */
	public String getMax() {
		return max;
	}

	/**
	 * Gets the min.
	 *
	 * @return the min
	 */
	public String getMin() {
		return min;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	

}
