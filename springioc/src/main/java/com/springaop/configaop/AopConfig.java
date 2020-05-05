package com.springaop.configaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.springaop")
@EnableAspectJAutoProxy
public class AopConfig {
}
