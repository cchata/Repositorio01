<%@ page import="java.util.*"%>
<%@ page import="entity.*"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
</head>
<body>

	<form name="formListado" action="listarSvr.html" method="post">
<!-- 	        <div><a href="GenerarExcelServlet.html">Excel</a></div> -->
				<div><a href="exportarExcelSvr.html">Excel</a></div>
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
