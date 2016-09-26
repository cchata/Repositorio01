<%@ page import="java.util.*"%>
<%@ page import="entity.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
<body>
<%
SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
%>
	<form name="formEliminar" action="eliminarPSvr.html" method="post" id="idFormEliminar">
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
								<th>ESTRENO</th>
								<th>ACTOR</th>
								<th>ACCION</th>
						   </tr>
				   <%if(request.getAttribute("listaPelicula")!=null){
				        for(Pelicula p : (List<Pelicula>)request.getAttribute("listaPelicula")){%>
				           <tr>
				              <td><%=p.getId() %></td>
				              <td><%=p.getNombre() %></td> 
				              <td><%=sdf.format(p.getEstreno()) %></td>
				              <td><%=p.getActor().getNombre() %></td>
				              <td><a href="#" onclick="eliminarPelicula('<%=p.getId()%>');">Eliminar</a></td>
				           </tr>
				   <%}}%>
			</table>
	</form>

</body>
</html>