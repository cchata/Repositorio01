<%@ page import="java.util.*"%>
<%@ page import="entity.*"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
<%
int posicionRow   = 0;
%>
</head>
<body>



	<form name="formCrud" action="crudActorSvr.html" method="post">
	     <table class="formulario">
			<tr>
				<td>Buscar nombre:</td>
				<td><input type="text"   name="txtNombre" id="txtNombre" value="<%=request.getAttribute("txtNombreR")==null?"":request.getAttribute("txtNombreR")%>"></td>
				<td><input type="submit" name="btnaccion" value="Buscar" class="button"></td>
			</tr>
		</table>
			<div><a href="exportarExcelSvr.html">Excel</a></div>
			<table class="table" id="idtable">
						   <tr>
								<th>ID</th>
								<th>NOMBRE</th>
								<th>EDAD</th>
								<th>ACCION</th>
								<th>ACCION</th>
						   </tr>
							
				   <%if(request.getAttribute("listaActor")!=null){
				        for(Actor a : (List<Actor>)request.getAttribute("listaActor")){posicionRow++; %>
				           <tr>
				              <td><%=a.getId() %></td>
				              <td><%=a.getNombre() %></td>
				              <td><%=a.getEdad() %></td>
				              <td><a href="#" onclick="updateActorr('<%=a.getId()%>','<%=a.getNombre()%>','<%=a.getEdad()%>','<%=posicionRow%>');">UPDATE</a></td>
				              <td><a href="#" onclick="deleteActor('<%=a.getId()%>');">DELETE</a></td></tr>
				   <%}}%>
			</table>
			
			
			<div style="display: none;" ><a href="#" id="update"  >Update</a></div>
			<div><a href="#" id="nuevo">Nuevo</a></div>
			
			
			
<!-- 			nuevo -->
			<div id="nuevo-popup" style="display: none;">
			    <div class="content-popup">
			        <div class="close"><a href="#"><img src="img/close.png"/></a></div>
			        <div>
		                 <h2>Nuevo POPUP</h2>
					     <table class="formulario">
								<tr>
									<td>Nombre:</td>
									<td><input type="text" name="txtNombre1" id="txtNombre"></td>
								</tr>
					            <tr>
									<td>Edad:</td>
									<td><input type="text" name="txtEdad1"></td>
								</tr>
								<tr>
									<td colspan="2" align="center"><input type="submit" name="btnaccion" value="Nuevo" class="button" onclick="pintarFila();"></td>
								</tr>
						</table>
			        </div>
               </div>
           </div>
	<!-- 	 		 -->
			
<!-- 			update -->
			    <div id="update-popup" style="display: none;">
			    <div class="content-popup">
			        <div class="close"><a href="#"><img src="img/close.png"/></a></div>
			        <div>
		                <h2>Actualizar POPUP</h2>
					    <table class="formulario">
							    <tr>
							       <td>Id</td>
							       <td><input type="text" name="txtId2"     id="txtidactor"  readonly/></td>
							    </tr>
							    <tr>
							       <td>Nombre</td>
							       <td><input type="text" name="txtNombre2" id="txtnombreactor" /></td>
							    </tr>
							    <tr>
							       <td>Edad</td>
							       <td><input type="text" name="txtEdad2"   id="txtedadactor"  /></td>
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
		<!-- 	 		 -->	
	</form>
	
<div class="popup-overlay"></div>

</body>
</html>