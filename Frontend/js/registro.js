/**
 * Cargar la libreria de Jquery y ubicar el cursor en el campo de login
*/
$(document).ready(function () {
    estadoInicial();
});



/**
 * intenta autenticar al usuario en la aplicación
 */
function registrar() {
    //capturar los datos ingresados por el usuario

    let name = $("#name").val();
    let email = $("#email").val();
    let password = $("#password").val();
    let repeat_password = $("#Repeat-password").val();

    let datos = {
        
        email: $("#email").val(),
        password: $("#password").val(),
        name: $("#name").val()
        
    }
    let datosPeticion = JSON.stringify(datos);

    //utilizo la función de Jquery para hacer un llamado asincrono a un ws

    $.ajax({
        method: "POST",
        //url del servicio
        url: "http://localhost:8074/api/user/new",
        //envío datos capturados por el usuario a la petición
        data: datosPeticion,
        //tipo de contenido
        dataType: "json",
        contentType: "application/JSON",
        //tipo de petición
       
        

        // success: acciones si todo sale ok
        success: function (respuesta) {
            //escribe en la consola para efectos de depuración
            console.log(respuesta);
            resultadoRegistro(respuesta);
        },
        // error: acciones si sale error
        error: function (xhr, status) {
            console.log("algo falló");
        },

        complete: function (xhr, status) {
            console.log("todo super bien " + status)
            
        }

    })

}

/**
 * 
 * Valida si en el id viene un dato nulo o viene el código del usuario
 * Configura mensaje de bienvenidad o de error según el caso
 */
function resultadoRegistro(respuesta) {
    let id = respuesta.id;
    let name = respuesta.name;
    if (id == null) {

        $("#mensaje").html("Usuario no registrado : " + name)
    }
    else {

        $("#mensaje").html("Usuario : " + id + " " + name)
    }
    $("#mensaje").show();
}

function estadoInicial() {
    $("#name").focus();
    $("#mensaje").hide();

}
