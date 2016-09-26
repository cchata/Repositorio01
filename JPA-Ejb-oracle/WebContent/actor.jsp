<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>JSP Page</title>
	<link rel="stylesheet" href="/JPA-Ejb-oracle/css/cssLayout.css"/>
	<link rel="stylesheet" href="/JPA-Ejb-oracle/css/cssComponente2.css"/>

	<script type="text/javascript" src="js/actorJS.js" ></script>
	
	<script type="text/javascript" src="jquery/jquery-2.2.3.min.js" ></script>
	<script type="text/javascript" src="jquery-ui-1.11.4/jquery-ui.js" ></script>
	<link rel="stylesheet"        href="jquery-ui-1.11.4/jquery-ui.css"/>
        
    <link rel="stylesheet" href="css/popup.css">
	<script type="text/javascript" src="js/popup.js" ></script>
	
	
    </head>
<body >
<%
	int NUEVO      = 1; 
	int BUSCAR     = 2;
	int ELIMINAR   = 3;
	int ACTUALIZAR = 4;
	int LISTAR     = 5;
	int CRUD       = 6;
	int DEFAULT    = 7;
    int accion     = 0; 
    String mensaje = "";
   
 
if(request.getAttribute("ACCION") != null){
	accion = (Integer)request.getAttribute("ACCION");	
}
%>


<div id="wrapper">
<!-- #Mensajes -->
<% if(request.getAttribute("MENSAJE") != null) {
	      mensaje = (String)request.getAttribute("MENSAJE");
	   if(mensaje.split("---")[0].equals("0")){//OK %>
		    <div  class="mensajeGeneral"><%=mensaje.split("---")[1] %></div>
		    <script type="text/javascript">
				   setTimeout(function() {
				        $("div.mensajeGeneral").fadeOut(5000);
				    },1000);
				   
				   setTimeout(function() {
				        $("div.mensajeGeneral").fadeIn(5000);
				    },1000);
				   
				   setTimeout(function() {
				        $("div.mensajeGeneral").fadeOut(5000);
				    },1000);
				   setTimeout(function() {
				        $("div.mensajeGeneral").fadeIn(5000);
				    },1000);
				   setTimeout(function() {
				        $("div.mensajeGeneral").fadeOut(1000);
				    },10000);
		    </script>
		    
	 <%}else if(mensaje.split("---")[0].equals("1")){//Error %>
		    <div  class="mensajeError"><%=mensaje.split("---")[1] %></div>
		     <script type="text/javascript">
				   setTimeout(function() {
				        $("div.mensajeError").fadeOut(5000);
				    },1000);
				   
				   setTimeout(function() {
				        $("div.mensajeError").fadeIn(5000);
				    },1000);
				   
				   setTimeout(function() {
				        $("div.mensajeError").fadeOut(5000);
				    },1000);
				   setTimeout(function() {
				        $("div.mensajeError").fadeIn(1000);
				    },1000);
		    </script>
	 <%} %>
<% } %>
<!-- #Fin -->
		<!-- #wrapper -->
		<nav>
			<!-- top nav -->
			<div class="menu">
				<ul>
					<li><a href="index.jsp">Actor</a></li>
					<li><a href="peliculas.jsp">Peliculas</a></li>
					<li><a href="#">Products</a></li>
					<li><a href="#">Services</a></li>
					<li><a href="#">Locations</a></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
			</div>
		</nav>
		<!-- end of top nav -->

		<header>
			<!-- header -->
			<div id="plandesign"> <img src="img/plans.png" alt="" /> </div>
			
			<h1> <a href="#">Actor</a> </h1>
			
			<p>Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla
				quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Curabitur
				sodales ligula in libero. Sed dignissim lacinia nunc.
			</p>
				
		</header>
		<!-- end of header -->

		<section id="main">
			<!-- #main content and sidebar area -->
			<section id="content">
				<!-- #content -->

				<article>
						<div style="display: none;" ><a href="#" id="pintarFila" onclick="pintarFilaFnc('<%=request.getAttribute("paramSvr") %>');" >PintarFilaNueva</a></div>
						<% if(accion==NUEVO){ %>
							  <%@include file="jsp/crudActor/nuevoActor.jsp" %>
						<% }else if(accion==BUSCAR){ %>
							  <%@include file="jsp/crudActor/buscarActor.jsp" %>
						<% }else if(accion==ELIMINAR){ %>
						      <%@include file="jsp/crudActor/eliminarActor.jsp" %>
						<% }else if(accion==ACTUALIZAR){ %>
						      <%@include file="jsp/crudActor/actualizarActor.jsp" %>
						<% }else if(accion==LISTAR){ %>
						      <%@include file="jsp/crudActor/listadoActor.jsp" %>
						<% }else if(accion==CRUD){ %>
				              <%@include file="jsp/crudActor/crudActor.jsp" %>
				        <% }else if(accion==DEFAULT){ %>
								<h2><a href="#">First Article Title</a></h2>
								<p>
								    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Integer nec odio. Praesent libero. Sed cursus ante dapibus diam.
									Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis
									sagittis ipsum. Praesent mauris. Fusce nec tellus sed augue semper
									porta. Mauris massa. Vestibulum lacinia arcu eget nulla. Class
									aptent taciti sociosqu ad litora torquent per conubia nostra, per
									inceptos himenaeos. Curabitur sodales ligula in libero. Sed
									dignissim lacinia nunc. Fusce nec tellus sed augue semper porta.
									Mauris massa. Vestibulum lacinia arcu eget nulla.
								</p>
						<% } %>
					
				</article>
                
				<article>
					<h2>
						<a href="#">Second Article Title</a>
					</h2>
					
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Integer nec odio. Praesent libero. Sed cursus ante dapibus diam.
						Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis
						sagittis ipsum. Praesent mauris. Fusce nec tellus sed augue semper
						porta. Mauris massa. Vestibulum lacinia arcu eget nulla. Class
						aptent taciti sociosqu ad litora torquent per conubia nostra, per
						inceptos himenaeos. Curabitur sodales ligula in libero. Sed
						dignissim lacinia nunc.
					</p>
					
					<p>Nulla quis sem at nibh elementum imperdiet. Duis sagittis
						ipsum. Praesent mauris. Fusce nec tellus sed augue semper porta.
						Mauris massa. Vestibulum lacinia arcu eget nulla. Class aptent
						taciti sociosqu ad litora torquent per conubia nostra, per
						inceptos himenaeos.
					</p>
					
					<p>Mauris massa. Vestibulum lacinia arcu eget nulla. Class
						aptent taciti sociosqu ad litora torquent per conubia nostra, per
						inceptos himenaeos.
					</p>
				</article>

			</section>
			<!-- end of #content -->

			<aside id="sidebar">
				<!-- sidebar -->
				<h3>Things To Do</h3>
				<ul>
					<li><a href="insertarSvr.html">Nuevo autor</a></li>
					<li><a href="listarSvr.html">Listado autor</a></li>
					<li><a href="buscarSvr.html">Buscar actor</a></li>
					<li><a href="eliminarSvr.html">Eliminar actor</a></li>
					<li><a href="actualizarSvr.html">Actualizar actor</a></li>
					<li><a href="crudActorSvr.html">Crud actor</a></li>
				</ul>

				<h3>Sponsors</h3>
				<img src="img/ad125.jpg" alt="" />
				<img src="img/ad125.jpg" alt="" /><br />
				<img src="img/ad125.jpg" alt="" /> 
				<img src="img/ad125.jpg" alt="" /><br /> <br />

				<h3>Connect With Us</h3>
				<ul>
					<li><a href="#">Twitter</a></li>
					<li><a href="#">Facebook</a></li>
				</ul>
			</aside>
			<!-- end of sidebar -->

		</section>
		<!-- end of #main content and sidebar-->

		<footer>
			<section id="footer-area">

				<section id="footer-outer-block">
					<aside class="footer-segment">
						<h4>Friends</h4>
						
						<ul>
							<li><a href="#">one linkylink</a></li>
							<li><a href="#">two linkylinks</a></li>
							<li><a href="#">three linkylinks</a></li>
						</ul>
					</aside>
					<!-- end of #first footer segment -->

					<aside class="footer-segment">
						<h4>Awesome Stuff</h4>
						
						<ul>
							<li><a href="#">one linkylink</a></li>
							<li><a href="#">two linkylinks</a></li>
							<li><a href="#">three linkylinks</a></li>
						</ul>
					</aside>
					<!-- end of #second footer segment -->

					<aside class="footer-segment">
						<h4>Coolness</h4>
						
						<ul>
							<li><a href="#">one linkylink</a></li>
							<li><a href="#">two linkylinks</a></li>
							<li><a href="#">three linkylinks</a></li>
						</ul>
						
					</aside>
					<!-- end of #third footer segment -->

					<aside class="footer-segment">
						<h4>Blahdyblah</h4>
						
						<p>Integer nec odio. Praesent libero. Sed cursus ante dapibus
							diam.
						</p>
					</aside>
					<!-- end of #fourth footer segment -->

				</section>
				<!-- end of footer-outer-block -->

			</section>
			<!-- end of footer-area -->
		</footer>

	</div>
	<!-- #wrapper -->
	<!-- Free template created by http://freehtml5templates.com -->


</body>
</html>