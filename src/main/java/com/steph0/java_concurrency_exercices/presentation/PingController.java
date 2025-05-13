package com.steph0.java_concurrency_exercices.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

  @GetMapping(value = "/ping", produces = { MediaType.TEXT_PLAIN_VALUE })
  @ResponseStatus(value = HttpStatus.OK)
  public String ping() {
    return "ping";
  }

}
