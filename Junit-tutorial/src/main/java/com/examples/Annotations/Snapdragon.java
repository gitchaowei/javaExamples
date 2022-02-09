package com.examples.Annotations;

import org.springframework.stereotype.Component;

@Component              // default name is "snapdragon"
//@Primary
public class Snapdragon implements MobileProcessor {

    @Override
    public void process() {
        System.out.println("SnapDragon is the best CPU");
    }
}
