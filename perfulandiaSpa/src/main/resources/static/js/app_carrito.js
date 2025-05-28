const carrito = (() => {
    const API = "/api/v1/carrito";

    //Funcion para mostrar el carrito
    async function listarCarrito() {
        try {
            const response = await fetch(API);
            const perfumes = await response.json();
            const tbody = document.querySelector("#tablaCarrito tbody");
            const totalItems = document.getElementById("totalCarrito");
            tbody.innerHTML = "";
            totalItems.textContent = perfumes.length;

            perfumes.forEach(perfume => {
                const fila = `
                    <tr>
                        <td>${perfume.id}</td>
                        <td>${perfume.nombre}</td>
                        <td>${perfume.marca}</td>
                        <td>
                            <button onclick ="carrito.eliminarPerfume(${perfume.id})">Eliminar</button>
                        </td>
                    <tr>                                                                       
                `;
                tbody.innerHTML += fila;
            });
        } catch (err) {
            console.error("Error al cargar el carrito", err);
        }
    }

    //Funcion para agregar un perfume al carrito
    async function agregarPerfume(id) {
        try {
            await fetch(`${API}/agregar/${id}`,{method: "POST"});
            alert("Perfume agregado al carrito");
            listarCarrito();
        } catch (err) {
            console.error("Error al agregar al carrito", err);
        }
    }

    //funcion para eliminar un perfume en el carrito
    async function eliminarPerfume(id) {
        try {
            await fetch(`${API}/eliminar/${id}`, {method: "DELETE"});
            alert("Perfume ha sido eliminado del carrito");
            listarCarrito();    
        } catch (err) {
            console.error("Error al eliminar del carrito");
        }
    }

    //funcion para vaciar el carrito
    async function vaciarCarrito() {
        if(confirm("¿Esta seguro de vaciar el carro de compras?")){
            await fetch(`${API}/vaciar`,{method: "DELETE"});
            alert("El carrito esta vacio");
            listarCarrito();  
        }
    }

    //funcion para confirmar compra
    async function confirmarCompra() {
        const total = document.getElementById("totalCarrito").textContent;
        if(parseInt(total) === 0){
            alert("El carrito esta vacio.");
            return;
        }
        if(confirm(`¿Desea confirmar tu compra por ${total}?`)){
            await fetch(`${API}/vaciar`, {method: "DELETE"});
            alert("Gracias por  su compra!");
            listarCarrito();
        }
    }
    return{listarCarrito, agregarPerfume, eliminarPerfume, vaciarCarrito, confirmarCompra};
})();