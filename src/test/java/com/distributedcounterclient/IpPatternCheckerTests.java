package com.distributedcounterclient;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IpPatternCheckerTests {

	@Test
	public void CheckCorrectIpPort() {
		IpPatternChecker checker = new IpPatternChecker();
		
		String ip = "192.168.1.1";
		String port = "8080";
		
		assertThat(checker.checkIp(ip, port)).isTrue();
	}
	
	@Test
	public void CheckInCorrectIp() {
		IpPatternChecker checker = new IpPatternChecker();
		
		String ip = "localhost";
		String port = "8080";
		
		assertThat(checker.checkIp(ip, port)).isFalse();
	}
	
	@Test
	public void CheckInCorrectPort() {
		IpPatternChecker checker = new IpPatternChecker();
		
		String ip = "192.168.1.1";
		String port = "abc";
		
		assertThat(checker.checkIp(ip, port)).isFalse();
	}
	
	@Test
	public void CheckInCorrectIpAndPort() {
		IpPatternChecker checker = new IpPatternChecker();
		
		String ip = "localhost";
		String port = "abc";
		
		assertThat(checker.checkIp(ip, port)).isFalse();
	}
}
