package com.springaop1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.springaop1")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringAopConfig {
}
