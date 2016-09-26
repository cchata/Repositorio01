<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>jQuery UI Dialog - Modal form</title>
  
  <link rel="stylesheet" href="jquery-ui-1.11.4/jquery-ui.css">
  <script src="jquery/jquery-2.2.3.min.js"></script>
  <script src="jquery-ui-1.11.4/jquery-ui.js"></script>
  
    <link rel="stylesheet" href="css/jqActor.css">
	<script type="text/javascript" src="js/actorJquery.js" ></script>
  
</head>
<body >
 <div id="claspopup" style="font-size: 62.5%;">
<div id="dialog-form"  title="Crear nuevo usuario">
	  <p class="validateTips">All form fields are required.</p>
	 
	  <form style="font-size: 62.5%;">
		    <fieldset>
			      <label for="name">Name</label>
			      <input type="text" name="name" id="name" value="Jane Smith" class="text ui-widget-content ui-corner-all">
			      <label for="email">Edad</label>
			      <input type="text" name="email" id="email" value="jane@smith.com" class="text ui-widget-content ui-corner-all">
			 
			      <!-- Allow form submission with keyboard without duplicating the dialog button -->
			      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
		    </fieldset>
	  </form>
</div>
 

<button id="create-user" >Create new user</button>
 
 </div>
</body>
</html>