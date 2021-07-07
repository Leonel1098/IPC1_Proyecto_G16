const divVentas = document.getElementById('VerVentas')

function CargarDatos(){
    const ids = JSON.parse(localStorage.getItem("idordenado"))
    const nombres= JSON.parse(localStorage.getItem("nombreordenado"))
    const montos = JSON.parse(localStorage.getItem("montoordenado"))
    crearTarjetas(ids, nombres, montos)
}

function crearTarjetas(ids, nombres, montos) {
    let html = ''
    for(i=0; i<ids.length; i++){
        html += crearTarjeta(ids[i], nombres[i], montos[i])
    }
    divVentas.innerHTML = html;
}

function crearTarjeta(ids,nombres, montos) {
    let html = `
        <div class="card mb-4 text-white bg-primary" style="width: 18rem;">
        <div class="card-body">
        <h5 class="card-title">ID: ${ids}</h5>
        </div>
        <ul class="list-group list-group-flush">
        <li class="list-group-item list-group-item-info">Nombre: ${nombres}</li>
        <li class="list-group-item list-group-item-info">Monto: ${montos}</li>
        </ul>
        <div class="card-body">
        </div>
        </div>`
        return html
}

if(location.reload){
    CargarDatos() 
}

