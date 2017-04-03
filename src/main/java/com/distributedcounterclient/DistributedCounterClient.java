package com.distributedcounterclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.interfaces.IDistributedCounterClient;

@Service
public class DistributedCounterClient implements IDistributedCounterClient{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public int getCount(String ip) throws RestClientException {
		try {
			String url = String.format("%s/%s", ip, "/counter");
			return restTemplate.getForObject(url, int.class);
		}
		catch (RestClientException e) {
			logger.error("Error in getting count", e);
			throw e;
		}
	}
	
	@Override
	public void increment(String ip) throws RestClientException {
		try {
			String url = String.format("%s/%s", ip, "/increment");
			restTemplate.put(url, null);
			System.out.println("Counter has been incremented");
		}
		catch (RestClientException e) {
			logger.error("Error in incrementing", e);
			throw e;
		}
	}
	
	@Override
	public void decrement(String ip) throws RestClientException {
		try {
			String url = String.format("%s/%s", ip, "/decrement");
			restTemplate.put(url, null);
			System.out.println("Counter has been decremented");
		}
		catch (RestClientException e) {
			logger.error("Error in decrementing", e);
			throw e;
		}
	}
}
