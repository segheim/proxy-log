package org.example.proxy;

import org.example.proxy.customproxy.CustomInvocationHandler;
import org.example.proxy.customproxy.PersonProxy;
import org.example.proxy.dynamicproxy.DynamicProxyInvocationHandler;
import org.example.proxy.model.Man;
import org.example.proxy.model.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        int age = 25;
        String name = "Bob";
        String city = "Berlin";
        String country = "Germany";
        Man man = new Man(name, age, city, country);
//        DynamicProxyInvocationHandler handler = new DynamicProxyInvocationHandler(man);
//        Person proxyPerson = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
//        proxyPerson.sayName(man.getName());
//        proxyPerson.sayAge(man.getAge());
//        proxyPerson.sayFrom(man.getCity(), man.getCountry());

        PersonProxy personProxy = new PersonProxy(man, new CustomInvocationHandler());
        personProxy.sayName(name);
        personProxy.sayAge(age);
        personProxy.sayFrom(city, country);
    }
}