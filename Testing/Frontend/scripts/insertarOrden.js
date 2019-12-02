document.addEventListener("DOMContentLoaded", InsertarMain, false);
var lstaIngenieros=[];
var lstaHospitales=[];
var lstaEjemplares=[];
function InsertarMain(){
    //PARA INGENIEROS
    var ruta="http://localhost:8081/empleados";
    var tablaListaIng=document.getElementById('tablaListaIng');
    tablaListaIng.innerHTML='';
    axios.get(ruta)
    .then(data=>{
        lstaIngenieros=data.data;
        console.log(lstaIngenieros);
        for (var i=0;i<lstaIngenieros.length;i++){
            var cod_ingeniero=lstaIngenieros[i].empleadoId;
            tablaListaIng.innerHTML+=
            `<tr>  
               <td class="radio inlineblock m-r-20">
                   <input type="radio"  name="listaingenieros" id="ingeniero${cod_ingeniero}" class="with-gap" value="${cod_ingeniero}"  >
                   <label for="ingeniero${cod_ingeniero}">        &nbsp                                                        
                   </label>
               </td>                                                     
               <td>${lstaIngenieros[i].persona.npersona}</td>
               <td>${lstaIngenieros[i].persona.numContacto}</td>
               <td>${lstaIngenieros[i].persona.lugar.nlugar}</td>
            </tr> `
        }
    });
//PARA HOSPITALES
   var ruta2="http://localhost:8081/clientes";
   var tablaListaHosp=document.getElementById('tablaListaHosp');
   tablaListaHosp.innerHTML='';
   axios.get(ruta2)
    .then(data=>{
        lstaHospitales=data.data;
        console.log(lstaHospitales);
        for (var i=0;i<lstaHospitales.length;i++){
            var cod_hosp=lstaHospitales[i].clienteId;
            tablaListaHosp.innerHTML+=
            `<tr>  
               <td class="radio inlineblock m-r-20">
                   <input type="radio"  name="listahospitales" id="hospital${cod_hosp}" class="with-gap" value="${cod_hosp}"  >
                   <label for="hospital${cod_hosp}">        &nbsp                                                        
                   </label>
               </td>                                                     
               <td>${lstaHospitales[i].persona.npersona}</td>
               <td>${lstaHospitales[i].persona.numContacto}</td>
               <td>${lstaHospitales[i].persona.lugar.nlugar}</td>
            </tr> `
        }
    });
//PARA EJEMPLARES
var ruta3="http://localhost:8081/ejemplares";
var tablaListaEjem=document.getElementById('tablaListaEjem');
axios.get(ruta3)
 .then(data=>{
    lstaEjemplares=data.data;
     console.log(lstaEjemplares);
     for (var i=0;i<lstaEjemplares.length;i++){
         var cod_ejem=lstaEjemplares[i].ejemplarId;
         tablaListaEjem.innerHTML+=
         `<tr>  
            <td class="radio inlineblock m-r-20">
                <input type="radio"  name="listaejemplares" id="ejemplar${cod_ejem}" class="with-gap" value="${cod_ejem}"  >
                <label for="ejemplar${cod_ejem}">&nbsp                                                        
                </label>
            </td>                                                     
            <td>${lstaEjemplares[i].nejemplar}</td>
            <td>${lstaEjemplares[i].modelo.serieModelo}</td>
            <td>${lstaEjemplares[i].modelo.equipo.nequipo}</td>
         </tr> `
     }
 });
}

function RegistrarOrden(){
    
    var ruta='http://localhost:8081/ordenes';
    var fechaGenerada=document.getElementById('fechaGenerada').value; 
    var fechaEjecutada=document.getElementById('fechaEjecutada').value;
    var listaingenieros=document.querySelector('input[name="listaingenieros"]:checked').value;
    var listaejemplares=document.querySelector('input[name="listaejemplares"]:checked').value;
    var listahospitales=document.querySelector('input[name="listahospitales"]:checked').value;      
     axios({
         method:'post',
         url:ruta,
         data:{       
             empleado:{
                 empleadoId:listaingenieros
             }  ,  
             cliente:{
                 clienteId:listahospitales
             }    ,
             fechaGeneracion:fechaGenerada,
             fechaEjecucion:fechaEjecutada,
             nservicio:'gg2222',
             ejemplar:{
                 ejemplarId:listaejemplares
             },
             numPuntaje:1,
         }
         }).then(data=>{
           window.location="./admin_view_service.html";
      })
}
function SelEjemplar(){
    var listaejemplares=document.querySelector('input[name="listaejemplares"]:checked').value;
    var nombreEjemplar=document.getElementById('nombreEjemplar');
    for(var i=0;i<lstaEjemplares.length;i++){
        if (lstaEjemplares[i].ejemplarId==listaejemplares){
            nombreEjemplar.value=lstaEjemplares[i].nejemplar;
        }
    }    
}

function SelHospital(){
    var listahospitales=document.querySelector('input[name="listahospitales"]:checked').value;
    var nombreHospital=document.getElementById('nombreHospital');
    for(var i=0;i<lstaHospitales.length;i++){
        if (lstaHospitales[i].clienteId==listahospitales){
            nombreHospital.value=lstaHospitales[i].persona.npersona;
        }
    }
}

function SelIngeniero(){   
    var listaingenieros=document.querySelector('input[name="listaingenieros"]:checked').value;    
    var nombreIngeniero=document.getElementById('nombreIngeniero');
    for(var i=0;i<lstaIngenieros.length;i++){
        if (lstaIngenieros[i].empleadoId==listaingenieros){
            nombreIngeniero.value=lstaIngenieros[i].persona.npersona;
        }
    }    
}

