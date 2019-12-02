document.addEventListener("DOMContentLoaded", listarIngMain, false);
var lstaIngenieros=[];
function listarIngMain(){

    var ruta="http://localhost:8081/empleados";
    var contTablaIngenieros=document.getElementById('contTablaIngenieros');
    contTablaIngenieros.innerHTML='';
    axios.get(ruta)
    .then(data=>{
        lstaIngenieros=data.data;
        console.log(lstaIngenieros);
        for (var i=0;i<lstaIngenieros.length;i++){
            var cod_ingeniero=lstaIngenieros[i].empleadoId;
            contTablaIngenieros.innerHTML+=
            `<tr class="bg-purple">           
                <td>${lstaIngenieros[i].persona.npersona}</td>
                <td>${lstaIngenieros[i].dni}</td>    
                <td>${lstaIngenieros[i].persona.numContacto}</td>    
                <th>
                     <!--La misma pagina default de ver la ubicacion del ingeniero--> 
                    <a href="engineer_ubication.html" onclick="ObtenerEmpleado(${cod_ingeniero})" class="btn btn-neutral waves-effect waves-light-green">Ubication</a></td>
                </th>
            </tr>`
        }
    });
}

function ObtenerEmpleado(empleadoId){
    var objEmpleado={};
    for (var i=0;i<lstaIngenieros.length;i++){
        if (lstaIngenieros[i].empleadoId==Number(empleadoId)){
            objEmpleado=lstaIngenieros[i];
            break;
        }
    }

   localStorage.setItem("objEmpleado", JSON.stringify(objEmpleado));//CONVIERTE EL OBJETO EN UN STRING          
}
