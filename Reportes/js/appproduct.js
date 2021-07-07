const inputJson = document.getElementById('inputJson')
const divTodosClientes = document.getElementById('TodosProducts')
const Vista = document.getElementById('VistaProd')

function leerJSON() {
    const fileReader = new FileReader()

    function miOnLoad() {
        const json = JSON.parse(fileReader.result)
        localStorage.setItem("prroducto", JSON.stringify(json))
        const f = JSON.parse(localStorage.getItem("prroducto"))
        crearTarjetas(f)
    }

    fileReader.readAsText(inputJson.files[0])
    fileReader.onload = miOnLoad
}

function crearTarjetas(products) {
    let html = ''
    for (const producto of products) {
        html += crearTarjeta(producto)
    }
    divTodosClientes.innerHTML = html;
}

function crearTarjeta(producto) {
    let html = `
        <div class="card mb-4 text-white bg-primary" style="width: 18rem;">
        <div class="card-body">
        <h5 class="card-title">${producto.id}</h5>
        </div>
        <ul class="list-group list-group-flush">
        <li class="list-group-item list-group-item-info">Nombre: ${producto.name}</li>
        <li class="list-group-item list-group-item-info">Descripción: ${producto.description}</li>
        <li class="list-group-item list-group-item-info">Costo: ${producto.cost}</li>
        <li class="list-group-item list-group-item-info">Precio: ${producto.price}</li>
        <li class="list-group-item list-group-item-info">Cantidad de Ingredientes: ${producto.ingredients.length}</li>
        </ul>
        <div class="card-body">
        <a><button type="button" class="btn-ver btn btn-warning"  data-bs-toggle="modal" data-bs-target="#exampleModal">Ver</button></a>
        </div>
        </div>`
    return html
}

function Ver(id, nombre, descripcion, costo, precio, ingredientes) {
    let pr = CrearProductos(ingredientes)

    let ht = `
        <div class="card mb-4 text-white bg-success" style="width: 18rem;">
        <div class="card-body">
        <h5 class="card-title">${id}</h5>
        </div>
        <ul class="list-group list-group-flush">
        <li class="list-group-item list-group-item-success">Nombre: ${nombre}</li>
        <li class="list-group-item list-group-item-success">Descripción: ${descripcion}</li>
        <li class="list-group-item list-group-item-success">Costo: ${costo}</li>
        <li class="list-group-item list-group-item-success">Precio: ${precio}</li>
        </ul>
        ${pr}
        <div class="card-body">
        <a><button type="button" class="btn btn-warning" data-bs-dismiss="modal">Cerrar</button></a>
        </div>
        </div>`
    return ht
}

function CrearProductos(ingredients) {
    let ht = ''
    var cont = 0;
    for (const ingredient of ingredients) {
        cont++;
        ht += CrearProducto(ingredient, cont)
    }
    cont =0;
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
    const f = JSON.parse(localStorage.getItem("prroducto"))
    if (f != null) {
        crearTarjetas(f)
        //localStorage.removeItem("prroducto",JSON.stringify(f))
    }
}


inputJson.addEventListener('change', leerJSON)

on(document, 'mouseover', '.btn-ver', e => {
    const tarjeta = e.target.parentNode.parentNode.parentNode
    const divt = tarjeta.firstElementChild
    const id = divt.firstElementChild.innerHTML
    const productos = JSON.parse(localStorage.getItem("prroducto"))
    BuscarProducto(id, productos)

})

function CrearProducto(ingredients, cont) {
    return `
            <div class="card-body">
            <h5 class="card-title">Ingrediente ${cont}</h5>
            </div>
            <ul class="list-group list-group-flush">
            <li class="list-group-item list-group-item-success">Nombre: ${ingredients.name}</li>
            <li class="list-group-item list-group-item-success">Cantidad: ${ingredients.quantity}</li>
            <li class="list-group-item list-group-item-success">Unidades: ${ingredients.units}</li>
            </ul>`
}

function BuscarProducto(id, productos) {
    for (const producto of productos) {
        if (producto.id == id) {
            ht = Ver(producto.id, producto.name, producto.description, producto.cost, producto.price, producto.ingredients)
            Vista.innerHTML = ht;
        }
    }
}

inputJson.addEventListener('change', leerJSON)