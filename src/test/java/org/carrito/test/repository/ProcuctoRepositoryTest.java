package org.carrito.test.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.carrito.entity.Producto;
import org.carrito.entity.ProductoRepository;
import org.carrito.test.util.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ProcuctoRepositoryTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(ProcuctoRepositoryTest.class);
	@Autowired
	private ProductoRepository repository;
	
	
	
	/*
	
	@Test
	public void findAllTest() {//select * from  tb_produto;
		//Busca todos os produtos
		List<Producto> produtos = this.repository.findAll();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Test FindAll(): " + produtos);
		}
	}
	*/
	@Test
	public void findId(){//select * from  tb_produto where pk_id = idProduto;
		//Busca o produto pelo codigo
		Producto produtos =  this.repository.findById(2l);
		
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Test FindAll(): " + produtos);
		}
		
	}

}
