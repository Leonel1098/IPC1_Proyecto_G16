const inputJson = document.getElementById('inputJson')
const divInvo = document.getElementById('Invoi')

function leerJSON() {
    const fileReader = new FileReader()

    function miOnLoad() {
        const json = JSON.parse(fileReader.result)
        localStorage.setItem("invo", JSON.stringify(json))
        const f = JSON.parse(localStorage.getItem("invo"))
        const g = JSON.parse(localStorage.getItem("clientesS"))
        crearTarjetas(f, g)
        montostotales(f)
        toptotal(f)
    }

    fileReader.readAsText(inputJson.files[0])
    fileReader.onload = miOnLoad
}

function crearTarjetas(invoices, clientes) {
    let html = ''
    var tot = 0;
    for (var i = 0; i < invoices.length; i++) {
        for (var j = 0; j < clientes.length; j++) {
            if (invoices[i].client == clientes[j].id) {
                for (var k =0; k<invoices[i].products.length; k++) {
                    tot += invoices[i].products[k].price
                }
                html += crearTarjeta(invoices[i], clientes[j], tot)
                //PARA LA FUNCION BUSCAR POR RANGO 
                fechas.push(invoices[i])
                G_clients.push(clientes[j])

                Nuevainvo(invoices[i], clientes[j], tot)
                tot = 0
            }
        }
    }
    divInvo.innerHTML = html;
}

function crearRes(invoices) {
    let html = ''
    for (const inv of invoices) {
        html += crearRefresh(inv)
    }
    divInvo.innerHTML = html;
}


function crearTarjeta(invoices, clientes, tot) {
    let html = `
        <div class="card mb-4 text-white bg-primary" style="width: 18rem;">
        <div class="card-body">
        <h5 class="card-title">${invoices.id}</h5>
        </div>
        <ul class="list-group list-group-flush">
        <li class="list-group-item list-group-item-info">Cliente: ${clientes.name}</li>
        <li class="list-group-item list-group-item-info">Fecha: ${invoices.date}</li>
        <li class="list-group-item list-group-item-info">Total: ${tot}</li>
        </ul>
        <div class="card-body">
        <a><button type="button" class="btn-ver btn btn-warning">Ver</button></a>
        </div>
        </div>`
    return html
}

function crearRefresh(invoices) {
    let html = `
        <div class="card mb-4 text-white bg-primary" style="width: 18rem;">
        <div class="card-body">
        <h5 class="card-title">${invoices.id}</h5>
        </div>
        <ul class="list-group list-group-flush">
        <li class="list-group-item list-group-item-info">Cliente: ${invoices.cliente}</li>
        <li class="list-group-item list-group-item-info">Fecha: ${invoices.fecha}</li>
        <li class="list-group-item list-group-item-info">Total: ${invoices.total}</li>
        </ul>
        <div class="card-body">
        <a a href="VistaFacturas.html"><button type="button" class="btn-ver btn btn-warning">Ver</button></a>
        </div>
        </div>`
    return html
}

function BuscarCliente(invoices, clientes) {

}


if (location.reload) {
    const g = JSON.parse(localStorage.getItem("fc"))
    if (g != null) {
        crearRes(g)
        //localStorage.removeItem("invo",JSON.stringify(f))
    }
}

var cajita = [];
var cajita2 = [];
var cajita3 = [];
var totalitario = 0;
function  montoporcliente(products) {
    for (const i of products) {
        totalitario+=i.price
            
    }
    cajita.push(totalitario)
    totalitario = 0;

}
function montostotales(invoices) {
    for (const j of invoices) {
        montoporcliente(j.products)
         cajita2.push(j.client)
    }

    var nombre = JSON.parse(localStorage.getItem("clientesS"));
        var temp;
        var temp2;


      t = true
            while (t==true)
            {
                t = false;
                for (var i = 1; i<cajita.length;i++)
                {
                    if (cajita[i]>cajita[i-1]){
                        temp = cajita[i];
                        cajita[i]=cajita[i-1];
                        cajita[i-1]=temp;
                        /////////////
                         temp2 = cajita2[i];
                        cajita2[i]=cajita2[i-1];
                        cajita2[i-1]=temp2;
                        t=true;
                    }
                }
                if (t==false) {

                  break;
                }
            }

            nombresordenados(nombre)
            var cont = 0;
            for (var i =0; i<cajita2.length;i++) {
                cont = 0
                for (var j = 0; j<cajita2.length;j++) {
                    if (cajita2[i]==cajita2[j]) {
                        cont++
                        if (cont>1) {
                            cajita[i]+=cajita[j]
                            cajita.splice(j,1)
                            cajita2.splice(j,1)
                            cajita3.splice(j,1)
                        }
                    }
                }
            }


localStorage.setItem("montoordenado",JSON.stringify(cajita))
localStorage.setItem("idordenado",JSON.stringify(cajita2))
localStorage.setItem("nombreordenado",JSON.stringify(cajita3))
   
}
function nombresordenados(clientes)
{
    for (const p of cajita2) {
        for (const j of clientes) {
            if (p == j.id) {cajita3.push(j.name)}
        }
    }

}


var Facturas = [];
function Nuevainvo(invoices, clientes, tot){
    var venta ={
        id: invoices.id,
        cliente: clientes.name,
        fecha: invoices.date,
        total: tot
    };
    Facturas.push(venta)
    localStorage.setItem('fc', JSON.stringify(Facturas));
}

var IndiF = [];
function NuevaIndi(invoices, clientes, tot, productos){
    var I ={
        id: invoices.id,
        clienteid: clientes.id,
        clientenombre: clientes.name,
        clientedireccion:clientes.address,
        clientephone: clientes.phone,
        clientenit: clientes.nit,
        fecha: invoices.date,
        total: tot,   
        products: [productos]     
    };
    IndiF.push(I)
    localStorage.setItem('infiF', JSON.stringify(IndiF));
    IndiF.pop(I)
}

const on = (element, event, selector, handler) => {
    console.log(handler)
    element.addEventListener(event, e => {
        if (e.target.closest(selector)) {
            handler(e)
        }
    })
}


on(document, 'mouseover', '.btn-ver', e => {
    const tarjeta = e.target.parentNode.parentNode.parentNode
    const divt = tarjeta.firstElementChild
    const id = divt.firstElementChild.innerHTML
    const facturas = JSON.parse(localStorage.getItem("invo"))
    const clientes = JSON.parse(localStorage.getItem("clientesS"))
    AlmacenarFactura(id, facturas, clientes)
})


function AlmacenarFactura(id, facturas, clientes) {
    var tot=0;
    for (var i = 0; i < facturas.length; i++) {
       if(id==facturas[i].id){
        for (var j = 0; j < clientes.length; j++) {
            if (facturas[i].client == clientes[j].id) {
                for(var k=0; k<facturas[i].products.length; k++){
                    tot += facturas[i].products[k].price
                }
                NuevaIndi(facturas[i], clientes[j], tot, facturas[i].products)
                tot = 0;
            }
        }
       }
    }
}


var fechas = [];
var G_clients=[];
function FacturasRangosFechas(){
    //Rango de Fechas 
    // obtener fechas del imput 
    var RangoFechas=[];
    var d= document.getElementById("d").value;    
    var m= document.getElementById("m").value; 
    var a= document.getElementById("a").value; 

    var df= document.getElementById("df").value;    
    var mf= document.getElementById("mf").value; 
    var af= document.getElementById("af").value; 
    console.log(d,"-",m,"-",a)
    console.log(df,"-",mf,"-",af)
   
    
    
    //Pasar el imput a tipo Fecha
 
    var fecha1=(a+'-'+m+'-'+d);
    console.log(fecha1)
    
    var fecha2=(af+'-'+mf+'-'+df);
    var fe1=new Date(fecha1);
    fe1.setHours(0,0,0,0);
    var fe2=new Date(fecha2);
    fe2.setHours(0,0,0,0);

    
    //Se llena con las fehcas de json un var Rango de Fechas para compararlo
     for (let i = 0; i < fechas.length; i++) {
        var f1 = new Date(fechas[i].date); 
        f1.setHours(0,0,0,0);
        RangoFechas.push(f1)     
    }
    //Ordenamiento de Rango de Fechas de mayor a menor 
    var n, i, k, aux;
    n = RangoFechas.length;
    // Mostramos, por consola, la RangoFechas desordenada
    // Algoritmo de burbuja
    for (k = 1; k < n; k++) {
        for (i = 0; i < (n - k); i++) {
            if (RangoFechas[i].getTime() > RangoFechas[i + 1].getTime()) {
                aux = RangoFechas[i];
                RangoFechas[i]= RangoFechas[i + 1];
                RangoFechas[i + 1] = aux;
            }
        }
    }
    //var conparar para comparar si esta en el rango o no
    var conparar=[];
    for (let x = 0; x < RangoFechas.length; x++) {
        
        if ((RangoFechas[x].getTime()>=fe1.getTime())&&(RangoFechas[x].getTime()<=fe2.getTime())) {
            conparar[x]=RangoFechas[x].toDateString()
            
            
        }
    }
    //Revicion si conparar va a estar en el rango de fechas 
    //Busca la fecha y la muestra 
    var lasqueestan=[];
    for (let i = 0; i < fechas.length; i++) {
        //pasa a doto tipo fecha para compararlo 
        var comparar = new Date(fechas[i].date); 
        comparar.setHours(0,0,0,0);
        
       //Recorre el arreglo para comparar los dos
        for (let j = 0; j < RangoFechas.length; j++) {
            //encuenta el dato y lo muestra
            if (comparar.toDateString()==conparar[j]) {
                //Aqui se debe crear la targenta 
                //los datos de fecha son todos los de invoices de la carga del Json 
                // en metodo Crear Targetas se pushan  las fechas ---> fechas.push(invoices[i])
                console.log(fechas[i])
                lasqueestan.push(fechas[i])
                console.log("Se Crea la targeta  ")
                console.info("id ",fechas[i].id)
            
                console.info("fecha ",fechas[i].date)


                
                
              
            }
            
        }
          
    }
    let html = ''
    var tot = 0;
    for (var i = 0; i < lasqueestan.length; i++) {
        for (var j = 0; j < 1; j++) {
            console.log("Cliente es --->",lasqueestan[i].client)
            if (lasqueestan[i].client == G_clients[j].id) {
                for (var k =0; k<lasqueestan[i].products.length; k++) {
                    tot += lasqueestan[i].products[k].price

                }
                    console.log("SE Crea una Nueva TArgeta",lasqueestan[i])
                    html += crearTarjeta(lasqueestan[i], G_clients[j], tot)
             


                tot = 0
                
            }
        }
    }
    
    divInvo.innerHTML = html;
}


var cajitat = [];
var cajitat2 = [];
function  toptito(products) {
    for (const i of products) {
        var conttt = 0;
        for (const j of products) {
            if (i.name==j.name) {
                conttt++
            }
           
        }
         cajitat.push(conttt)
         console.log(conttt)
         cajitat2.push(i.name)      
    }
    console.log(cajitat2[0])  
    console.log(cajitat2[1])  
    console.log(cajitat2[2])  
    console.log(cajitat2[3]) 
    console.log(cajitat2[4])  
    console.log(cajitat2[5]) 
    console.log(cajitat2[6]) 
    
    console.log(cajitat[0])  
    console.log(cajitat[1])  
    console.log(cajitat[2])  
    console.log(cajitat[3]) 
    console.log(cajitat[4])  
    console.log(cajitat[5]) 
    console.log(cajitat[6]) 

}
function toptotal(invoices) {
    for (const j of invoices) {
        toptito(j.products)
    }

        var tempt;
        var tempt2;
     
            var contt = 0;
            for (var i =0; i<cajitat2.length;i++) {
                contt = 0
                for (var j = 0; j<cajitat2.length;j++) {
                    if (cajitat2[i]==cajitat2[j]) {
                        contt++
                        if (contt>1) {
                            cajitat[i]+=cajitat[j]
                            cajitat.splice(j,1)
                            cajitat2.splice(j,1)
                           
                        }
                    }
                }
            }
             h = true
            
             while (h==true)
            {
                h = false;
                for (var i = 1; i<cajitat.length;i++)
                {
                    if (cajitat[i]>cajitat[i-1]){
                        tempt = cajitat[i];
                        cajitat[i]=cajitat[i-1];
                        cajitat[i-1]=tempt;
                        /////////////
                         tempt2 = cajitat2[i];
                        cajitat2[i]=cajitat2[i-1];
                        cajitat2[i-1]=tempt2;
                        h=true;
                    }
                }
                if (h==false) {

                  break;
                }
            }



localStorage.setItem("ventatotaldeproducto",JSON.stringify(cajitat))
localStorage.setItem("nombredelproductovendido",JSON.stringify(cajitat2))   
}






inputJson.addEventListener('change', leerJSON)