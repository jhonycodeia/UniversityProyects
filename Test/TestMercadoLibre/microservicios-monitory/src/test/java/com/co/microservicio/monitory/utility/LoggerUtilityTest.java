package com.co.microservicio.monitory.utility;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class LoggerUtilityTest {
	
	@InjectMocks
	LoggerUtility loggerUser;

	@Test
	public final void testLogUser() throws Exception {
		try {
			loggerUser.logUser("1234423;"+new Date());
			loggerUser.logUser("1234425;"+new Date());
			loggerUser.logUser("1234426;"+new Date());
			loggerUser.logUser("1234427;"+new Date());
			loggerUser.logUser("1234428;"+new Date());
			
			File log = new File("userlog.log");
			File csv = new File("user.csv");
			
			assertThat(log.exists()).isTrue();
			assertThat(csv.exists()).isTrue();
			
		}catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

}
