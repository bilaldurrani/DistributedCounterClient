package com.distributedcounterclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.interfaces.IClientManager;

@SpringBootApplication
@ComponentScan
public class DistributedCounterClientApplication {

	private static final Logger logger = LoggerFactory.getLogger("DistributedCounterClientApplication.Main");
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DistributedCounterClientApplication.class, args);

		if(args.length >= 3) {
			String ip = args[0];
			String port = args[1];
			String action = args[2];
			
			RunAction(ctx, ip, port, action);
		}
		else {
			logger.error("Input needs to be IP, PORT and COMMAND");
		}
		
	}
	
	public static void RunAction(ApplicationContext ctx, String ip, String port, String action) {
		logger.info("Using IP: {} & Port: {} to perform Action: {}", ip, port, action);
		
		IpPatternChecker ipChecker = new IpPatternChecker();
		boolean validIpAndPort = ipChecker.checkIp(ip, port);
		
		if(validIpAndPort) {
			logger.info("Ip is valid. Performing action: {}", action);
			String address = String.format("http://%s:%s", ip, port);
			
			IClientManager client = ctx.getBean(IClientManager.class);
			client.performAction(address, action);
		}
		else {
			logger.error("Ip or port is invalid. IP Needs to be in format int.int.int.int and port should be an in");
		}
	}
}
