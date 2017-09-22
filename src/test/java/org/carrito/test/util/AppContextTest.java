package org.carrito.test.util;


import org.carrito.utils.AppContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { AppContext.class })
@ComponentScan(basePackages = { "org.carrito.test" })
public abstract class AppContextTest {

}
