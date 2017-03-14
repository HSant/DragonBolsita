 <!DOCTYPE html>

<html >
<head>
  <meta charset="UTF-8">
  <title>LOGIN</title>
      <link rel="stylesheet" href="CSS/Boton.css">
      <link rel="import" href="Admi-n.jsp">
      <link rel="stylesheet" href="CSS/style.css">
      <script src="Scripts/script.js"></script>
</head>

<body>
 	<%	
		String nombre=(String)session.getAttribute("usuario");
		if(nombre==null){
    		response.sendRedirect("Error.jsp");
		}
	%>
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


			<iframe src="Admi-n.jsp" style="left:20%;width:1000px;height:650px;position:relative;"></iframe>



</body>
</html>
  