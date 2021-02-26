package github.drewlakee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@SpringBootApplication
public class FibonacciApplication {

    public static void main(String[] args) {
        SpringApplication.run(FibonacciApplication.class, args);
    }

    @GetMapping(path = "/compute/{value}")
    public void computeFibonacciValue(@PathVariable long value) {
        System.out.println("Client want's to compute " + value);
    }
}
