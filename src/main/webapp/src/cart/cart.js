'use strict';

angular.module('carrito')
  .controller('cartCtrl', function($scope, ngNotify,  RestSrv, $location,  SERVICE_PATH ) {
	      	
	    $scope.produto = {};
	    $scope.produtos = []; 
	    $scope.permissions = [];    
	   
	    
	    var cart = $location.path();
     	//alert(cart);		
			
	    // Chama o ProductoService em ( /cart/{produto} )
	     var Url = SERVICE_PATH.PRIVATE_PATH  + '/carrrito'+cart; 	
	     
	     
	     
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
	     //Função executada dentro do template produto-detais.html    para mostrar o produto que foi escolhido dentro do  template loja.html
		 $scope.buscarCart = function(produto){	
	    	 RestSrv.findCod (Url, function(data) {
	    		 $scope.total =0;	  
	    		 if(data!==null){
	    			 
	    			 for(var i=0;i<data;i++){
	    				 $scope.total +=$scope.produto.cantidad * $scope.produto.precio;
	    				 $scope.produto = data;
	    			 }
	    			 
	    			   		
				       
				        ngNotify.set('Carrinho de compras.', 'success');
	    		 }else{
	    			 
	    			 ngNotify.set('Carrinho vazio.', 'success'); 
	    		 }
	    		   
	        }); 	 
	    	
	    }//Fim buscarCod 
		 
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
		 
		 $scope.addcarrinho = function(produto){
			 RestSrv.addCarrito(Url, function(data){
				 $scope.produtos = data;
				
				 
				 ngNotify.set('Produto Adicionado no carrinho de compras.', 'success');
				 
			 });
			 
		 };
		 
		
		 RestSrv.find (Url, function(data) {
    			 
    			 $scope.produtos = data; 		
			       
		         ngNotify.set('Adicionar cart.', 'success');
     }); 	
	 
	    
	    // Request all data (permission and user).
	    var permissionUrl = SERVICE_PATH.PRIVATE_PATH + '/permission';
       
	    RestSrv.find(permissionUrl, function(data) {	    	
	    	
	      $scope.permissions = data;
	    });
	    
  });
