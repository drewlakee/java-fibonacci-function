package github.drewlakee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@SpringBootApplication
public class FibonacciApplication {

    public static void main(String[] args) {
        SpringApplication.run(FibonacciApplication.class, args);
    }

    @Async("workersExecutor")
    @GetMapping(path = "/compute/{value}")
    public CompletableFuture<String> computeFibonacciValue(@PathVariable int value) {
     return CompletableFuture.completedFuture(new FibonacciValue(value).compute().toString());
    }
}
