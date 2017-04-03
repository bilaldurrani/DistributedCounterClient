package com.distributedcounterclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.interfaces.IClientManager;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistributedCounterClientApplicationTests {

	@Mock 
	ApplicationContext ctx;
	
	@Mock 
	IClientManager manager;
	
	@Test
	public void contextLoads() {
		String[] args = new String[0];
		DistributedCounterClientApplication.main(args);
	}
	
	@Test
	public void RunAction() throws Exception {
		Mockito.when(ctx.getBean(IClientManager.class)).thenReturn(manager);
		
		DistributedCounterClientApplication.RunAction(ctx, "1.1.1.1", "8080", "increment");
		
		Mockito.verify(manager).performAction("http://1.1.1.1:8080", "increment");
	}
	
	@Test
	public void RunActionFailure() throws Exception {
		Mockito.when(ctx.getBean(IClientManager.class)).thenReturn(manager);
		
		DistributedCounterClientApplication.RunAction(ctx, "localhost", "8080", "increment");
		
		verifyZeroInteractions(manager);
	}
}
