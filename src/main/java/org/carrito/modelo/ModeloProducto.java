package org.carrito.modelo;

import java.io.Serializable;
import java.util.ArrayList;

import org.carrito.entity.Producto;
import org.carrito.entity.ProductoRepository;
import org.carrito.utils.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class ModeloProducto extends BaseEntity<Serializable>{
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProductoRepository repositorio;
	
	
   //Cria uma lista de produtos trazendo do banco de dados
	public ArrayList<Producto> getAllProductos(){
		
		 ArrayList<Producto> productos = new ArrayList<>();			 
		 productos.add((Producto) repositorio.findAll());
		
		return productos;
		 
		 
	 }
	
	
	 public Producto getProducto(Long id){
		 
		 Producto producto =  repositorio.findById(id);
		 
		return producto; 
		 
		 
	 }

}
