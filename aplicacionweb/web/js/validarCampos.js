var form = document.getElementById("Formulario");

form.addEventListener("submit", function (event) {
    event.preventDefault();
    var comodin = true,
            elementos = this.elements,
            total = elementos.length;

    for (var i = 0; i < total; i++) {
        if (!elementos[i].value.length) {
            if (elementos[i].name != "") {
                alert("Debes de ingresar el " + elementos[i].name);
                elementos[i].focus();
                comodin = false;
                break;
            } else if ($("#tipo option:selected").val() == 0) {
                alert("Debe Seleccionar un Tipo de usuario");
                elementos[i].focus();
                comodin = false;
                break;
            }
        }
    }

    if (comodin) {
        this.submit();
    }
}, false);