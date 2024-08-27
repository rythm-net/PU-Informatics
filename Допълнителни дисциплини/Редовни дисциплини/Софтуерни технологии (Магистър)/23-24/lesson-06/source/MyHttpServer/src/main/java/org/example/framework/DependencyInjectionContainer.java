package org.example.framework;

import org.example.framework.container.ClassMethodComposition;
import org.example.framework.server.contracts.HttpRequestObject;
import org.example.framework.tags.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DependencyInjectionContainer {

    private static HashMap<String, ClassMethodComposition> controllerTable = new HashMap<>();
    private static HashMap<String, ClassMethodComposition> serviceTable = new HashMap<>();

    private static HashMap<String, ClassMethodComposition> entityTable = new HashMap<>();

    public static void addComponent(Class classReference) {

        if(classReference.isAnnotationPresent(HttpController.class)) {
            processController(classReference);
        }

        if(classReference.isAnnotationPresent(Service.class)) {
            processService(classReference);
        }

        if(classReference.isAnnotationPresent(CustomEntity.class)) {
            processEntity(classReference);
        }
    }

    public static ClassMethodComposition getComponent(String componentId) {

        if(controllerTable.containsKey(componentId)) {
            return controllerTable.get(componentId);
        }

        if(serviceTable.containsKey(componentId)) {
            return serviceTable.get(componentId);
        }

        if(entityTable.containsKey(componentId)) {
            return entityTable.get(componentId);
        }

        return null;
    }

    public static Collection<ClassMethodComposition> getAllEntity() {
        return entityTable.values();
    }

    private static void processController(Class classReference) {

        Method[] instanceMethodCollection = classReference.getMethods();

        for(Method instanceMethod : instanceMethodCollection) {

            int modificatorCode     =  instanceMethod.getModifiers();
            boolean isPublic        = Modifier.isPublic(modificatorCode);
            boolean hasAnnotation   = instanceMethod.isAnnotationPresent(
                    HttpMethod.class
            );

            boolean isMethodProcessable = isPublic && hasAnnotation;
            if(!isMethodProcessable) continue;

            HttpMethod httpMethodAnnotation = instanceMethod.getAnnotation(
                    HttpMethod.class
            );

            String httpMethod           = httpMethodAnnotation.method();
            String httpPath             = httpMethodAnnotation.path();
            String dependencyId         = httpMethod + ":" + httpPath;

            controllerTable.put(dependencyId, new ClassMethodComposition(classReference, instanceMethod));
        }
    }


    private static void processService(Class classReference) {
        serviceTable.put(classReference.getName(), new ClassMethodComposition(classReference));
    }

    private static void processEntity(Class classReference) {
        entityTable.put(classReference.getName(), new ClassMethodComposition(classReference));
    }

    public static Object createInstanceOf(ClassMethodComposition classComposition) {

        try {

            var constructorControllerCollection = classComposition.classReference.getConstructors();
            ArrayList<Object> serviceInstanceCollection = new ArrayList<>();

            Class[] serviceClassCollection = null;

            for(Constructor element : constructorControllerCollection) {
                var constructorParameterTypeCollection  = element.getGenericParameterTypes();
                serviceClassCollection                  = element.getParameterTypes();

                for(Type parameterType : constructorParameterTypeCollection) {

                    String parameterName                        = parameterType.getTypeName();
                    ClassMethodComposition serviceReference     = getComponent(parameterName);
                    serviceInstanceCollection.add(serviceReference.getInstance());
                }
            }

            return classComposition.classReference.getDeclaredConstructor(
                    serviceClassCollection
            ).newInstance(
                    serviceInstanceCollection.toArray()
            );

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean isParameterAnnotationPresent(ClassMethodComposition classComposition, Class annotation) {

        var instance = createInstanceOf(classComposition);

        try {
            Annotation[][] parameterAnnotationCollection =
                    classComposition.methodReference.getParameterAnnotations();

            // Ако имаш една единствена анотация, която да кореспондира с параметъра
            if(parameterAnnotationCollection.length == 1) {
                if(parameterAnnotationCollection[0].length == 1) {
                    if(parameterAnnotationCollection[0][0].annotationType().getName().equals(annotation.getName())) {
                        return true;
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Object invoke(ClassMethodComposition classComposition, Object... args) {

        try {
            var instance = createInstanceOf(classComposition);
            return classComposition.methodReference.invoke(instance);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
