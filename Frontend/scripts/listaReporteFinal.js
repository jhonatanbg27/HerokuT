document.addEventListener("DOMContentLoaded", indexMain, false);
var lstaServicios=[];

function HtmlPuntaje(puntos){
    var puntuaciones=``;
    for (var i=0;i<puntos;i++){
        puntuaciones+=`
        <a  class="icon" >
              <i class="zmdi zmdi-star" >                                            
              </i>
        </a>`;
     }
     for (var i=puntos;i<5;i++){
        puntuaciones+=`
        <a  class="icon" >
              <i class="zmdi zmdi-star-outline" >                                            
              </i>
        </a>`;
     }

     return puntuaciones;
}
function indexMain(){
    var _objUsuario=localStorage.getItem("usuario");
    var objUsuario=JSON.parse(_objUsuario);
    console.log(objUsuario);
    var contTablaServicios=document.getElementById('contTablaServicios');
   

    axios.get('http://localhost:8081/ordenes')
    .then(data=>{
        var rpta=data.data;
        lstaServicios=rpta;
        console.log(data.data);

      //  var imgUsuario=document.getElementById('imgUsuario');  
       // imgUsuario.innerHTML=`<img src="${objUsuario.imagenRuta}">`;
        
        for (var i=0;i<rpta.length;i++){  
              
            var puntos=Number(lstaServicios[i].numPuntaje);
            var htmlputanje= HtmlPuntaje(puntos);
           console.log(htmlputanje);
         
            if (lstaServicios[i].estadoFinalizado==true){
                contTablaServicios.innerHTML+=`<tr>
                <th scope="row">${lstaServicios[i].ordenId}</th>    

                <td>${lstaServicios[i].cliente.persona.npersona}</td>
                <td>${lstaServicios[i].empleado.persona.npersona}</td>
                <td>${lstaServicios[i].fechaFinalizacion}</td>                     
                <td>${lstaServicios[i].ejemplar.nejemplar}</td>
                <td>${htmlputanje}</td>


                        
                <td>
                    <a href="form-validation.html" button class="btn btn-primary btn-sm"><i class="zmdi zmdi-edit"></i></button></a>
                    <a button class="btn btn-danger btn-sm"> <i class="zmdi zmdi-delete" ></i></button></a>
                </td>
                </tr>`;
            }  
           
        }
    });
}


function BuscarIngeniero(){
    var contTablaServicios=document.getElementById('contTablaServicios');
    contTablaServicios.innerHTML=""
    var filtroingeniero=String(document.getElementById('filtroingeniero').value);
    filtroingeniero=filtroingeniero.toLowerCase();    
    var filtrohospital=String(document.getElementById('filtrohospital').value);
    filtrohospital=filtrohospital.toLowerCase();   

    var filtrofechainicio=document.getElementById('filtrofechainicio').value;
    var filtrofechafin=document.getElementById('filtrofechafin').value;

    for (var i=0;i<lstaServicios.length;i++){     
        var nIngeniero=String(lstaServicios[i].empleado.persona.npersona);        
        nIngeniero=nIngeniero.toLowerCase();
        var nhospital=String(lstaServicios[i].cliente.persona.npersona);
        nhospital=nhospital.toLowerCase();        
    
        if (nhospital.includes(filtrohospital) && nIngeniero.includes(filtroingeniero)  ){          
            contTablaServicios.innerHTML+=`<tr>
            <th scope="row">${lstaServicios[i].ordenId}</th>    
            <td>${lstaServicios[i].cliente.persona.npersona}</td>
            <td>${lstaServicios[i].ejemplar.nejemplar}</td>          
            <td>${lstaServicios[i].empleado.persona.npersona}</td>
            <td>${lstaServicios[i].fechaGeneracion}</td>
            <td>${lstaServicios[i].fechaEjecucion}</td>            
            <td>
                <a href="form-validation.html" button class="btn btn-primary btn-sm"><i class="zmdi zmdi-edit"></i></button></a>
                <a button class="btn btn-danger btn-sm"> <i class="zmdi zmdi-delete" ></i></button></a>
            </td>
            </tr>`;
        }
       
    }
}

function LimpiarCampos(){
    var filtroingeniero=document.getElementById('filtroingeniero');
    filtroingeniero.value="";
    var filtrohospital=document.getElementById('filtrohospital');
    filtrohospital.value="";
    var filtrofechainicio=document.getElementById('filtrofechainicio').value;
    var filtrofechafin=document.getElementById('filtrofechafin').value;
    BuscarIngeniero();
    
}