const API_URL_CONTACTO = "http://localhost:8080/api/v2/contacto/enviar";

function enviarMensaje() {
    const contacto = {
        nombre: document.getElementById("nombre").value,
        email: document.getElementById("email").value,
        mensaje: document.getElementById("mensaje").value
    };

    fetch(API_URL_CONTACTO, {
        method: "POST", headers: { "Content-Type": "application/json" },
        body: JSON.stringify(contacto)
    })
    .then(response => response.json())
    .then(data =>{
        alert("¡Mensaje enviado con éxito! ID: " + data.id);
        document.querySelector("form").reset();
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Error al enviar el mensaje");
    });
}

//Para que funcione al apretar el boton
document.getElementById("btnEnviar").addEventListener("click", (e) => {
    e.preventDefault();
    enviarMensaje();
});