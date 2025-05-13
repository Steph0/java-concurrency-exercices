package com.steph0.java_concurrency_exercices.presentation.atomicity;

import com.steph0.java_concurrency_exercices.application.atomicity.usecases.DemonstrateRaceConditionOnCounter;
import com.steph0.java_concurrency_exercices.application.atomicity.usecases.DemonstrateThreadSafeCounter;
import com.steph0.java_concurrency_exercices.domain.models.atomicity.AtomicVisitCounter;
import com.steph0.java_concurrency_exercices.domain.models.atomicity.FactorsResult;
import com.steph0.java_concurrency_exercices.domain.models.atomicity.NonAtomicVisitCounter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class FactorsController {

  DemonstrateRaceConditionOnCounter demonstrateRaceConditionOnCounter;
  DemonstrateThreadSafeCounter demonstrateThreadSafeCounter;

  public FactorsController(DemonstrateRaceConditionOnCounter demonstrateRaceConditionOnCounter, DemonstrateThreadSafeCounter demonstrateThreadSafeCounter) {
    this.demonstrateRaceConditionOnCounter = demonstrateRaceConditionOnCounter;
    this.demonstrateThreadSafeCounter = demonstrateThreadSafeCounter;
  }

  @DeleteMapping(value = "/atomicity/counters/reset")
  @ResponseStatus(value = HttpStatus.OK)
  public void resetNumberOfVisitsCounter() {
    NonAtomicVisitCounter.getInstance().reset();
    AtomicVisitCounter.getInstance().reset();
  }

  @GetMapping(value = "/atomicity/counter-race-condition/factors/{value}", produces = { MediaType.APPLICATION_JSON_VALUE })
  @ResponseStatus(value = HttpStatus.ACCEPTED)
  public FactorsResult raceConditionOnCounterDemonstration(@PathVariable(name = "value") BigInteger value) {
    return demonstrateRaceConditionOnCounter.execute(value);
  }
  @GetMapping(value = "/atomicity/counter-thread-safe/factors/{value}", produces = { MediaType.APPLICATION_JSON_VALUE })
  @ResponseStatus(value = HttpStatus.ACCEPTED)
  public FactorsResult threadSafeCounterDemonstration(@PathVariable(name = "value") BigInteger value) {
    return demonstrateThreadSafeCounter.execute(value);
  }

}
