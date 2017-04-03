package com.distributedcounterclient;

import static org.mockito.Matchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.interfaces.IClientManager;
import com.interfaces.IDistributedCounterClient;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientManagerTests {

	@MockBean
	IDistributedCounterClient client;
	
	@Autowired
	IClientManager manager;
	
	@Test
	public void CheckIncrement() {
		manager.performAction("TEST", "increment");
		
		Mockito.verify(client).increment(any());
	}
	
	@Test
	public void CheckDecrement() {
		manager.performAction("TEST", "decrement");

		Mockito.verify(client).decrement(any());
	}
	
	@Test
	public void CheckGetCount() {
		manager.performAction("TEST", "getcount");
		
		Mockito.verify(client).getCount(any());
	}
	
	@Test
	public void CheckOther() {
		manager.performAction("TEST", "XYZ");
		
		verifyZeroInteractions(client);
	}
}
