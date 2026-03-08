package com.capg.lpu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.capg.lpu")
@Configuration //Its an indicator for the spring container that it is a configuration task
public class MyConfig {

}
//it is a replacement for Config.xml file
