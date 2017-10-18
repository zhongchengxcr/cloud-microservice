package com.zc.cloud.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleProviderUserApplicationTests {

	ThreadLocal<String> path = ThreadLocal.withInitial(() -> "path");

	@Test
	public void contextLoads() {
	}

}
