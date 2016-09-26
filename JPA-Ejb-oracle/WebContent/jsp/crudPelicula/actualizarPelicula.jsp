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
SimpleDateFormat sdfOutput  = new SimpleDateFormat("dd/MM/yyyy");//BD   -> view
SimpleDateFormat sdf2Intput = new SimpleDateFormat("yyyy-MM-dd");//view -> BD
%>
	<form name="formActualizar" action="actualizarPSvr.html" method="post" id="idFormActualizar">
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
				              <td><%=sdfOutput.format(p.getEstreno())  %></td>
				              <td><%=p.getActor().getNombre()  %></td>
				              <td><a href="#" onclick="actualizarPelicula('<%=p.getId()%>','<%=p.getNombre()%>','<%=sdf2Intput.format(p.getEstreno())%>','<%=p.getActor().getId()%>');">Actualizar</a></td>
				           </tr>
				   <%}}%>
	    </table>
	    
	  <div id="divformulario">
	    <br/>
	    <table class="formulario">
		    <tr>
		       <td>Id</td>
		       <td><input type="text" name="txtidpelicula"     id="txtidpelicula"  readonly/></td>
		    </tr>
		    <tr>
		       <td>Nombre</td>
		       <td><input type="text" name="txtnombrepelicula" id="txtnombrepelicula" /></td>
		    </tr>
		    <tr>
		       <td>Estreno</td>
		       <td><input type="date" name="dateestreno"   id="dateestreno"  /></td>
		    </tr>
		    <tr>
               <td>Actor:</td>
               <td>
					<select name="selectActor" id="selectActor" >
					<%if(request.getAttribute("listaActor")!=null){ 
					for(Actor a :(List<Actor>)request.getAttribute("listaActor")){
					 %>
					  <option value="<%=a.getId()%>"><%=a.getNombre() %></option>
					<%}} %>
					</select>
				</td>
            </tr>
		    <tr>
		       <td colspan="3" align="center"><input type="submit" name="btnActualizar" value="Actualizar" class="button"/></td>
		    </tr>
	    </table>
     </div>
	</form>

</body>
</html>