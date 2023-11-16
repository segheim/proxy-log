package org.example.proxy.model;

import java.lang.reflect.InvocationTargetException;

public interface Person {

    void sayName(String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    void sayAge(Integer age) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;

    void sayFrom(String city, String country) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;

}
