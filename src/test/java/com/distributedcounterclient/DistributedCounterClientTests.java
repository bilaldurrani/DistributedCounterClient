package com.distributedcounterclient;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.interfaces.IDistributedCounterClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistributedCounterClientTests {

	@MockBean
	private RestTemplate restTemplate;
	
	@Autowired
	private IDistributedCounterClient client;
	
	@Test
	public void GetCount() {
        Mockito.when(this.restTemplate.getForObject("TESTURL//counter", int.class)).thenReturn(5);
        
        int received = client.getCount("TESTURL");
        
        assertThat(received).isEqualTo(5);
	}
	
	@Test(expected = RestClientException.class)
	public void GetCount_Exception() {
		Mockito.doThrow(RestClientException.class).when(this.restTemplate).getForObject("TESTURL//counter", int.class);
        
        client.getCount("TESTURL");
	}
	
	@Test
	public void Increment() {
        client.increment("TESTURL");
        
        Mockito.verify(this.restTemplate).put("TESTURL//increment", null);
	}
	
	@Test(expected = RestClientException.class)
	public void Increment_Exception() {
		Mockito.doThrow(RestClientException.class).when(this.restTemplate).put("TESTURL//increment", null);
        
        client.increment("TESTURL");
	}
	
	@Test
	public void Decrement() {
        client.decrement("TESTURL");
        
        Mockito.verify(this.restTemplate).put("TESTURL//decrement", null);
	}
	
	@Test(expected = RestClientException.class)
	public void Decrement_Exception() {
		Mockito.doThrow(RestClientException.class).when(this.restTemplate).put("TESTURL//decrement", null);
        
        client.decrement("TESTURL");
	}
}
