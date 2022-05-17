package com.codes.practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassReflectionDemo2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //Test1();
        Test2();

    }

    //@Test
    private static void Test1() {
        Object person = new PersonClass();
        Field[] fields = person.getClass().getDeclaredFields();

        List<String> actualFieldNames = getFieldNames(fields);

        for (String s: actualFieldNames) {
            System.out.println("PersonClass field: " + s);
        }
    }

    private static void Test2() throws ClassNotFoundException {
        Object goat = new Goat("goat");
        Class<?> goatClass1 = goat.getClass();
        Class<?> goatClass2 = Class.forName("com.Interview.Goat");
        Class<?> animalClass = Class.forName("com.Interview.AnimalClass");

        // class name
        System.out.println("getSimpleName(): " + goatClass1.getSimpleName());
        System.out.println("getSimpleName(): " + goatClass2.getSimpleName());
        System.out.println("getName(): " + goatClass1.getName());
        System.out.println("getName(): " + goatClass2.getName());
        System.out.println("getCanonicalName(): " + goatClass1.getCanonicalName());
        System.out.println("getCanonicalName(): " + goatClass2.getCanonicalName());

        int goatMods = goatClass2.getModifiers();
        int animalMods = animalClass.getModifiers();

        // class modifier
        System.out.println("isPublic(): " + goatMods + " " + Modifier.isPublic(goatMods));
        System.out.println("isAbstract(): " + animalMods + " " + Modifier.isAbstract(animalMods));
        System.out.println("isPublic(): " + animalMods + " " +  Modifier.isPublic(animalMods));

        //package
        Package pkg = goatClass1.getPackage();
        System.out.println(goatClass1.getName() + " Class Package is : " + pkg.getName());

        // superclass
        Class<?> goatSuperClass = goatClass1.getSuperclass();
        System.out.println(goatClass1.getName() + " SuperClass is : " + goatSuperClass.getSimpleName());
        System.out.println("Any string superclass is: ".getClass().getSuperclass().getSimpleName());

        // interface
        Class<?>[] goatInterfaces = goatClass1.getInterfaces();
        Class<?>[] animalInterfaces = animalClass.getInterfaces();

        System.out.println("Ant string superclass is: ".getClass().getSuperclass().getSimpleName());
        System.out.println("Goat interfaces: " + goatInterfaces.length + "(0: "+ goatInterfaces[0].getSimpleName() +")");
        System.out.println("AnimalClass interfaces: " + animalInterfaces.length + "(0: "+ animalInterfaces[0].getSimpleName() +")");

        // Constructors
        Constructor<?>[] constructors = goatClass1.getConstructors();

        //constructors.length);
        //constructors[0].getName());

        // fields
        Field[] fields = animalClass.getDeclaredFields();
        List<String> actualFields = getFieldNames(fields);

       // actualFields.size()
       // actualFields.containsAll(Arrays.asList("name", "CATEGORY"))

        // methods
        Method[] methods = animalClass.getDeclaredMethods();
        List<String> actualMethods = getMethodNames(methods);

        // actualMethods.size());
        // actualMethods.containsAll(Arrays.asList("getName", "setName", "getSound"))
    }

    private static List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }
    private static List<String> getMethodNames(Method[] methods) {
        List<String> methodNames = new ArrayList<>();
        for (Method method : methods)
            methodNames.add(method.getName());
        return methodNames;
    }
}
class PersonClass {
    private String name;
    private int age;
}


interface Eating {
    String eats();
}
interface Locomotion {
    String getLocomotion();
}
abstract class AnimalClass implements Eating {

    public static String CATEGORY = "domestic";
    private String name;

    public AnimalClass(String name) {
        this.name = name;
    }

    protected abstract String getSound();

    // constructor, standard getters and setters omitted
}

class Goat extends AnimalClass implements Locomotion {

    public Goat(String name) {
        super(name);
    }

    @Override
    protected String getSound() {
        return "bleat";
    }

    @Override
    public String getLocomotion() {
        return "walks";
    }

    @Override
    public String eats() {
        return "grass";
    }
}