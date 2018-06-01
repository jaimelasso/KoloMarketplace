(function ($) {
    //comentario
    $(document).ready(function () {
        for (let index = 0; index < 5; index++) {
            const producto = $(".product-item").clone()
            // producto.removeAttr("hidden")
            $("#products-container").append(producto)
        }

        filterSelection("all")

        var btns = $("#cat-filter li")
        for (var i = 0; i < btns.length; i++) {
            btns[i].addEventListener("click", function () {
                var current = $("#cat-filter .active")
                current.toggleClass("active");
                this.className += " active";
            });
        }

        $("#cat-filter").on("click", "a", function () {
            let filter = $(this).data("filter")
            filterSelection(filter)
        })

        $(".product-item:odd").addClass("cat1")
        $(".product-item:even").addClass("cat2")

        $(".list-group-item").on("click", () => $(".list-group-item").toggleClass("active"))

        

        // $.ajax({
        //     url: "/kolo/api/Categoria",
        //     contentType: "application/json",
        //     method: "GET",
        //     dataType: "json"
        // }).done(function (data) {
        //     // crear bloques de categorias
        // }).fail(function (xhr, status, error) {
        //     throw error
        // })

        // $.ajax({
        //     url: "/kolo/api/Productos",
        //     contentType: "application/json",
        //     method: "GET",
        //     dataType: "json"
        // }).done(function (data) {
        //     // crear bloques de productos
        // }).fail(function (xhr, status, error) {
        //     throw error
        // })

        // $.ajax({
        //     url: "/kolo/api/CarritoCompras" + idCarritoCompras,
        //     contentType: "application/json",
        //     method: "GET",
        //     dataType: "json"
        // }).done(function (data) {
        //     // traer carrito compras pendiente del cliente si hay
        // }).fail(function (xhr, status, error) {
        //     throw error
        // })
    })



    function filterSelection(c) {
        var x, i;
        x = document.getElementsByClassName("product-item");
        if (c == "all") c = "";
        for (i = 0; i < x.length; i++) {
            w3RemoveClass(x[i], "show");
            if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
        }
    }

    function w3AddClass(element, name) {
        var i, arr1, arr2;
        arr1 = element.className.split(" ");
        arr2 = name.split(" ");
        for (i = 0; i < arr2.length; i++) {
            if (arr1.indexOf(arr2[i]) == -1) {
                element.className += " " + arr2[i];
            }
        }
    }

    function w3RemoveClass(element, name) {
        var i, arr1, arr2;
        arr1 = element.className.split(" ");
        arr2 = name.split(" ");
        for (i = 0; i < arr2.length; i++) {
            while (arr1.indexOf(arr2[i]) > -1) {
                arr1.splice(arr1.indexOf(arr2[i]), 1);
            }
        }
        element.className = arr1.join(" ");
    }

})(jQuery)