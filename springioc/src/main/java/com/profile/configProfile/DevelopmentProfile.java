package com.profile.configProfile;

import com.profile.beanProfile.Dao1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class DevelopmentProfile {
    @Bean
    public Dao1 getDao(){
        return new Dao1();
    }
}
