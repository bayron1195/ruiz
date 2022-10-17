$(document).ready(function (){
    getCategoryList();
    getAudience();
});

function getFrontAudienceData(){
    let k={
        id:$("#idAudience").val(),
        name:$("#nameAudiencey").val(),
        capacity:$("#capacityAudience").val(),
        target:$("#targetAudience").val(),
        description:$("#descriptionAudience").val(),
        category:{
            id:$("#categorySelect").val()
        }
    }
    return k;
}
function cleanFields(){
    $("#idAudience").val("");
    $("#nameAudience").val("");
    $("#capacityLAudience").val("");
    $("#targetAudience").val("");
    $("#descriptionAudience").val("");
    $("#categorySelect").val("").change();
}


function getCategoryList(){
    $.ajax({
        url : "api/Category/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#categorySelect").empty();
            for(let i=0;i<p.length;i++){
                let s=`
                    <option value="${p[i].id}">${p[i].name}</option>                
                `;
                $("#categorySelect").append(s);

            }

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function saveAudience(){
    let data=getFrontAudienceData();
    data.id=null;
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Audience/save",
        type : 'POST',
        dataType : 'json',
        contentType:'application/json',
        data:dataToSend,
        success : function(p) {
            console.log(p);
            cleanFields();
            getLibs();

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function getLibs(){
    $.ajax({
        url : "api/Audience/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#results").empty();
            let l="";
            for (let i=0;i<p.length;i++){
                l+=`<div class="col">
                        <div class="card"><div class="card-header">
                                    <h5 class="card-title">${p[i].name}</h5>
                                </div>
                                <div class="card-body">
                                    <p class="card-text">${p[i].description}</p>
                                    <p class="card-text">Capacidad: ${p[i].capacity}</p>
                                    <p class="card-text">Objetivo: ${p[i].target}</p>
                                    <p class="card-text">Categoria: ${p[i].category.name}</p>
                                </div>
                                <div class="card-footer">
                                      <div class="btn-group" role="group">
                                        <button type="button" class="btn btn-outline-primary" onclick='getLibById(${p[i].id})'>Actualizar</button>
                                        <button type="button" class="btn btn-outline-primary" onclick='deleteLibById(${p[i].id})'>Borrar!</button>
                                    </div>
                                
                                </div>
                        </div>
                    </div>
                    `;
            }
            $("#results").append(l);
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });

}
function getLibById(idLib){
    $(".saveButtonJL").hide();
    $(".updateButtonJL").show();
    $.ajax({
        url : "api/Audience/"+idLib,
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#idAudience").val(p.id);
            $("#nameAudience").val(p.name);
            $("#capacityAudience").val(p.capacity);
            $("#targetAudience").val(p.target);
            $("#descriptionAudience").val(p.description);
            $("#categorySelect").val(p.category.id).change();

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });

}
function updateAudience(){
    let data=getFrontLibData();

    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Audience/update",
        type : 'PUT',
        dataType : 'json',
        contentType:'application/json',
        data:dataToSend,
        success : function(p) {
            console.log(p);
            cleanFields();
            getLibs();
            $(".saveButtonJL").show();
            $(".updateButtonJL").hide();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function cancelUpdateLib(){
    cleanFields();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}
function deleteLibById(idLib){
    $.ajax({
        url : "api/Audience/"+idLib,
        type : 'DELETE',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            getLibs();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });

}