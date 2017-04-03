package com.interfaces;

public interface IDistributedCounterClient {

	public void decrement(String ip);
	
	public void increment(String ip);
	
	public int getCount(String ip);
}
