(function ($) {
    $(document).ready(function () {
        $.ajax({
            url: "/kolo/api/TipoDocumento",
            contentType: "application/json",
            method: "GET",
            dataType: "json"
        }).done(function (data) {
            console.log(data)
        }).fail(function (xhr, status, error) {
            throw error
        })

        $("[name=registroCliente]").on("submit", () => {
            let data = new FormData($(this))
            $.ajax({
                url: "/kolo/api/TipoDocumento",
                contentType: "application/json",
                method: "POST",
                dataType: "json",
                data: JSON.stringify(data)
            }).done(function (data) {
                console.log(data)
                alert("Usuario creado")
                window.location.href = "index.html"
            }).fail(function (xhr, status, error) {
                throw error
            })
        })
    })
})(jQuery)