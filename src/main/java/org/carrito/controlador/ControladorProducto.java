package org.carrito.controlador;


import org.carrito.entity.Producto;
import org.carrito.modelo.ModeloProducto;


public class ControladorProducto {

	
	 public Producto getProducto(Long id){
	        return new ModeloProducto().getProducto(id);
	    }
}
