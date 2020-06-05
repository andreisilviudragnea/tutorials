package com.baeldung.setterdi;

import com.baeldung.setterdi.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.baeldung.setterdi")
public class Config {

    @Bean
    public Engine engine() {
        Engine engine = new Engine();
        engine.setType("v8");
        engine.setVolume(5);
        return engine;
    }

    @Bean
    public Transmission transmission() {
        Transmission transmission = new Transmission();
        transmission.setType("sliding");
        return transmission;
    }

    @Bean
    public Trailer trailer() {
        Trailer trailer = new Trailer();
        return trailer;
    }

    @Bean
    public Car2 car2() {
        return new Car2();
    }

    @Bean
    public Derived derived() {
        return new Derived();
    }
}