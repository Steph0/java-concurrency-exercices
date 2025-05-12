package com.steph0.java_concurrency_exercices.acceptance.api;

import com.steph0.java_concurrency_exercices.helpers.acceptance.AssertResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.nio.charset.StandardCharsets;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PingControllerTest {
  @LocalServerPort
  private int port;
  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void shouldReturnPing() throws Exception {
    ResponseEntity<String> resp = this.restTemplate.getForEntity("http://localhost:" + port + "/ping", String.class);
    AssertResponse.isSuccessfull(resp);
    AssertResponse.hasContentType(resp, new MediaType(MediaType.TEXT_PLAIN, StandardCharsets.UTF_8));
    Assertions.assertThat(resp.getBody()).isEqualTo("ping");
  }
}
