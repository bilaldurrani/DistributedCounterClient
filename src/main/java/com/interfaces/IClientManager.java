package com.interfaces;

public interface IClientManager {
	
	/**
	 * Performs an action on the given address.
	 * @param address	The full address of the node to use.
	 * @param action	This can be "increment", "decrement", "getcount". NOTE: This should be an enum.
	 */
	public void performAction(String address, String action);
}
