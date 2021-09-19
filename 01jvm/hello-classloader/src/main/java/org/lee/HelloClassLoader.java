package org.lee;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name + ".xlass");

        try {
            int length = inputStream.available();
            byte[] bytes = new byte[length];
            inputStream.read(bytes);
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
