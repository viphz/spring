package com.profile.beanProfile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("production")
public class Dao2 {
    public Dao2(){
        System.out.println("production constructor");
    }
}
