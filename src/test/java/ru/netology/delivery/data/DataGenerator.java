package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataGenerator {
    public DataGenerator() {
    }

    private static Faker faker = new Faker(new Locale("ru"));


    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }

    public static String generateCity(String locale) {
        String city = faker.address().city();
        return city;
    }

    public static String generateName(String locale) {
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = faker.phoneNumber().phoneNumber();
        return phone;


    }

    public static class Registration {
        private Registration() {
        }


        public static UserInfo generateUser(String locale) {
            val user = new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
            return user;
        }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }
}
