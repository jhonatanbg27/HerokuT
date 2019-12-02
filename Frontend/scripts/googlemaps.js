var _objEmpleado=localStorage.getItem("objEmpleado")
var objEmpleado=JSON.parse(_objEmpleado);
console.log(objEmpleado.latitud);



function initMap() {
  
    // The location of the engineer
    var engineerposition = {lat: parseFloat(objEmpleado.latitud), lng: parseFloat(objEmpleado.longitud)};//con el axios obtener el dato por id, llama al valor latitud y longitud
    // The map, centered at the engineer
    var map = new google.maps.Map(
        document.getElementById('map'), {zoom: 17, center: engineerposition});
    // The marker, positioned at the engineer
    var marker = new google.maps.Marker({position: engineerposition, map: map});
  }