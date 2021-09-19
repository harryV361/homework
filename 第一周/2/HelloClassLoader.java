package com.lee.jvm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author lizhe
 */
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {

        try {
            final Class<?> hello = new HelloClassLoader().findClass("Hello");
            if (hello != null) {
                final Object o = hello.newInstance();
                final Method[] declaredMethods = hello.getDeclaredMethods();
                for (Method declaredMethod : declaredMethods) {
                    declaredMethod.invoke(o);
                }

            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {


        try {
            final byte[] bytes = Files.readAllBytes(Paths.get("/Users/harry/Documents/Hello.xlass"));
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
