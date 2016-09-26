

window.onload = function(){
	if(document.getElementById("txtNombre") != null){
		document.getElementById("txtNombre").focus();
	}
	
	if(document.getElementById('divformulario') != null){
		document.getElementById('divformulario').style.display = 'none';
	}
	
	document.getElementById("pintarFila").click();	//En actor.jsp hay un div(pintarFila) el cual se ejecuta una funcion(pintarFilaFnc) al hacer click.
};

function deletePelicula(id){
		var eliminar = confirm("¿Esta seguro de eliminar?");
		if(eliminar){
			
			document.formCrud.method = "POST";
			document.formCrud.action = "crudPelucilaSvr.html?idpelicula="+id+"&btnaccion=Delete";
			document.formCrud.submit();
			
		}else{
		}
	}


function eliminarPelicula(id){
	var eliminar = confirm("¿Esta seguro de eliminar?");
	if(eliminar){
		document.formEliminar.method = "POST";
		document.formEliminar.action = "eliminarPSvr.html?idpelicula="+id;
		document.formEliminar.submit();
	}else{
	}
}




function actualizarPelicula(id,nombre,estreno,idactor){
	if(document.getElementById('divformulario') != null){
		document.getElementById('divformulario').style.display = 'block';
		document.getElementById("txtidpelicula").value=id;
		document.getElementById("txtnombrepelicula").value=nombre;
		document.getElementById("dateestreno").value=estreno;
		document.getElementById("selectActor").value=idactor;
	}

  }

function updatePeliculaa(id,nombre,estreno,idactor,posicionRow){
	document.getElementById("txtidpelicula").value=id;
	document.getElementById("txtnombrepelicula").value=nombre;
	document.getElementById("dateestreno").value=estreno;
	document.getElementById("selectActor").value=idactor;
	document.getElementById("txtposicionrow").value=posicionRow;
	document.getElementById("update").click();
}


