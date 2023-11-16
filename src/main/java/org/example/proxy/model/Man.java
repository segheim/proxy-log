package org.example.proxy.model;

import org.example.proxy.annotation.Log;

public class Man implements Person{

    private final String name;
    private final Integer age;
    private final String city;

    public Man(String name, Integer age, String city, String country) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    private final String country;

    @Log
    @Override
    public void sayName(String name) {
        System.out.println("Меня зовут " + this.name);
    }

    @Log
    @Override
    public void sayAge(Integer age) {
        System.out.println("Мне " + this.age + " лет");
    }

    @Override
    public void sayFrom(String city, String country) {
        System.out.println("Я из города " + this.city + ", " + this.country);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
