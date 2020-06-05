package com.baeldung.setterdi.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
public class Car2 {
    private Engine engine;
    private Transmission transmission;
    private Trailer trailer;
    private String something;

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Autowired
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Autowired
    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    @Autowired
    public void setSomething(@Value("ceva") String something) {
        this.something = something;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car2.class.getSimpleName() + "[", "]")
                .add("engine=" + engine)
                .add("transmission=" + transmission)
                .add("trailer=" + trailer)
                .add("something='" + something + "'")
                .toString();
    }
}
