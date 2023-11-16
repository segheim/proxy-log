package org.example.proxy.customproxy;

import org.example.proxy.model.Person;

import java.lang.reflect.InvocationTargetException;

public class PersonProxy implements Person {

    private final Person person;
    private final CustomInvocationHandler handler;

    public PersonProxy(Person person, CustomInvocationHandler handler) {
        this.person = person;
        this.handler = handler;
    }

    @Override
    public void sayName(String name) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        handler.invoke(person, person.getClass().getName(), "sayName", new Object[] {name});
    }

    @Override
    public void sayAge(Integer age) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        handler.invoke(person, person.getClass().getName(), "sayAge", new Object[] {age});
    }

    @Override
    public void sayFrom(String city, String country) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        handler.invoke(person, person.getClass().getName(), "sayFrom", new Object[] {city, country});
    }
}
