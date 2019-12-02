
document.addEventListener("DOMContentLoaded", InsertarMain, false);
var lstaLugares=[];
var idPersona=-1;
function RellenarDNI(){
    var dni=document.getElementById('dni');
    const url = 'https://api.apirest.pe/api/getDni';
    const options = {};
    let json={
      "dni":dni.value
    }
     options.body=JSON.stringify(json);
     options.headers={
      "Content-Type": "application/json", 
      "Authorization": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6Ijk0OTU4OGE3NDBlZGE3NzY4YWRmYTUyNDM5MDgzY2Q5M2NmOTk5NjFiMzUyMDRhMDY3Zjk3MjE5NjNhOWZkYTM4NjVmMDU1NjU3ZTg3MzMyIn0.eyJhdWQiOiIxIiwianRpIjoiOTQ5NTg4YTc0MGVkYTc3NjhhZGZhNTI0MzkwODNjZDkzY2Y5OTk2MWIzNTIwNGEwNjdmOTcyMTk2M2E5ZmRhMzg2NWYwNTU2NTdlODczMzIiLCJpYXQiOjE1NzQxODMxMzgsIm5iZiI6MTU3NDE4MzEzOCwiZXhwIjoxODg5ODAyMzM4LCJzdWIiOiIzNDciLCJzY29wZXMiOlsiKiJdfQ.n4O5jlz6gUFYzEFG1xraZCUliiCXzvPNOlBMlHt7DAdvSR_kNRMHwuMtpWaeSZsW-7vrWmZzat0AvCeX1RfstT3ZkLkBjaebBO9TUjg1rcoQnPMSxilw85zsIaW0iKJnUKmcs3mXGg3a98KqGuOxuCU-IS0wRGuCac37rkuPdUOFc5nLR-pMzkf_bGxoEFuH5lH5gO4VPpidSkVOiTHmiMn52bnmIhuNA1zX25Gtixiulgys77stHTVhSw3SanaC5ua5Zh4_cSSqVUuoLQP8CZvehvZU9k1sdQ_e_tR0aYDc5E8eA1AodvwMHL8665u62NXcPJIxS0gXDhDJqDyZNe7YComt74p4ioGuwsD3W6dHhrg4KHAsChzmunyEx5ns5lQ9zScc8-TuD34phjqfRGdPHnGtONFFDkajNwtk_XPQ16byePGMymfvXkmIDF71p02QPdOh-QTvKdHPDnHrT-BhFnt6tT3jgwcV3Kq_zHb7UPSIz9YHGfBkIudLMrRw4Aa7MchBPlNpt5yHwoFRkbuZCeFP6XDPq6EeG22QA1MujvAAWXbZ2hR5Sb9J6cxrTQFuFohcDyDqfBdHIX-dKdeS5vbW8eec9JxP1YltKNLLenbPxCHCyBYD1NopOxcmGXLnWIx-pUjrSByttR2iuD_o8UUdjSqdkd9pWPd5dH8" 
    };
    options.method = 'POST';  

   fetch(url,options)
    .then(r => r.json())
    .then(data => {
        console.log( data );        
        var nombresApellidos=document.getElementById('nombresApellidos');
        nombresApellidos.value=data.result.NombreCompleto;
       })
    .catch(e => console.error( e) );
    
}
function InsertarMain(){
    var ruta="http://localhost:8081/lugares";
var tablaListaLugares=document.getElementById('tablaListaLugares');
tablaListaLugares.innerHTML='';
axios.get(ruta)
.then(data=>{
    lstaLugares=data.data;
    console.log(lstaLugares);
    for (var i=0;i<lstaLugares.length;i++){
        var cod_lugar=lstaLugares[i].lugarId;
        tablaListaLugares.innerHTML+=
        `<tr>  
           <td class="radio inlineblock m-r-20">
               <input type="radio"  name="lugarSel" id="personas${cod_lugar}" class="with-gap" value="${cod_lugar}"  >
               <label for="personas${cod_lugar}">        &nbsp                                                        
               </label>
           </td>                                                     
           <td>${lstaLugares[i].nlugar}</td>
           <td>${lstaLugares[i].distrito.provincia.departamento.ndepartamento}</td>
           <td>${lstaLugares[i].distrito.provincia.nprovincia}</td>
           <td>${lstaLugares[i].distrito.ndistrito}</td>
        </tr> `
    }
});
}

function SelLugar(){
    var lugarSel=document.querySelector('input[name="lugarSel"]:checked').value;
    var lugar=document.getElementById('lugar');
    for(var i=0;i<lstaLugares.length;i++){
        if (lstaLugares[i].lugarId==lugarSel){
            lugar.value=lstaLugares[i].nlugar;
        }
    }    
}

function RegistrarIngeniero(){
    var lugarSel=document.querySelector('input[name="lugarSel"]:checked').value;
    var telefono=document.getElementById('telefono').value;
    var nombreUsuario=document.getElementById('nombreUsuario').value;
    var nombresApellidos=document.getElementById('nombresApellidos').value;
    var password=document.getElementById('password').value;
    var dni=document.getElementById('dni').value;
    
   var ruta1='http://localhost:8081/personas';
   var ruta2='http://localhost:8081/empleados';
   
    
    axios({
        method:'post',
        url:ruta1,
        data:{       
           npersona:nombresApellidos,
           psw:password,
           nombreUsuario:nombreUsuario,
           lugar:{
               lugarId:lugarSel
           },
           numContacto:telefono,
        }
        }).then(function(){
            axios.get('http://localhost:8081/personas')
            .then(dato=>{
                var response=dato.data;console.log(response);
                 idPersona=response[response.length-1].personaId;

                 var ruta2='http://localhost:8081/empleados';
                 axios({
                     method:'post',
                     url:ruta2,
                     data:{   
                         empleadoId:"",
                         dni:dni,
                         estado:true,   
                         persona:{
                             personaId:idPersona
                         },            
                         latitud:-12.105002, 
                         longitud:-76.963580,
                     }
                     }).then(data=>{
                       window.location="./Manage-Engineer-Accounts.html";
                  })
            });
            
     })
    }
