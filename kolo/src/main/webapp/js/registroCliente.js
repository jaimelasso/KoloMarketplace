(function ($) {
    $(document).ready(function () {
        $.ajax({
            url: "/kolo/api/TipoDocumento",
            contentType: "application/json",
            method: "GET",
            dataType: "json"
        }).done(function (data) {
            data.forEach(function (tipoDocumento) {
                $("[name=tipoDocumento]").append("<option value=" + tipoDocumento.idTipoDocumento + ">" + tipoDocumento.tipoDocumento + "</option>")
            });
        }).fail(function (xhr, status, error) {
            throw error
        })

        $("[name=registroCliente]").on("submit", function (e) {
            e.preventDefault()
            var datos = {};
            var formdata = $("[name=registroCliente]").serializeArray();
            $(formdata).each(function (index, obj) {
                datos[obj.name] = obj.value;
            });
            debugger;

            $.ajax({
                url: "/kolo/api/Cliente",
                contentType: "application/json",
                method: "POST",
                dataType: "json",
                data: JSON.stringify(datos)
            }).done(function (data) {
                debugger;
                console.log(data)
                alert("Usuario creado")
                window.location.href = "index.html"
            }).fail(function (xhr, status, error) {
                throw error
            })
        })
    })
})(jQuery)