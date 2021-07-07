const inputJson = document.getElementById('inputJson')
const divTodosClientes = document.getElementById('TodosClientes')
const Vista = document.getElementById('VistaIn')

function leerJSON() {
    const fileReader = new FileReader()

    function miOnLoad() {
        const json = JSON.parse(fileReader.result)
        localStorage.setItem("clientesS", JSON.stringify(json))
        const f = JSON.parse(localStorage.getItem("clientesS"))
        crearTarjetas(f)
    }

    fileReader.readAsText(inputJson.files[0])
    fileReader.onload = miOnLoad
}

function crearTarjetas(clients) {
    let html = ''
    for (const cliente of clients) {
        html += crearTarjeta(cliente)
    }
    divTodosClientes.innerHTML = html;
}

function crearTarjeta(cliente) {
    let html = `
        <div class="card mb-4 text-white bg-primary" style="width: 18rem;">
        <div class="card-body">
        <h5 class="card-title">${cliente.id}</h5>
        </div>
        <ul "class="list-group list-group-flush">
        <li class="list-group-item list-group-item-info">Nombre: ${cliente.name}</li>
        <li class="list-group-item list-group-item-info">Direccion: ${cliente.address}</li>
        <li class="list-group-item list-group-item-info">Tel: ${cliente.phone}</li>
        <li class="list-group-item list-group-item-info">NIT: ${cliente.nit}</li>
        </ul>
        <div class="card-body">
        <a><button type="button" class="btn-ver btn btn-warning"  data-bs-toggle="modal" data-bs-target="#exampleModal">Ver</button></a>
        </div>
        </div>`
    return html
}


function Ver(id, name, address, phone, nit) {
    let ht = `
        <div class="card mb-4 text-white bg-success" style="width: 18rem;">
        <div class="card-body">
        <h5 class="card-title">${id}</h5>
        </div>
        <ul class="list-group list-group-flush">
        <li class="list-group-item list-group-item-success">Nombre: ${name}</li>
        <li class="list-group-item list-group-item-success">Direccion: ${address}</li>
        <li class="list-group-item list-group-item-success">Tel: ${phone}</li>
        <li class="list-group-item list-group-item-success">NIT: ${nit}</li>
        </ul>
        <div class="card-body">
        <button type="button" class="btn btn-warning" data-bs-dismiss="modal">Cerrar</button>
        </div>
        </div>`
    return ht
}

const on = (element, event, selector, handler) => {
    console.log(handler)
    element.addEventListener(event, e => {
        if (e.target.closest(selector)) {
            handler(e)
        }
    })
}

if (location.reload) {
    const f = JSON.parse(localStorage.getItem("clientesS"))
    if (f != null) {
        crearTarjetas(f)
        //localStorage.removeItem("clientesS",JSON.stringify(f))
    }
}


inputJson.addEventListener('change', leerJSON)

on(document, 'mouseover', '.btn-ver', e => {
    const tarjeta = e.target.parentNode.parentNode.parentNode
    const divt = tarjeta.firstElementChild
    const id = divt.firstElementChild.innerHTML
    const clientes = JSON.parse(localStorage.getItem("clientesS"))
    BuscarCliente(id, clientes)

})

function BuscarCliente(id, clientes) {
    for (const cliente of clientes) {
        if (cliente.id == id) {
           ht = Ver(cliente.id, cliente.name, cliente.address, cliente.phone, cliente.nit)
            Vista.innerHTML= ht;
        }
    }
}
