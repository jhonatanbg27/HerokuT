document.addEventListener("DOMContentLoaded", InsertarReporteMain, false);
var lstaServicios=[];
var puntuacion=-1;
var OrdenSelecionada=-1;
function InsertarReporteMain(){
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
            if (lstaServicios[i].estadoFinalizado==false){
                var cod_Orden=lstaServicios[i].ordenId;
                contTablaServicios.innerHTML+=`
                <tr>
                    <td class="radio inlineblock m-r-20">
                    <input type="radio"  name="ordenSel" id="orden${cod_Orden}" class="with-gap" value="${cod_Orden}"  >
                    <label for="orden${cod_Orden}">&nbsp                                                        
                    </label>
                </td>      
                <td>${cod_Orden}</td>
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
    });


    var puntuaciones=document.getElementById('puntuaciones');
    puntuaciones.innerHTML='';
    puntuaciones.innerHTML=
    `<a onclick="RegPuntuacion('1')" class="icon" >
          <i class="zmdi zmdi-star-outline" >                                            
          </i>
      </a>
      <a onclick="RegPuntuacion('2')" class="icon" >
          <i class="zmdi zmdi-star-outline">                                            
          </i>
      </a>
      <a onclick="RegPuntuacion('3')" class="icon" >
          <i class="zmdi zmdi-star-outline">                                            
          </i>
      </a>
      <a onclick="RegPuntuacion('4')" class="icon" >
          <i class="zmdi zmdi-star-outline">                                            
          </i>
      </a>
      <a onclick="RegPuntuacion('5')" class="icon" >
          <i class="zmdi zmdi-star-outline">                                            
          </i>
      </a>`;
}


function RegPuntuacion(puntos){
    puntos=Number(puntos);
 puntuacion=Number(puntos);
 var puntuaciones=document.getElementById('puntuaciones');
 puntuaciones.innerHTML='';
 for (var i=0;i<puntos;i++){
    puntuaciones.innerHTML+=`
    <a onclick="RegPuntuacion('${i+1}')" class="icon" >
          <i class="zmdi zmdi-star" >                                            
          </i>
    </a>`;
 }
 for (var i=puntos;i<5;i++){
    puntuaciones.innerHTML+=`
    <a onclick="RegPuntuacion('${i+1}')" class="icon" >
          <i class="zmdi zmdi-star-outline" >                                            
          </i>
    </a>`;
 }
}

function RegReporteFinal(){
    var ordenSel=document.querySelector('input[name="ordenSel"]:checked').value;
    
    for (var i=0;i<lstaServicios.length;i++){
        if (lstaServicios[i].ordenId==ordenSel){
            OrdenSelecionada=lstaServicios[i];
            OrdenSelecionada.numPuntaje=puntuacion;
            OrdenSelecionada.fechaFinalizacion='2019-12-03';
            OrdenSelecionada.estadoFinalizado=true;
        }
    }
    var ruta='http://localhost:8081/ordenes';
    axios({
        method:'post',
        url:ruta,
        data:OrdenSelecionada,
        }).then(data=>{
          window.location="./admin_view_final_report.html";
     });
}
