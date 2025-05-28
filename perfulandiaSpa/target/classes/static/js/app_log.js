API_URL = "http://localhost:8080/api/v2/usuarios/login";
//metodo para autenticar el usuario registrado en la base de datos
function login() {
    fetch(API_URL, {
        method: "POST",
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify({
            email: document.getElementById("email").value, //valida el nombre ingresado en el login con el de la base de datos
            password: document.getElementById("password").value //Valida la password ingresado en el login con la base de datos
        })
    })
    .then(respuesta => respuesta.json())
    .then(data => {//Manejamos la respuesta del servidor
        if (data.result === "OK") {//Si la validacion es correcta
            sessionStorage.setItem("nombreUsuario", data.nombre); //se muestra el nombre de usuario
            window.location.href = "/index.html";//se carga el index.html
        } else { //si la validacion es incorrecta
            alert("Acceso ha sido denegado.");//se niega el acceso
        }
    });
}