package org.example.proxy.dynamicproxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.proxy.annotation.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DynamicProxyInvocationHandler implements InvocationHandler {

    private static final Logger log = LogManager.getLogger(DynamicProxyInvocationHandler.class);

    private Object target;
    private final Map<String, Method> methods = new HashMap<>();

    public DynamicProxyInvocationHandler(Object target) {
        this.target = target;
        for(Method method: target.getClass().getDeclaredMethods()) {
            this.methods.put(method.getName(), method);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        Object result;
        Method originalMethod = methods.get(method.getName());
        if (originalMethod.isAnnotationPresent(Log.class)) {
            long startTime = System.nanoTime();
            log.info("Start - Class: {}, Method: {}", target.getClass().getName(), method.getName());

            result = originalMethod.invoke(target, args);

            long endTime = System.nanoTime() - startTime;
            log.info("Finish - Class: {}, Method: {}, time: {}", target.getClass().getName(), method.getName(), endTime);
        } else {
            result = originalMethod.invoke(target, args);
        }

        return result;
    }
}
