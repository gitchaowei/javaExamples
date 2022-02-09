package com.examples.Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component              // default name is "samsung"
public class Samsung {

    //
    // object is Autowired
    @Autowired  // autowired by class type
    MobileProcessor cpu;

    public MobileProcessor getCpu() {
        return cpu;
    }

    public void setCpu(MobileProcessor cpu) {
        this.cpu = cpu;
    }

    public void phoneConfig() {
        System.out.println("Octa Core, 4 gb ram, 12mp camera");
        cpu.process();
    }
}
