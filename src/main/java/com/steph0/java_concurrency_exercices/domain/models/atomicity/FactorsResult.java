package com.steph0.java_concurrency_exercices.domain.models.atomicity;

import java.math.BigInteger;
import java.util.Objects;

public record FactorsResult(Long numberOfVisitCounter, BigInteger value, BigInteger[] factors) {
  public FactorsResult {
    Objects.requireNonNull(numberOfVisitCounter);
    Objects.requireNonNull(value);
    Objects.requireNonNull(factors);
  }
}
