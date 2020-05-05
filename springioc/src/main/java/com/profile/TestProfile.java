package com.profile;

import com.profile.configProfile.DevelopmentProfile;
import com.profile.configProfile.ProductionProfile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestProfile {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("production");
        annotationConfigApplicationContext.register(ProductionProfile.class, DevelopmentProfile.class);
        annotationConfigApplicationContext.refresh();
    }
}
