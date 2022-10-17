//clientes 
function verClientes(){
 //GET   
    $.ajax({
        url : 'http://129.151.107.191/api/Client/all',
        type : 'GET',
        dataType : 'json',
        success : function(ver) {
            let cs=ver.items;
            $("#listaClientes").empty();
            for(i=0;i<cs.length;i++){
                $("#listaClientes").append(cs[i].id+" <b>"+cs[i].name+"</b> "+cs[i].email+" "+cs[i].age);
                $("#listaClientes").append("<button onclick='borrarCliente("+cs[i].id+")'>Borrar</button><br>");
            }

        },
        error : function(xhr, status) {
           // alert('ha sucedido un problema');
        }
    });

}   

function guardarCliente(){
    let idCliente=$("#idCliente").val();
    let nombre=$("#nombreCliente").val();
    let mailCliente=$("#mailCliente").val();
    let edad=$("#edadCliente").val();

    let data={
        id:idCliente,
        name:nombre,
        email:mailCliente,
        age:edad
    };
    let dataToSend=JSON.stringify(data);
    //console.log(dataToSend);

    $.ajax({
        url : 'http://129.151.107.191/api/Client/save',
        type : 'POST',
        //dataType : 'json',
        data:dataToSend,
        contentType:'application/json',

        success : function(pepito) {
            $("#idCliente").val("");
            $("#nombreCliente").val("");
            $("#mailCliente").val("");
            $("#edadCliente").val("");

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete: function (){
            verClientes();
        }
    });


}
function editarCliente(){
    let idCliente=$("#idCliente").val();
    let nombre=$("#nombreCliente").val();
    let mailCliente=$("#mailCliente").val();
    let edad=$("#edadCliente").val();

    let data={
        id:idCliente,
        name:nombre,
        email:mailCliente,
        age:edad
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);

    $.ajax({
        url : 'http://129.151.107.191/api/Client/update',
        type : 'PUT',
        //dataType : 'json',
        data:dataToSend,
        contentType:'application/json',

        success : function(pepito) {
            $("#idCliente").val("");
            $("#nombreCliente").val("");
            $("#mailCliente").val("");
            $("#edadCliente").val("");

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete: function (){
            verClientes();
        }
    });
}
function borrarCliente(idCliente){

    let data={
        id:idCliente
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);

    $.ajax({
        url : 'http://129.151.107.191/api/Client/',
        type : 'DELETE',
        //dataType : 'json',
        data:dataToSend,
        contentType:'application/json',

        success : function(pepito) {
            $("#idCliente").val("");
            $("#nombreCliente").val("");
            $("#mailCliente").val("");
            $("#edadCliente").val("");

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete: function (){
            verClientes();
        }
    });
}



//Mision tic auditorio
function bringData(){
    $.ajax({
        url: "http://129.151.107.191/api/Audience/all",
        
        type: "GET",
        dataType: "json",
        success: function(data){
            showData(data.items);
        }
    })
}

function showData(items){
    $("#Outcome").empty();
    let tabla = "<table border CELLPADDING=5 CELLSPACING=5>"+ 
                "<CAPTION ALIGN = top><b>Registro de auditorios</b></CAPTION>"+
                "<tr>" + "<th>ID</th> <th>Owner</th> <th>Capacity</th> <th>Category ID</th> <th>Name</th> <th></th>" + "</tr>";
    for(let i = 0; i < items.length; i++) {

        tabla += "<tr>"; 
        tabla += "<td>" + items[i].id + "</td>";
        tabla += "<td>" + items[i].owner + "</td>";
        tabla += "<td>" + items[i].capacity + "</td>";
        tabla += "<td>" + items[i].category_id + "</td>";
        tabla += "<td>" + items[i].name + "</td>";

        tabla += "<td> <button onclick='borrarDatos(" + items[i].id + ")'> Eliminar </button>";
        tabla += "</tr>";
    }
    tabla += "</table>";
    $("#Outcome").append(tabla)
}

function borrarDatos(Id){
    let datos={
        id:Id
    };
    let dataToSend = JSON.stringify(datos);
    $.ajax({
        url: "http://129.151.107.191/api/Auditorio/all",
        
        type: "DELETE",
        data:dataToSend,
        contentType: "application/json",
        datatype: "json",
        success: function(data){
            $("#Outcome").empty();
            bringData();
            alert("Elemento eliminado con éxito!")
        }
    })
}

function saveData(){
    let datos = {
        id:$("#id").val(),
        owner:$("#owner").val(),
        capacity:$("#capacity").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val()

    };

    let dataToSend = JSON.stringify(datos); 
    $.ajax({

        url: "http://129.151.107.191/api/Audience/save",
        
        type: "POST",
        data: dataToSend,
        contentType: "application/json",
        dataType: "json",
        success: function(data){
            
        },  
        complete: function(){
            $("#Outcome").empty();
            $("#id").val("");
            $("#owner").val("");
            $("#capacity").val("");
            $("#category_id").val("");
            $("#name").val("");
            bringData();
            alert("Se ha guardado el dato!") 
        }
    })
}

function updateData(){
    let datos = {
        id:$("#id").val(),
        owner:$("#owner").val(),
        capacity:$("#capacity").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val(),

    };
    
    let dataToSend = JSON.stringify(datos); 
    $.ajax({

        url: "http://129.151.107.191/api/Client/update",
       
        type: "PUT",
        data:dataToSend,
        contentType: "application/json",
        dataType: "json",
        success: function(){
        },
        complete: function(){
            $("#Outcome").empty();
            $("#id").val("");
            $("#owner").val("");
            $("#capacity").val("");
            $("#category_id").val("");
            $("#name").val("");
            bringData();
            alert("Se ha actualizado con éxito!")   

        }
    })
}




// Mensajes 

function verMensaje(){
    //GET   
    $.ajax({
        url : "http://129.151.107.191/api/Message/all",
        type : 'GET',
        dataType : 'json',
        success : function(mensajes) {
            let cs=mensajes.items;
            $("#listaMensajes").empty();
            for(i=0;i<cs.length;i++){
                $("#listaMensajes").append(cs[i].id+" <b>"+cs[i].messagetext+"</b> ");
                $("#listaMensajes").append("<button onclick='borrarMensaje("+cs[i].id+")'>Borrar</button><br>");
            }

        },
        error : function(xhr, status) {
           
        }
    });
   
   }   
   
   function guardarMensaje(){
       let idMensaje=$("#idMensaje").val();
       let mensaje=$("#mensaje").val();
      
   
       let data={
           id:idMensaje,
           messagetext:mensaje,
           
       };
       let dataToSend=JSON.stringify(data);
       
   
       $.ajax({
           url : "http://129.151.107.191/api/Message/save",
           type : 'POST',
           data:dataToSend,
           contentType:'application/json',
   
           success : function(pepito1) {
               $("#idMensaje").val("");
               $("#mensaje").val("");
               
   
           },
           error : function(xhr, status) {
               alert('ha sucedido un problema');
           },
           complete: function (){
            verMensaje();
           }
       });
   
   
   }
   function editarMensaje(){
    let idMensaje=$("#idMensaje").val();
    let mensaje=$("#mensaje").val();
   
       let data={
        id:idMensaje,
        messagetext:mensaje,
       };
       let dataToSend=JSON.stringify(data);
       console.log(dataToSend);
   
       $.ajax({
           url : "http://129.151.107.191/api/Message/update",
           type : 'PUT',
           data:dataToSend,
           contentType:'application/json',
   
           success : function(pepito1) {
                $("#idMensaje").val("");
                $("#mensaje").val("");
   
           },
           error : function(xhr, status) {
               alert('ha sucedido un problema');
           },
           complete: function (){
            verMensaje();
           }
       });
   }
   function borrarMensaje(idMensaje){

    let data={
        id:idMensaje
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);

    $.ajax({
        url : 'http://129.151.107.191/api/Message/',
        type : 'DELETE',
        data:dataToSend,
        contentType:'application/json',

        success : function(pepito1) {
            $("#idMensaje").val("");
            $("#mensaje").val("");
            

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete: function (){
            verMensaje();
        }
    });
}