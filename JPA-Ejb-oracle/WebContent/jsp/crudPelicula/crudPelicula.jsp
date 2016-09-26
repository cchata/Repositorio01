<%@ page import="java.util.*"%>
<%@ page import="entity.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
<%
int              posicionRow       = 0;
SimpleDateFormat sdf               = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat sdf2              = new SimpleDateFormat("yyyy-MM-dd");
%>
</head>
<body>



	<form name="formCrud" action="crudPelucilaSvr.html" method="post">
	     <table class="formulario">
			<tr>
				<td>Buscar nombre:</td>
				<td><input type="text"   name="txtNombre" id="txtNombre" value="<%=request.getAttribute("txtNombreR")==null?"":request.getAttribute("txtNombreR")%>"></td>
				<td><input type="submit" name="btnaccion" value="Buscar" class="button"></td>
			</tr>
		</table>
			<div><a href="exportarExcelPSvr.html">Excel</a></div>
			<table class="table" id="idtable">
						   <tr>
								<th>ID</th>
								<th>NOMBRE</th>
								<th>ESTRENO</th>
								<th>ACTOR</th>
								<th>ACCION</th>
								<th>ACCION</th>
						   </tr>
							
				   <%if(request.getAttribute("listaPelicula")!=null){
				        for(Pelicula p : (List<Pelicula>)request.getAttribute("listaPelicula")){posicionRow++;%>
				           <tr>
				              <td><%=p.getId() %></td>
				              <td><%=p.getNombre() %></td>
				              <td><%=sdf.format(p.getEstreno()) %></td>
				              <td><%=p.getActor().getNombre() %></td>
				              <td><a href="#" onclick="updatePeliculaa('<%=p.getId()%>','<%=p.getNombre()%>','<%=sdf2.format(p.getEstreno())%>','<%=p.getActor().getId()%>','<%=posicionRow%>');">UPDATE</a></td>
				              <td><a href="#" onclick="deletePelicula('<%=p.getId()%>');">DELETE</a></td>
				           </tr>
				   <%}}%>
			</table>
			
			
			<div style="display: none;" ><a href="#" id="update"  >UPDATE</a></div>
			<div><a href="#" id="nuevo">Nuevo</a></div>
			
			<div id="nuevo-popup" style="display: none;">
			    <div class="content-popup">
			        <div class="close"><a href="#"><img src="img/close.png"/></a></div>
			        <div>
		                 <h2>Contenido POPUP</h2>
					     <table class="formulario">
								<tr>
									<td>Nombre:</td>
									<td><input type="text" name="txtNombre1" id="txtNombre"></td>
								</tr>
					
					            <tr>
									<td>Estreno:</td>
									<td><input type="date" name="dateEstreno1"></td>
								</tr>
					
					            <tr>
					               <td>Actor:</td>
					               <td>
										<select name="selectActor1" >
										<%if(request.getAttribute("listaActor")!=null){ 
										for(Actor a :(List<Actor>)request.getAttribute("listaActor")){
										 %>
										  <option value="<%=a.getId()%>"><%=a.getNombre() %></option>
										<%}} %>
										</select>
									</td>
					            </tr>
								<tr>
									<td colspan="2" align="center">
									    <input type="submit" name="btnaccion" value="Nuevo" class="button">
									</td>
								</tr>
							</table>
			        </div>
               </div>
           </div>
			
			
			
			<div id="update-popup" style="display: none;">
			    <div class="content-popup">
			        <div class="close"><a href="#"><img src="img/close.png"/></a></div>
			        <div>
		                <h2>Contenido POPUP</h2>
					        <table class="formulario">
								    <tr>
								       <td>Id</td>
								       <td><input type="text" name="txtid2"     id="txtidpelicula"  readonly/></td>
								    </tr>
								    <tr>
								       <td>Nombre</td>
								       <td><input type="text" name="txtNombre2" id="txtnombrepelicula" /></td>
								    </tr>
								    <tr>
								       <td>Estreno</td>
								       <td><input type="date" name="dateEstreno2"   id="dateestreno"  /></td>
								    </tr>
								    <tr>
						               <td>Actor:</td>
						               <td>
											<select name="selectActor2" id="selectActor" >
												<%if(request.getAttribute("listaActor")!=null){ 
												   for(Actor a :(List<Actor>)request.getAttribute("listaActor")){
												    %>
													    <option value="<%=a.getId()%>"><%=a.getNombre() %></option>
												<%}}%>
											</select>
										</td>
						            </tr>
								    <tr>
								       <td colspan="3" align="center">
								           <input type="submit" name="btnaccion" value="Actualizar" class="button"/>
								           <input type="hidden" name="txtposicionrow" id="txtposicionrow" />
								       </td>
								    </tr>
							    </table>
			        </div>
               </div>
           </div>
			
	</form>
	
<div class="popup-overlay"></div>

</body>
</html>
