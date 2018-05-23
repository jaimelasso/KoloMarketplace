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
    })
})(jQuery)