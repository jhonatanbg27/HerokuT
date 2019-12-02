//document.addEventListener("DOMContentLoaded", loginMain, false);

function loginMain(){

    var username=document.getElementById("username").value;
     var psw=document.getElementById("psw").value;     
     var ruta="http://localhost:8081/personas/"+String(username)+"/"+String(psw);
     axios.get(ruta)
     .then(data=>{
         var rpta=data.data;     
         if (rpta.personaId!=-1){
             localStorage.setItem("usuario", JSON.stringify(rpta));
             window.location.href="./admin_view_service.html"; 
         }else{
             alert("Usuario o contraseña incorrecto");
         }
     });
}