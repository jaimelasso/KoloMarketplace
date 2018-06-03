(function ($) {
    $(document).ready(function () {
        $("#registro").on("click", function (e) {
            window.location.href = "registroCliente.html"
        })

        $("[name=login]").on("submit", function (e) {
            e.preventDefault()
            $.ajax({
                url: "/kolo/api/Cliente",
                contentType: "application/json",
                method: "GET",
                dataType: "json"
            }).done(function (data) {
                var logeo = false
                data.forEach(function (usuario) {
                    if (usuario.usuarioCliente === $("[name=usuario_cliente]").val() && usuario.passwordCliente === $("[name=password_cliente]").val()) {
                        logeo = true
                        return false
                    }
                })
                if (logeo) {
                    window.location.href = "dashBoard.html"
                } else {
                    alert("Usuario o contraseña no validos")
                }
            }).fail(function (xhr, status, error) {
                alert("Algo salio mal")
            })
        })

    })
})(jQuery)