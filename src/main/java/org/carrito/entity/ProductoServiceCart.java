package org.carrito.entity;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.carrito.utils.GenericService;
import org.carrito.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = ServicePath.CART_PATH)
public class ProductoServiceCart extends GenericService<Producto,Long>{
	
	@Autowired
	ProductoRepository repositorio;	
	
	//( Pega o codigo do produto   pela url ) ( /cart/ é o nome da pagina ) ( {produto} é o codigo do produto )
	@RequestMapping(value="/cart/{produto}", method = {RequestMethod.GET})
	public List<Producto> processar(@PathVariable("produto") Long produto,
			HttpServletRequest request, HttpServletResponse response)
	throws ServletException{			
		
		//int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		
		
		//Inicia a variavel sessão
		HttpSession session = request.getSession(true);		
		//Inicia a variavel carrinho de compras    	
    	List<Producto> carrinho = new ArrayList<>();
    	//A lista de carrinho de compras vira umas lista de sessão		   	    
    	carrinho=(List<Producto>) session.getAttribute("produto") == null ? new ArrayList<>() : (ArrayList) session.getAttribute("produto");    	 
	   
    	//Inicia a variavel de itens
	    Producto itens = new Producto();
	    
	    //Obtem os campos id, nome e preço do produto pelo id passado na URL atraves da variavel produto
	    itens=this.repositorio.findById(produto);//select * from  tb_produto where pk_id = idProduto;	
	    	    	
	    	 int qt=1;
	    	 double total = 0;	    	     
		     double math=0;
		     double subtotal=0;		     
		     double totalvalor=0;
		     
		       //Logica booleana necessaria para capturar a sessão de produtos no carrinho
			    boolean flag = false;  
			    
			    //Se a flag for false significa que o carrinho contem produtos e a quantidade ira almentar
	            
		        
		        if(carrinho.size() > 0 ){
		        	
		        	for(Producto i : carrinho){
		            	
		            		 if(produto == i.getId()){
		            			 
		 	                    i.setCantidad(i.getCantidad() + qt); 
		 	                    
		 	                    subtotal = i.getCantidad() * i.getPrecio();
		 	                    total = i.getCantidad() * i.getPrecio();		 	                    
		 	                    math = Math.round(total*100.0)/100.0; 		 	                  
		 	                
		 	                    i.setSub(subtotal);		 	                     
		 	                  
			 	                totalvalor += i.setTotal(math);
			 	                i.setTotalvalor(totalvalor);
			 	                System.out.println("carrinho size Total: " +totalvalor);
			        			 
			 	               qt++; 
			        			
	            				flag = true;
		 	                    //break;
			          }
		            		
		            		 
		            }//Fim do for	            
		                        
		        }//Fim do 1 if
		       
		       
			    //Caso contrario adiciona os itens no carrinho de compras
		        if(!flag){
		        	
		    		carrinho.add(itens);
		    		
		    		if(carrinho != null){
			        	
			        	for(Producto i : carrinho){
			        		
			        		       subtotal = i.getCantidad() * i.getPrecio();
			 	                   total = i.getCantidad() * i.getPrecio();			 	                   
			 	                   math = Math.round(total*100.0)/100.0; 
			 	                   
			 	                   totalvalor += i.setTotal(+math);
			 	                   		 	                   
			 	                //mostra o totalvalor na pagina cart.html
			 	                     i.setSub(subtotal);
			 	                    
				        			 i.setTotalvalor(totalvalor);
				        			 
				        			 System.out.println("Produto novo:  total: " +totalvalor);
			 	                  
			        		
			 	                }   			        		  
			                    
			                        
			        }
		        	
		        }//Fim do 1 if
		        
		        
		        
		        
		        //Imprime no console para analisar os produtos adicionados
  			    System.out.println("Produto adicionado: " +carrinho);
  			    
  			    if(carrinho==null){
  			    	
  			    	 System.out.println(" O Carrinho esta vazio !");
  			    }
  			    
  			    
  			    
  			  session.setAttribute("produto",carrinho);
  			  
  			  
	    
		//retorna todos os produtos adicionados no carrinho na pagina cart.html
		return carrinho;
		
	}
	
	

}
