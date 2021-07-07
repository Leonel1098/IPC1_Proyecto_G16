const inputJson = document.getElementById('inputJson')
const divTodosUsers = document.getElementById('TodosUsers')

function leerJSON() {
    const fileReader = new FileReader()

    function miOnLoad() {
        const json = JSON.parse(fileReader.result)
        localStorage.setItem("useres",JSON.stringify(json))
        const f =  JSON.parse(localStorage.getItem( "useres" ))
        crearTarjetas(f)  
    }

    fileReader.readAsText(inputJson.files[0])
    fileReader.onload = miOnLoad
}

function crearTarjetas(users) {
    let html = ''
    for (const usuario of users) {
        html += crearTarjeta(usuario)
    } 
    divTodosUsers.innerHTML = html;
}

function crearTarjeta(usuario) {
    let html = `
        <div class="card mb-4 text-white bg-primary" style="width: 18rem;">
        <div class="card-body">
        <h5 class="card-title">${usuario.username}</h5>
        </div>
        <ul class="list-group list-group-flush">
        <li class="list-group-item list-group-item-info">Password: ${usuario.password}</li>
        </ul>
        <div class="card-body">
        </div>
        </div>`
        return html
}

if(location.reload){
    const f =  JSON.parse(localStorage.getItem( "useres" ))
    if(f != null){
        crearTarjetas(f)
        //localStorage.removeItem("useres",JSON.stringify(f))

    }         
}

inputJson.addEventListener('change', leerJSON)