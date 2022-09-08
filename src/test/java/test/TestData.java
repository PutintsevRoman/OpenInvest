package test;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("ru"));

    public String getName() {
        return faker.name().firstName();
    }

    public String getTelNum() {
        return faker.phoneNumber().phoneNumber();
    }
}
