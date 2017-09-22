package org.carrito.entity;

import org.carrito.utils.GenericService;
import org.carrito.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = ServicePath.LISTAR_PATH)
public class ProductoService extends GenericService<Producto, Long>{
	
	@Autowired
	ProductoRepository repositorio;
	
	
	//Pega o codigo do produto   pela url           produto-details é o nome da pagina  {produto} é o codigo do produto	
	@RequestMapping(value="/produto-details/{produto}", method = {RequestMethod.GET})
	public Producto processar(@PathVariable("produto") Long produto){
		
		//select * from  tb_produto where pk_id = idProduto;
		//System.out.println("Produtos  " + this.repositorio.findById(produto));
		
		return this.repositorio.findById(produto);
		
	}
	
}
