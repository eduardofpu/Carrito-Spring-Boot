'use strict';

angular.module('carrito')
  .controller('lojaCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH, $location ) {	    
	    //variaveis para ligar o backend com o frontend
	    $scope.produto = {};
	    $scope.produtos = []; 
	    $scope.permissions = [];
	    
	   //Busca todos os produtos  pela função em java na classe ProductoService
	    var Url = SERVICE_PATH.PRIVATE_PATH  + '/lista';
	    
	    RestSrv.find(Url, function(data) {	    	  
    	    
	        $scope.produtos = data;
	        ngNotify.set('Loja virtual.', 'success');
	        
	      });//Fim do find Url
	        

	    // Request all data (permission and user).
	    var permissionUrl = SERVICE_PATH.PRIVATE_PATH + '/permission';

	    RestSrv.find(permissionUrl, function(data) {
	      $scope.permissions = data;
	     
	    });//Fim find permission    
	    
	   
	  //Pega o nome da pagina ( produto-details e o id do produto ) na pagina loja.html ex:   produto-details/id   e leva para a pagina produto-details.html 
	    $scope.idProduto = function(produto){	
	    	$location.path('/produto-details/'+ produto);
	    	   			
	  	   }//Fim idProduto
	    
	  /*  
	    
	    /////////////////////////Chama o controle template ( produto-details/:produto )  com o mesmo controle do template acima  ( lojaCtrl )  /////////////////
		
		
		//var abUl = $location.absUrl();  //para pegar a url completa
		//var abUl = $location.path();    //para pegar a ultima parte da url
	    
	    
	    
	    //idProduto = produto-details/produto.id    ( ex:  produto-details/1 )
		var idProduto = $location.path();// Esta trazendo a url: ( produto-details/produto.id )   por isso foi dado o mesmo parametro no ProductoService ( produto-details )		
		
		//alert(idProduto);
			
	    // Chama o ProductoService em ( /produto-details/{produto} )
	     var UrlCod = SERVICE_PATH.PRIVATE_PATH  + '/lista/'+idProduto; 	     
	     
	     
	     //Função executada dentro do template produto-detais.html    para mostrar o produto que foi escolhido dentro do  template loja.html
		 $scope.buscarCod = function(produto){	
	    	 RestSrv.findCod (UrlCod, function(data) {
	 	    	
	    		// alert(UrlCod);
			        $scope.produto = data;

			        ngNotify.set('Imagem escolhida.', 'success');
	        }); 	 
	    	
	    }//Fim buscarCod 
		 
		 */
	   
  });
