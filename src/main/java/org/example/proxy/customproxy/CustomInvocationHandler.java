package org.example.proxy.customproxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.proxy.annotation.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CustomInvocationHandler {

    private static final Logger log = LogManager.getLogger(CustomInvocationHandler.class);

    public Object invoke(Object object, String className, String methodName, Object[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object result;
        Method declaredMethod = object.getClass().getDeclaredMethod(methodName, Arrays.stream(args).map(Object::getClass).toArray(Class[]::new));
        if (declaredMethod.isAnnotationPresent(Log.class)) {
            long startTime = System.nanoTime();
            log.info("Start - Class: {}, Method: {}", className, methodName);

            result = declaredMethod.invoke(object, args);

            long endTime = System.nanoTime() - startTime;
            log.info("Finish - Class: {}, Method: {}, time: {}", className, methodName, endTime);
        } else {
            result = declaredMethod.invoke(object, args);
        }
        return result;
    }
}
