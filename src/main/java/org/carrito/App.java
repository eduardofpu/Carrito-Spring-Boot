package org.carrito;


import org.carrito.utils.AppContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AppContext
 *
 */
@SpringBootApplication
public class App{
    public static void main( String[] args ){
    	SpringApplication.run(AppContext.class, args);
    }
}
