(function ($) {
    $(document).ready(function () {
        $("[name=registroProveedor]").on("submit", function (e) {
            e.preventDefault()
            var datos = {};
            var formdata = $("[name=registroProveedor]").serializeArray();
            $(formdata).each(function (index, obj) {
                datos[obj.name] = obj.value;
            });
            debugger;

            $.ajax({
                url: "/kolo/api/Proveedor",
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

