package com.baeldung.setterdi;

import com.baeldung.setterdi.domain.Car2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = Config.class)
@RunWith(SpringRunner.class)
public class TestConfig {

    @Autowired
    private Car2 car2;

    @Test
    public void test() {
        System.out.println(car2);
    }
}
