package org.example.framework.container;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassMethodComposition {
    public Class classReference;
    public Method methodReference;

    public Object classInstance;

    public ClassMethodComposition(Class classReference) {
        this.classReference = classReference;
    }

    public ClassMethodComposition(Class classReference, Method methodReference) {
        this.classReference = classReference;
        this.methodReference = methodReference;
    }

    public Object getInstance() {
        try {
            return this.classReference.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
