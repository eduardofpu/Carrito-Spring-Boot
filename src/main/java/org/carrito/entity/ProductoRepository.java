package org.carrito.entity;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<Producto,Long>{
	
	//Busca o produto pelo codigo
	public Producto findById(Long id); //select * from  tb_produto where pk_id = idProduto;
	
	public List<Producto> findByIdAndNombre(Long id, String nombre);

}
