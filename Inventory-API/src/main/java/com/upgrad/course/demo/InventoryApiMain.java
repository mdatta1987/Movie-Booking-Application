package com.upgrad.course.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Inventory Api to handle stocks
 *
 */
@SpringBootApplication
public class InventoryApiMain
{
    public static void main( String[] args )
    {
        SpringApplication.run(InventoryApiMain.class, args);
    }
}
