(function ($) {
    $(document).ready(function () {
        $("#registro").on("click", function (e) {
            window.location.href = "registroCliente.html"
        })

        $("[name=login]").on("submit", function (params) {
            $.ajax({
                url: "/kolo/api/Cliente",
                contentType: "application/json",
                method: "GET",
                dataType: "json"
            }).done(function (data) {
                console.log(data)
                //comparar los clientes ya registrados con el usuario y contraseña ingresados
            }).fail(function (xhr, status, error) {
                throw error
            })
        })

    })
})(jQuery)