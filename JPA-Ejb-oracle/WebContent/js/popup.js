$(document).ready(function(){

	var accion =0;
	
	    $('#nuevo').click(function(){
		    accion = 1;
			$('#nuevo-popup').fadeIn('slow');
			$('.popup-overlay').fadeIn('slow');
			$('.popup-overlay').height($(window).height());
			return false;
		});
	    
	    $('#update').click(function(){
		    accion = 2;
			$('#update-popup').fadeIn('slow');
			$('.popup-overlay').fadeIn('slow');
			$('.popup-overlay').height($(window).height());
			return false;
		});
	    
		
		$('.close').click(function(){
			if(accion==1){
				$('#nuevo-popup').fadeOut('slow');
			}
			if(accion==2){
				$('#update-popup').fadeOut('slow');
			}
			
			$('.popup-overlay').fadeOut('slow');
			return false;
		});
});


function pintarFilaFnc(valorAccion){//Esta funcion pinta la fila Nueva o Actualizada. En Actualizar es necesario obtener la posicion de row de la Tabla para
	                                //aplicar estilo a esa posicion particular.
	
			//	if(valorAccion=='NuevaFila'){
			//		$('#idtableactor').find('tr').eq(1).css({
			//			'background' : 'yellow',
			//			'color' : 'blue' 
			//			});
			//	}
			
				
				if(valorAccion=='NuevaFila'){
						tr1 = 	$('#idtable').find('tr').eq(1).css({
							'background' : '#ffff00',
							'color' : '#3c3cff' 
							}); 
						
					   $(tr1).hide(5000,"linear", function(){
						     tr1 = 	$('#idtable').find('tr').eq(1).removeAttr('style');
						   $(tr1).show(16000,"linear", function(){});   
						   
					   });
				  }
				
				if(valorAccion.split('-')[0]=='UpdateFila'){
						tr1 = 	$('#idtable').find('tr').eq(valorAccion.split('-')[1]).css({//Aqui se hace uso de split para sacar el valor de la posicion del row de la tabla.
							                                                                     //Este valor lo envia el ServletActor, quien lo recibe de crudActor.jsp de un Hidden
							                                                                     //(txtposicionrow) 
							'background' : '#ffbbff',
							'color' : '#3c3cff' 
							}); 
						
					   $(tr1).hide(5000,"linear", function(){
						     tr1 = 	$('#idtable').find('tr').eq(valorAccion.split('-')[1]).removeAttr('style'); //Remueve el estilo apliacdo antes.
						   $(tr1).show(16000,"linear", function(){});   
						   
					   });
			  }
}

