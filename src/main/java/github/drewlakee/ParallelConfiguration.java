package github.drewlakee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class ParallelConfiguration {

    private Environment env;

    @Autowired
    public ParallelConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public Executor workersExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors());
        executor.setQueueCapacity(env.getProperty("worker_executor_queue_capacity", Integer.class, 100));
        executor.setThreadNamePrefix("WorkerThread-");
        executor.initialize();
        return executor;
    }
}
