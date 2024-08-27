package org.ormfmi.transformars;

public class GenericClass<T> {

    private Class<T> genericClass;

    private GenericClass(Class<T> genericClass) {
        this.genericClass = genericClass;
    }

    public Class<T> getGenericClass() {
        return genericClass;
    }

    public static <U> GenericClass<U> createGenericClass() {
        // Infer the generic type from the Class object passed to the constructor
        return new GenericClass<>(null);
    }

}
