package com.challenge.PlaceService;

import com.challenge.PlaceService.Dtos.PlaceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import javax.naming.Name;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlaceServiceApplicationTests {
	@Autowired
	WebTestClient client;



	@Test
	void contextLoads() {
	}

	@Test
	void testPlaceCreate(){
		/*
		PlaceDto dto = new PlaceDto();
		dto.setName("ola");
		dto.setCity("teste");
		dto.setState("teste5");
		client.post().uri("/").bodyValue(new PlaceDto()).exchange().expectBody()
				.jsonPath("name").isEqualTo(dto.getName())
				.jsonPath("city").isEqualTo(dto.getCity());*/
	}


}
