package com.springaop2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.springaop2")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringAopConfig {
}
