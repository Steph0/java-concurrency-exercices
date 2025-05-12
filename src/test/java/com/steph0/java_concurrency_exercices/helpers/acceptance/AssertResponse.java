package com.steph0.java_concurrency_exercices.helpers.acceptance;

import org.assertj.core.api.Assertions;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class AssertResponse {
  public static void isSuccessfull(ResponseEntity<?> resp) {
    Assertions.assertThat(resp.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
  }

  public static void hasContentType(ResponseEntity<?> resp, MediaType contentType) {
    Assertions.assertThat(resp.getHeaders().getContentType()).isEqualTo(contentType);
  }
}
