package com.steph0.java_concurrency_exercices.domain.models.atomicity;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicVisitCounter {

  private static AtomicVisitCounter counter;

  private AtomicLong count = new AtomicLong(0);

  private AtomicVisitCounter() {}

  public Long getCount() {
    return count.get();
  }

  /**
   * Thread-safe operation
   * 
   * @See Book section 2.2.3
   */
  public AtomicVisitCounter increment() {
    count.incrementAndGet();
    return this;
  }

  public AtomicVisitCounter reset() {
    count.set(0);
    return this;
  }

  /**
   * This singleton creation at least represents
   */
  public synchronized static AtomicVisitCounter getInstance() {
    if (counter == null) {
      counter = new AtomicVisitCounter();
    }
    return counter;
  }
}