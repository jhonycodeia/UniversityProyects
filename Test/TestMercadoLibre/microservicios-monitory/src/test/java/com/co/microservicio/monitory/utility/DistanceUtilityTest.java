package com.co.microservicio.monitory.utility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class DistanceUtilityTest {
	
	@InjectMocks
	private DistanceUtility distance;

	@Test
	public final void testDistanciaCoord() throws Exception {
		try {
			//Colombia
			double distancia = distance.distanciaCoord(4,-73.25);
			
			log.info("la distancia entre AR y CO es "+distancia);
			
			assertThat(distancia).isNotNull();
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

}
