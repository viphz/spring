package com.profile.configProfile;

import com.profile.beanProfile.Dao2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class ProductionProfile {
    @Bean
    public Dao2 getDao(){
        return new Dao2();
    }
}
