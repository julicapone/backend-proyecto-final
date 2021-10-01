$(document).ready(function(){
    $("#update_paciente_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let pacienteId = $("#paciente_id").val();

        let formData = {
            id: $("#paciente_id").val(),
            nombre: $("#nombre").val(),
            apellido:  $("#apellido").val(),
            dni: $("#dni").val(),
            domicilio:  $("#domicilio").val(),
            fechaIngreso: $("#fecha").val()
        }

        console.log(formData)

            $.ajax({
                url: '/api/pacientes/',
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function () {
                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong>El odontólogo se actualizó</strong></div>'

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});

                    setTimeout(function (){
                        location.reload()
                    }, 1000);
                }()
            });
        } catch(error){
            console.log(error);
            alert(error);
        }
    });

    $(document).on("click", "table button.btn_id", function(){
        let id_of_button = (event.srcElement.id);
        let pacienteId = id_of_button.split("_")[2];

        $.ajax({
            url: '/api/pacientes/' + pacienteId,
            type: 'GET',
            success: function(response) {
                let paciente = response;
                $("#paciente_id").val(paciente.id);
                $("#nombre").val(paciente.nombre);
                $("#apellido").val(paciente.apellido);
                $("#dni").val(paciente.dni);
                $("#domicilio").val(paciente.domicilio);
                $("#fecha").val(paciente.fechaIngreso);
                $("#div_paciente_updating").css({"display": "block"});
            },
            error: function(error){
                console.log("Error: " + error);
                alert("Ocurrió un error inesperado");
            }
        });
    });
});