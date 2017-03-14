 <!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>LOGIN</title>
      <link rel="stylesheet" href="CSS/style.css">
      <script src="Scripts/script.js"></script>
</head>

<body>
	<%
	session.invalidate();
	response.sendRedirect("LOGIN.html");
	%>

</body>
</html>
  
