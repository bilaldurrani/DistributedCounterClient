package com.distributedcounterclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interfaces.IClientManager;
import com.interfaces.IDistributedCounterClient;

@Service
public class ClientManager implements IClientManager {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IDistributedCounterClient client;
	
	@Override
	public void performAction(String address, String action) {
		System.out.println(String.format("Performing action: %s on address: %s", action, address));
		
		if(action.equals("increment")){
			client.increment(address);
		}
		else if(action.equals("decrement")){
			client.decrement(address);
		}
		else if(action.equals("getcount")){
			int count = client.getCount(address);
			System.out.println(String.format("Counter value is: %d", count));
		}
		else {
			logger.error("Actions supported are 'increment', 'decrement', 'getcount',");
		}
	}

}
