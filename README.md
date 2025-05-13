# java-concurrency-exercices

A playground to practice exercices from the book [Java Concurrency in Practice](https://jcip.net/).
It uses [Spring Web](https://spring.io/guides/gs/spring-boot) to run.  

**IMPORTANT:** this repositories is NOT written for production, or as a display of best practices (TDD, naming, etc.)

## Run it

```sh
./mvnw spring-boot:run
```

You can verify that it is at least running and accessible with the `/ping` route

```sh
curl --location 'localhost:8080/ping' --header 'Accept: text/plain'
```

## Exercices

### Atomicity, lost updates, race condition

Summary:
How concurrent updates can result in lost updates due to race conditions.

Book references:
2.2.1

Demonstration:
* First API call resets a singleton non atomic counter of visits to zero
* We then make 100 API call, allowing parallism (-P0 = infinite)
* Due to a non atomic counter increments, some visits will be "lost" due to a race condition
* Last API call should be the 101th visit, but the visitNumber value will be a close but of an inferior value
  * If by any chance it does, re-do the test a few times (or try increasing the seq to 5000 or more)

```sh
curl -w "\n" -X DELETE --location 'localhost:8080/atomicity/counters/reset' \
&& seq 1 100 | xargs -P0 -I{} curl -w "\n" --location 'localhost:8080/atomicity/counter-race-condition/factors/{}' \
&& echo "Next call should return 101 for visit counter, but it will not" \
&&  curl -w "\n" --location 'localhost:8080/atomicity/counter-race-condition/factors/101'
```

* On the other end, the same example using `AtomicLong` will show how to solve a race condition

```sh
curl -w "\n" -X DELETE --location 'localhost:8080/atomicity/counters/reset' \
&& seq 1 100 | xargs -P0 -I{} curl -w "\n" --location 'localhost:8080/atomicity/counter-thread-safe/factors/{}' \
&& echo "Next call will return 101 for visit counter" \
&&  curl -w "\n" --location 'localhost:8080/atomicity/counter-thread-safe/factors/101'
```