var enEdicion = false;
function editarAccion(){
//	editar.innerHTML = "En edicion";
//	editar.style.color='black';
//	editar.style.fontStyle='italic';
//	alert(this.textContent);
	
	if(enEdicion == true){
		alert('Solo se puede editar una linea. Recargue la pagina para poder editar otra');
	}
	
	if(enEdicion==false){
		enEdicion=true;
	
		this.innerHTML = "En edicion";
		this.style.color='black';
		this.style.fontStyle='italic';
		
		
		var nodoTr = this.parentNode; //Nodo TR
		var arrayTd =  nodoTr.getElementsByTagName('td');
		
		var alimento      = arrayTd[0].textContent;
		var calorias      = arrayTd[1].textContent;
		var grasas        = arrayTd[2].textContent; 
		var proteina      = arrayTd[3].textContent;
		var carbohidratos = arrayTd[4].textContent; 
//		var opciones      = arrayTd[5].textContent;
		
		arrayTd[0].innerHTML = '<td><input type="text" name="alimento"      id="alimento"      value="'+alimento+'"      size="10"></td>';
		arrayTd[1].innerHTML = '<td><input type="text" name="calorias"      id="calorias"      value="'+calorias+'"      size="5"></td>';
		arrayTd[2].innerHTML = '<td><input type="text" name="grasas"        id="grasas"        value="'+grasas+'"        size="5"></td>';
		arrayTd[3].innerHTML = '<td><input type="text" name="proteina"      id="proteina"      value="'+proteina+'"      size="5"></td>';
		arrayTd[4].innerHTML = '<td><input type="text" name="carbohidratos" id="carbohidratos" value="'+carbohidratos+'" size="5"></td>';
	//	arrayTd[5].innerHTML = '';
		document.getElementById('alimento').focus();
	    contenedorForm1 = document.getElementById('contenedorForm');
		
//		contenedorForm1.innerHTML = 'Pulse Aceptar para guardar los cambios o cancelar para anularlos'+
//		'<form name = "formulario" action="" method="get" onsubmit="capturarEnvio()" onreset="anular()">'+
//		'<input class="boton" type = "submit" value="Aceptar"> <input class="boton" type="reset" value="Cancelar">';

		
		contenedorForm1.innerHTML = 'Pulse Aceptar para guardar los cambios o cancelar para anularlos'+
//		'<form name = "formulario"  action="ejercicio04-target.jsp" method="get" id ="idformulario" onsubmit="onsubmit1()" onreset="anular()">'+
//		'<input type="hidden" name="halimento"        id="idhalimento"      value="'+document.querySelector('#alimento').value+'">'+
//		'<input type="hidden" name="hcalorias"        id="idhcalorias"      value="'+document.querySelector('#calorias').value+'">'+
//		'<input type="hidden" name="hgrasas"          id="idhgrasas"        value="'+document.querySelector('#grasas').value+'">'+
//		'<input type="hidden" name="hproteina"        id="idhproteina"      value="'+document.querySelector('#proteina').value+'">'+
//		'<input type="hidden" name="hcarbohidratos"   id="idhcarbohidratos" value="'+document.querySelector('#carbohidratos').value+'">'+
		'<input class="boton" type ="button" onclick="capturarEnvio()" value="Aceptar"> '+
		'<input class="boton" type ="reset"  value="Cancelar">'+
		'</form>';
		
		
	}
}

function capturarEnvio(){
//	alert(document.getElementById('alimento').value);
//	alert(document.querySelector('#alimento').value);
	
	contenedorForm1.innerHTML = 'Pulse Aceptar para guardar los cambios o cancelar para anularlos'+
	'<form name = "formulario"  action="ejercicio04-target.jsp" method="get" id ="idformulario" onreset="anular()">'+
	'<input type="hidden" name="halimento"        id="idhalimento"      value="'+document.querySelector('#alimento').value+'">'+
	'<input type="hidden" name="hcalorias"        id="idhcalorias"      value="'+document.querySelector('#calorias').value+'">'+
	'<input type="hidden" name="hgrasas"          id="idhgrasas"        value="'+document.querySelector('#grasas').value+'">'+
	'<input type="hidden" name="hproteina"        id="idhproteina"      value="'+document.querySelector('#proteina').value+'">'+
	'<input type="hidden" name="hcarbohidratos"   id="idhcarbohidratos" value="'+document.querySelector('#carbohidratos').value+'">'+
	'<input class="boton" type ="submit" value="Aceptar"> '+
	'<input class="boton" type ="reset"  value="Cancelar">'+
	'</form>';
	
	
	document.getElementById('idformulario').submit();

	
}

function anular(){
	window.location.reload();
}



window.onload = function(){
//	editar = document.getElementById("editar01");
//	editar.onclick=editarAccion;
	
	nodoTr = document.getElementsByTagName('tr');
	for(var i=1;i<nodoTr.length;i++){
//		console.log(nodoTr.length);
		nodoEnTr = nodoTr[i].getElementsByTagName('td');
		nodoEnTr[5].onclick=editarAccion;
	}
	
	
};
	