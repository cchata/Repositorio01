<%@ page import="java.util.*"%>
<%@ page import="entity.*"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
<body>

	<form name="formActualizar" action="actualizarSvr.html" method="post" id="idFormActualizar">
		<table class="formulario">
			<tr>
				<td>Buscar nombre:</td>
				<td><input type="text"   name="txtNombre" id="txtNombre" value="<%=request.getAttribute("txtNombreR")==null?"":request.getAttribute("txtNombreR")%>"></td>
				<td><input type="submit" name="btnBuscar" value="Buscar" class="button"></td>
			</tr>
		</table>
		
		<table class="table">
						   <tr>
								<th>ID</th>
								<th>NOMBRE</th>
								<th>EDAD</th>
								<th>ACCION</th>
						   </tr>
				   <%if(request.getAttribute("listaActor")!=null){
				        for(Actor a : (List<Actor>)request.getAttribute("listaActor")){%>
				           <tr>
				              <td><%=a.getId() %></td>
				              <td><%=a.getNombre() %></td> 
				              <td><%=a.getEdad() %></td>
				              <td><a href="#" onclick="actualizarActor('<%=a.getId()%>','<%=a.getNombre()%>','<%=a.getEdad()%>');">Actualizar</a></td>
				           </tr>
				   <%}}%>
	    </table>
	    
	  <div id="divformulario">
	    <br/>
	    <table class="formulario">
		    <tr>
		       <td>Id</td>
		       <td><input type="text" name="txtidactor"     id="txtidactor"  readonly/></td>
		    </tr>
		    <tr>
		       <td>Nombre</td>
		       <td><input type="text" name="txtnombreactor" id="txtnombreactor" /></td>
		    </tr>
		    <tr>
		       <td>Edad</td>
		       <td><input type="text" name="txtedadactor"   id="txtedadactor"  /></td>
		    </tr>
		    <tr>
		       <td colspan="3" align="center"><input type="submit" name="btnActualizar" value="Actualizar" class="button"/></td>
		    </tr>
	    </table>
     </div>
	</form>

</body>
</html>