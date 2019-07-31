
function validarText(a, b, c, m) {
	var nombre = document.getElementById(c).value;
	console.log(nombre);
	if (nombre == "") {
		document.getElementById(m).innerHTML = 'Es necesario llenar este campo';
	} else {
		if (nombre.length < a) {
			document.getElementById(m).innerHTML = 'Es necesario ' + a
					+ ' caracteres';
		} else {
			if (nombre.length > b) {
				document.getElementById(m).innerHTML = 'A superado el numero máximo de caracteres';
			} else {
				document.getElementById(m).innerHTML = '';
			}
		}
	}

}

function validarCedula(c, m) {
	var cad = document.getElementById(c).value.trim();
	var total = 0;
	var longitud = cad.length;
	var longcheck = longitud - 1;

	if (cad !== "" && longitud === 10) {
		for (i = 0; i < longcheck; i++) {
			if (i % 2 === 0) {
				var aux = cad.charAt(i) * 2;
				if (aux > 9)
					aux -= 9;
				total += aux;
			} else {
				total += parseInt(cad.charAt(i));
			}
		}

		total = total % 10 ? 10 - total % 10 : 0;

		if (cad.charAt(longitud - 1) == total) {
			document.getElementById(m).innerHTML = '';
		} else {
			document.getElementById(m).innerHTML = 'Cédula Invalida';
		}
	} else {
		document.getElementById(m).innerHTML = 'Cédula Invalida';
	}
}

function validarTelefono(c, m) {

	var telefono = document.getElementById(c).value;
	if (!isNaN(telefono)) {
		validarText(9, 9, c, m);
	} else {
		document.getElementById(m).innerHTML = 'Teléfono incorrecto';
	}
}
function validarTelefono1(c, m) {

	var telefono = document.getElementById(c).value;
	if (!isNaN(telefono)) {
		validarText(10, 10, c, m);
	} else {
		document.getElementById(m).innerHTML = 'Teléfono incorrecto';
	}
}

function validarEmail(c, m) {
	emailRegex = /^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$/;
	var email = document.getElementById(c).value;
	if (email != "") {
		if (email.search(emailRegex) == 0) {
			document.getElementById(m).innerHTML = '';
		} else {
			document.getElementById(m).innerHTML = 'Ingrese un email valido';
		}
	} else {
		document.getElementById(m).innerHTML = 'Ingrese un email';
	}
}
function validarCamposLLenos() {
	var telefono = document.getElementById(c).value;
	var email = document.getElementById(c).value;
	var cad = document.getElementById(c).value.trim();
	var nombre = document.getElementById(c).value;
}