

window.onload = function(){
	if(document.getElementById("txtNombre") != null){
		document.getElementById("txtNombre").focus();
	}
	
	if(document.getElementById('divformulario') != null){
		document.getElementById('divformulario').style.display = 'none';
	}
	
	document.getElementById("pintarFila").click();	//En actor.jsp hay un div(pintarFila) el cual se ejecuta una funcion(pintarFilaFnc) al hacer click.

};

function eliminarActor(id){
	var eliminar = confirm("¿Esta seguro de eliminar?");
	if(eliminar){
		document.formEliminar.method = "POST";
		document.formEliminar.action = "eliminarSvr.html?idactor="+id;
		document.formEliminar.submit();
	}else{
	}
}

function deleteActor(id){
	var eliminar = confirm("¿Esta seguro de eliminar?");
	if(eliminar){
		document.formCrud.method = "POST";
		document.formCrud.action = "crudActorSvr.html?idactor="+id+"&btnaccion=Delete";
		document.formCrud.submit();
	}else{
	}
}

function actualizarActor(id,nombre,edad){
	
	if(document.getElementById('divformulario') != null){
			document.getElementById('divformulario').style.display = 'block';
			document.getElementById("txtidactor").value=id;
			document.getElementById("txtnombreactor").value=nombre;
			document.getElementById("txtedadactor").value=edad;
	}
}

function updateActorr(id,nombre,edad,posicionRow){
	
			document.getElementById("txtidactor").value=id;
			document.getElementById("txtnombreactor").value=nombre;
			document.getElementById("txtedadactor").value=edad;
			document.getElementById("txtposicionrow").value=posicionRow;
			document.getElementById("update").click();
}

