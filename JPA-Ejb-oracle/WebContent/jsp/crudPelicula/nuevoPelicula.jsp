<%@ page import="java.util.*"%>
<%@ page import="entity.*"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
</head>
<body>

	<form name="formNuevo" action="insertarPSvr.html" method="post">
		<table class="formulario">
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="txtNombre" id="txtNombre"></td>
			</tr>

            <tr>
				<td>Estreno:</td>
				<td><input type="date" name="dateEstreno"></td>
			</tr>

            <tr>
               <td>Actor:</td>
               <td>
					<select name="selectActor" >
					<%if(request.getAttribute("listaActor")!=null){ 
					for(Actor a :(List<Actor>)request.getAttribute("listaActor")){
					 %>
					  <option value="<%=a.getId()%>"><%=a.getNombre() %></option>
					<%}} %>
					</select>
				</td>
            </tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="btnNuevo" value="Nuevo" class="button"></td>
			</tr>
		</table>

	</form>

</body>
</html>