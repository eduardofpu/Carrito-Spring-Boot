'use strict';

angular.module('carrito')
  .controller('produto-detailsCtrl', function($scope, ngNotify, RestSrv,$location, SERVICE_PATH) {
	    
	    $scope.produto = {};
	    $scope.produtos = []; 
	    $scope.permissions = [];    
	   
	    //idProduto = produto-details/produto.id    ( ex:  produto-details/1 )
		var idProduto = $location.path();// Esta trazendo da url: ( produto-details/produto.id )   por isso foi dado o mesmo parametro no ProductoService ( produto-details )		
		
		//alert(idProduto);
			
	    // Chama o ProductoService em ( /produto-details/{produto} )
	     var UrlCod = SERVICE_PATH.PRIVATE_PATH  + '/lista'+idProduto; 	     
	     
	     
	     //Função executada dentro do template produto-detais.html    para mostrar o produto que foi escolhido dentro do  template loja.html
		 $scope.buscarCod = function(produto){	
	    	 RestSrv.findCod (UrlCod, function(data) {
	 	    	
	    		// alert(UrlCod);
			        $scope.produto = data;

			        ngNotify.set('Imagem escolhida.', 'success');
	        }); 	 
	    	
	    }//Fim buscarCod    
		 
		  //$scope.carrinho = new Array();
		  //Pega o nome da pagina ( produto-details e o id do produto ) na pagina loja.html ex:   produto-details/id   e leva para a pagina produto-details.html 
		    $scope.cartPage = function(produto){	
		    	$location.path('/cart/'+ produto);
		    	//$scope.carrinho.push(produto);		    	
		    	//alert($scope.carrinho);
			    
		  	   }//Fim idProduto
		    
		
		    
		    
	    
	    
	    // Request all data (permission and user).
	    var permissionUrl = SERVICE_PATH.PRIVATE_PATH + '/permission';
       
	    RestSrv.find(permissionUrl, function(data) {	    	
	    	
	      $scope.permissions = data;
	    });
	    
	    
		
	    
	    
	  
	    
  });
