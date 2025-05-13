package com.steph0.java_concurrency_exercices.domain.models.atomicity;

public class NonAtomicVisitCounter {

  private static NonAtomicVisitCounter counter;

  // This counter is suceptible to lost updates if not incremented correctly
  private Long count = 0L;

  private NonAtomicVisitCounter() {}

  public Long getCount() {
    return count;
  }

  /**
   * Increment on number of visits is not atomic (read-modify-write)
   * 
   * @See Book section 2.2.1
   */
  public NonAtomicVisitCounter increment() {
    ++count;
    return this;
  }

  public NonAtomicVisitCounter reset() {
    count = 0L;
    return this;
  }

  /**
   * This singleton creation at least represents
   */
  public synchronized static NonAtomicVisitCounter getInstance() {
    if (counter == null) {
      counter = new NonAtomicVisitCounter();
    }
    return counter;
  }
}