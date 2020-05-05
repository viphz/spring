package com.profile.beanProfile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("development")
public class Dao1 {
    public Dao1(){
        System.out.println("development constructor");
    }
}
