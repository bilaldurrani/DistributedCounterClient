package com.interfaces;

public interface IDistributedCounterClient {

	/**
	 * Decrements the counter on the given node.
	 * @param ip	The node to use.
	 */
	public void decrement(String ip);
	
	/**
	 * Increments the counter on the given node.
	 * @param ip	The node to use.
	 */
	public void increment(String ip);
	
	/**
	 * Gets the cluster count value of the node. 
	 * @param ip	The node to use.
	 */
	public int getCount(String ip);
}
