package se.animatedgames;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Dennis Lorenz
 */

@SpringBootApplication
public class WalletApplication extends WebMvcConfigurerAdapter {

    final static String queueName = "spring-boot";

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WalletApplication.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }
}
