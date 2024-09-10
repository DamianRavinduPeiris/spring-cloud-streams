package com.damian.scs;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
@Log4j2
public class ScsPublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScsPublisherApplication.class, args);
    }


//    @Bean
//    public Supplier<String> supplierBinding() {
//        log.info("Supplier Binding ::");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            log.warn("Thread Interrupted ::", e);
//        }
//        return () -> {
//            return "Hello World!";
//        };
//    }

    @Bean
    public Consumer<String> consumerBinding() {
        log.info("Consumer Binding ::");
        return s -> log.info("Consumer Event :: " + s);
    }

    @Bean
    public Function<String, String> producerBinding() {
        log.info("Producer Binding ::");
        return s -> {
            log.info("Producer Event :: " + s);
            return s.toUpperCase();
        };
    }

}
