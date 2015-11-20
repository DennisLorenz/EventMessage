package se.animatedgames;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Dennis Lorenz
 */

@SpringBootApplication
@EnableRabbit
public class    CasinoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CasinoApplication.class, args);
    }
}
