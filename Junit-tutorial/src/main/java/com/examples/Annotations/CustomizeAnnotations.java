package com.examples.Annotations;

import java.lang.annotation.*;

@Inherited  // for the @SmartPhone annotation to be used for extended classes
@Documented
@Target(ElementType.TYPE)  // class type to be used or  CONSTRUCTOR or FIELD
@Retention(RetentionPolicy.RUNTIME) // when to be used, SOURCE or CLASS
@interface SmartPhone {
    String os() default "Symbian";
    int version() default 1;
}


@SmartPhone(os="Android", version=6)
class NokiaSeries {
    private String model;
    int size;

    public NokiaSeries(String model, int size) {
        this.model = model;
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

//class NASeries extends NokiaSeries { }, then use @Inherited

public class CustomizeAnnotations {

    public static void main(String[] args) {
        NokiaSeries obj = new NokiaSeries("Fire", 5);
        Class c = obj.getClass();
        Annotation ann = c.getAnnotation(SmartPhone.class);
        SmartPhone s = (SmartPhone) ann;
        System.out.println(s.os());
    }
}
