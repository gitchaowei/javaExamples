package com.examples.Annotations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MediaTek implements MobileProcessor {
    @Override
    public void process() {
        System.out.println("MediaTek is the 2nd best CPU");
    }
}
