package com.baeldung.setterdi;

import com.baeldung.setterdi.domain.Engine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baeldung.setterdi.domain.Car;

public class SpringRunner {
    private static Car fieldCar;
    private static Engine fieldEngine;

    static {
        fieldEngine = new Engine();

        fieldCar = new Car();
    }

    public static void main(String[] args) {
        Car car = new Car();

        Car car2;

        car2 = new Car();

        Car car3 = new Car();

        Engine engine = new Engine();
        String ceva2 = "ceva2";
        engine.setType(ceva2);

        System.out.println("ceva");

        car2.setEngine(null);

        car.setEngine(engine);

        fieldCar.setEngine(fieldEngine);

        Car toyota = getCarFromXml();

        System.out.println(toyota);

        toyota = getCarFromJavaConfig();

        System.out.println(toyota);

        System.out.println(car);

        System.out.println(car3);
    }

    private static Car getCarFromJavaConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        return context.getBean(Car.class);
    }

    private static Car getCarFromXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("setterdi.xml");

        return context.getBean(Car.class);
    }
}