const API_URL = "http://localhost:8080/api/v1/perfumes";


function listarPerfumes() {
    fetch(API_URL)
    .then(response => response.json())
    .then(perfumes => {
        const tbody = document.querySelector("#tablaPerfumes tbody");
        tbody.innerHTML = "";
        perfumes.forEach(perfume => {
            const fila = `
            <tr>
                <td>${perfume.id}</td>
                <td>${perfume.nombre}</td>
                <td>${perfume.marca}</td>
                <td>${perfume.precio}</td>
                <td>${perfume.ml}</td>
                <td>${perfume.stock}</td>
                <td>
                    <button class="btn btn-success btn-sm" onclick="carrito.agregarPerfume(${perfume.id})"> Agregar </button> 
                </td>
            <tr>
            `;
            tbody.innerHTML+= fila;

        });
    });
}


let perfumes = []; // Variable para almacenar la lista de perfumes
// Función para agregar un perfume
function agregarPerfume() {
    const nombre = document.getElementById("nombre").value;
    const marca = document.getElementById("marca").value;
    const precio = document.getElementById("precio").value;
    const ml = document.getElementById("ml").value;

    const nuevoPerfume = {
        nombre,
        marca,
        precio,
        ml
    };

    // Enviar el nuevo perfume al servidor
    // Se utiliza la API Fetch para enviar los datos al servidor
    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(nuevoPerfume)
    })// Enviar el nuevo perfume al servidor
    .then(response => response.json())
    .then(data => {
        alert("Perfume agregado exitosamente");
        listarPerfumes();// Actualizar la tabla de perfumes
        limpiarFormulario();// Limpiar el formulario
    });
}
//* Función para eliminar un Perfume
/*function eliminarPerfume(id) {
    fetch(`${API_URL}/${id}`, { method: "DELETE" })
        .then(response => {
            if (response.ok) {
                alert("Perfume eliminado exitosamente");
                listarPerfumes();
            }
        });
}*/

// Función para buscar un PERFUME por su ID y cargarlo en el formulario
// Se utiliza la API Fetch para obtener los datos del perfume desde el servidor
let perfumeEnEdicionId = null; // Variable para almacenar el ID del perfume en edición
function buscarPerfume(id) {
    fetch(`${API_URL}/${id}`)
        .then(response => response.json())
        .then(perfume => {
            document.getElementById("nombre").value = perfume.nombre;
            document.getElementById("marca").value = perfume.marca;
            document.getElementById("precio").value = perfume.precio;
            document.getElementById("ml").value = perfume.ml;
            document.getElementById("stock").value = perfume.stock;


             // Guardar el ID del perfume en edición
             perfumeEnEdicionId = perfume.id;
             
            // Cambiar el botón de agregar por actualizar
            const boton = document.getElementById("botonFormulario");
            if (boton) {
                boton.textContent = "Actualizar Perfume";
                boton.onclick = function() {
                    actualizarPerfume(perfume.id);
                };
            }
        });
}

