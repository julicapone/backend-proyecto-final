$(document).ready(function() {
    $("#add_new_odontologo").submit(function(evt) {
        evt.preventDefault();
        
        let formData = {
            nombre : $("#nombre").val(),
            apellido :  $("#apellido").val(),
            matricula: $("#matricula").val(),
        }

        $.ajax({
            url: '/api/odontologos/',
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false
        });
        
    });
});