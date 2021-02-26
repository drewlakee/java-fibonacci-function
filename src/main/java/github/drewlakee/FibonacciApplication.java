package github.drewlakee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@SpringBootApplication
public class FibonacciApplication {

    public static void main(String[] args) {
        SpringApplication.run(FibonacciApplication.class, args);
    }

    @Async("workersExecutor")
    @GetMapping(path = "/compute/{value}", produces="application/json")
    public CompletableFuture<String> computeFibonacciValue(@PathVariable int value) {
        List<BigInteger> computeResult = new FibonacciValue(value).compute();
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(computeResult.get(0));
        if (computeResult.size() > 1) {
            for (int index = 1; index < computeResult.size(); index++) {
                responseBuilder.append(",").append(computeResult.get(index));
            }
        }
        return CompletableFuture.completedFuture(String.format("{\"result\":[%s]}", responseBuilder.toString()));
    }
}
