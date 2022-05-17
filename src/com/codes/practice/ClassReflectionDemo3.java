package com.codes.practice;

public class ClassReflectionDemo3 {

    public static void main(String[] args) {

    }


}

class Bird extends AnimalClass {
    private boolean walks;

    public Bird() {
        super("bird");
    }

    public Bird(String name, boolean walks) {
        super(name);
        setWalks(walks);
    }

    public Bird(String name) {
        super(name);
    }



//    public boolean walks() {
//        return walks;
//    }

    public boolean isWalks() {
        return walks;
    }

    public void setWalks(boolean walks) {
        this.walks = walks;
    }

    @Override
    public String eats() {
        return null;
    }

    @Override
    protected String getSound() {
        return null;
    }
}
