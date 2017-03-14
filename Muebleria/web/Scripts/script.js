function validarPass(){
        var valor = document.getElementById("sEmail").value;
    if (/^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i.test(valor)==false)
        alert("La dirección de email " + valor + " es incorrecta.");



	var p1 = document.getElementById("pass").value;
    var p2 = document.getElementById("passr").value;
    /*Que no haya espacios en blanco*/
    var espacios = false;
    var cont = 0;



	while (!espacios && (cont<p1.length)) {
		if (p1.charAt(cont)==" ")
			espacios=true;
		cont++;
    }
    if (espacios) {
		alert ("La contraseña no puede contener espacios en blanco");
		return false;
    }
    /*Que no haya dejado espacio vacíos*/
    if (p1.length == 0 || p2.length == 0) {
		alert("Los campos de la password no pueden quedar vacios");
		return false;
    }
    /*Que coincidan*/
    if (p1 != p2){
		alert("Las passwords deben de coincidir");
		return false;
    }else{
		alert("Todo esta correcto");
		return true; 
    }
}
function EliminarU(algo){
    var nUser = document.getElementById("nUser"+algo).innerHTML;
    var nNombre = document.getElementById("nNombre"+algo).innerHTML;
    var nPassU = document.getElementById("nPassU"+algo).innerHTML;
    var nEmail = document.getElementById("nEmail"+algo).innerHTML;

    
    document.getElementById("uUser").value = nUser;
    document.getElementById("uNombre").value = nNombre;
    document.getElementById("uPassword").value = nPassU;
    document.getElementById("uEmail").value = nEmail;

    document.getElementById("userToD").value = nUser;
}
