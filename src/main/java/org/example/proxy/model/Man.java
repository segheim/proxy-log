package org.example.model;

public class Man implements Person{

    private final String name;
    private final int age;
    private final String city;

    public Man(String name, int age, String city, String country) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    private final String country;

    @Override
    public void sayName(String name) {
        System.out.println("Меня зовут " + this.name);
    }

    @Override
    public void sayAge(int age) {
        System.out.println("Мне " + this.age + " лет");
    }

    @Override
    public void sayFrom(String city, String country) {
        System.out.println("Я из города " + this.city + ", " + this.country);
    }
}
