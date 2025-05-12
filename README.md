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
