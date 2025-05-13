package com.steph0.java_concurrency_exercices.application.atomicity.usecases;

import com.steph0.java_concurrency_exercices.domain.models.atomicity.FactorsResult;
import com.steph0.java_concurrency_exercices.domain.models.atomicity.NonAtomicVisitCounter;
import com.steph0.java_concurrency_exercices.domain.services.GenerateFactors;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class DemonstrateRaceConditionOnCounter {

  GenerateFactors generateFactors;

  public DemonstrateRaceConditionOnCounter(GenerateFactors generateFactors) {
    this.generateFactors = generateFactors;
  }

  public FactorsResult execute(BigInteger value) {

    NonAtomicVisitCounter numberOfVisits = NonAtomicVisitCounter.getInstance().increment();

    BigInteger[] factors = generateFactors.execute(value);
    return new FactorsResult(numberOfVisits.getCount(), value, factors);
  }

}
