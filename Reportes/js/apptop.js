const divVentas = document.getElementById('VerTop')

function CargarDatos(){
    const nombres= JSON.parse(localStorage.getItem("nombredelproductovendido"))
    const cantidad = JSON.parse(localStorage.getItem("ventatotaldeproducto"))  
    crearTarjetas(nombres, cantidad)
}

function crearTarjetas(nombres, cantidad) {
    let html = ''
    for(i=0; i<5; i++){
        if(nombres[i]!=null && cantidad[i]!=null){
        html += crearTarjeta(nombres[i], cantidad[i])
        }
    }
    divVentas.innerHTML = html;
}

function crearTarjeta(nombres, cantidad){
    let html = `
        <div class="card mb-4 text-white bg-primary" style="width: 18rem;">
        <div class="card-body">
        <h5 class="card-title">Nombre: ${nombres}</h5>
        </div>
        <ul class="list-group list-group-flush">
        <li class="list-group-item list-group-item-info">Cantidad veces comprado: ${cantidad}</li>
        </ul>
        <div class="card-body">
        </div>
        </div>`
        return html
}

if(location.reload){
    CargarDatos() 
}


