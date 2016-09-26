<%@ page import="java.util.*"%>
<%@ page import="entity.*"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
<body>

	<form name="formBuscar" action="buscarSvr.html" method="post">
		<table class="formulario">
			<tr>
				<td>Buscar nombre:</td>
				<td><input type="text"   name="txtNombre" id="txtNombre" value="<%=request.getAttribute("txtNombreR")==null?"":request.getAttribute("txtNombreR")%>"></td>
				<td><input type="submit" name="btnBuscar" value="Buscar" class="button"></td>
			</tr>
		</table>
      <!-- 	Es para el excel. si el listado es vacio, no se debe poder generar excel.	 -->
		<%if(request.getAttribute("listaActor")!=null){%>
		        <div><a href="exportarExcelSvr.html">Excel</a></div>
		<%}%>
	  <!-- . -->
		<table class="table">
						   <tr>
								<th>ID</th>
								<th>NOMBRE</th>
								<th>EDAD</th>
						   </tr>
				   <%if(request.getAttribute("listaActor")!=null){
				        for(Actor a : (List<Actor>)request.getAttribute("listaActor")){%>
				           <tr><td><%=a.getId() %></td> <td><%=a.getNombre() %></td> <td><%=a.getEdad() %></td></tr>
				   <%}}%>
			</table>
	</form>

</body>
</html>