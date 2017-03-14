 <!DOCTYPE html>

<html >
<head>
  <meta charset="UTF-8">
  <title>LOGIN</title>
      <link rel="stylesheet" href="CSS/Boton.css">
      <link rel="stylesheet" href="CSS/style.css">
      <script src="Scripts/script.js"></script>
</head>

<body>
	<!--
            String n=(String)session.getAttribute("tam");
           int tama = Integer.parseInt(n);
           out.println("<table border='2'>");
		for ( int i = 0; i <tama; i++ ){   //Se recorre la lista de hijos del nodo raiz
           out.println("<tr><td>");
           String nUser=(String)session.getAttribute("user"+i);
           out.println(""+nUser);
           out.println("</td><td>");
           String passU=(String)session.getAttribute("pass"+i);
           out.println(""+passU);
           out.println("</td></tr><br>");
            }
             out.println("</table>");   
	-->
	<%
		String n=(String)session.getAttribute("tam");
		int tama = Integer.parseInt(n);

		for ( int i = 0; i <tama; i++ ){   //Se recorre la lista de hijos del nodo raiz
			String nUser=(String)session.getAttribute("user"+i);
			out.println("<label name=\"nUser"+i+"\" id=\"nUser"+i+"\" class=\"input\" onClick=\"EliminarU('"+i+"')\">"+nUser+"</label>");
			out.println("");
			String nNombre=(String)session.getAttribute("nombre"+i);
			out.println("<label name=\"nNombre"+i+"\" id=\"nNombre"+i+"\" class=\"input\">"+nNombre+"</label>");
			out.println("");
			String nPassU=(String)session.getAttribute("pass"+i);
			out.println("<label name=\"nPassU"+i+"\" id=\"nPassU"+i+"\" class=\"input\">"+nPassU+"</label>");
			out.println("");
			String nEmail=(String)session.getAttribute("email"+i);
			out.println("<label name=\"nEmail"+i+"\" id=\"nEmail"+i+"\" class=\"input\">"+nEmail+"</label>");
			out.println("<br>");
		} 
	%>
	<div class="cajaAdmin">
		<div class="contentAdmin">
			<form name="formU" method="GET"  action="SActualiza">
				<div class="boton">
					Usuario: <input type="text" name='uUser' 	id="uUser" 		class="input" value="" ></label>
					Nombre:  <input type="text" name='uNombre'	id="uNombre" 	class="input" value="" ></label><br>
					Password:<input type="password" name='uPassword' id="uPassword" 	class="input" value="" ></label>
					Email:	 <input type="text" name='uEmail' 	id="uEmail" 	class="input" value="" ></label><br>
					<input type="submit" class="button" value="Actualizar Usuario" onClick="location.href='SActualiza'">
				</div>
			</form>
			<div class="hr"></div>
			<form name="formD" method="GET"  action="SElimina">
				<div class="boton">
					Datos Usuario:<input type="text" name="userToD" id="userToD" class="input" value=""></label>
					<input type="submit" class="button" value="Eliminar Usuario" onClick="location.href='SElimina'">
				</div>
			</form>
			<div class="hr"></div>
				<div class="boton">
					<input type="submit" class="button" value="Cerrar Sesion" onClick="location.href='cerrar.jsp'">
				</div>
		</div>
	</div>

</body>
</html>
  