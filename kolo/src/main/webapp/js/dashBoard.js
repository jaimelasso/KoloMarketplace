(function ($) {
    //comentario
    $(document).ready(function () {
        /**
         * Crea nuevas categorias quemadas
         * @type Array
         */
//        var categorias = [
//            {
//                nombreCategoria: "Electro y tecnologia"
//            },
//            {
//                nombreCategoria: "Hogar"
//            },
//            {
//                nombreCategoria: "Deportes"
//            },
//            {
//                nombreCategoria: "Accesorios"
//            },
//            {
//                nombreCategoria: "Vestir"
//            }]
//        categorias.forEach(function (categoria) {
//            $.ajax({
//                url: "/kolo/api/Categoria",
//                contentType: "application/json",
//                method: "POST",
//                dataType: "json",
//                data: JSON.stringify(categoria)
//            }).fail(function (xhr, status, error) {
//                alert("No se pudo crear la categoria")
//            })
//        })
        
        for (var index = 0; index < 5; index++) {
            var producto = $(".product-item").clone()
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
            var filter = $(this).data("filter")
            filterSelection(filter)
        })

        $(".product-item:odd").addClass("cat1")
        $(".product-item:even").addClass("cat2")

        $(".list-group-item").on("click", function () {
            $(".list-group-item").toggleClass("active")
        })

        /**
         * Consulta las categorias 
         */
        $.ajax({
            url: "/kolo/api/Categoria",
            contentType: "application/json",
            method: "GET",
            dataType: "json"
        }).done(function (data) {
            data.forEach(function (categoria) {
                $("#cat-filter").append('<li role="presentation"><a data-filter="' + categoria.idCategoria + '" id="' + categoria.idCategoria + 'dsf">' + categoria.nombreCategoria + '</a></li>')
            })
        }).fail(function (xhr, status, error) {
            throw error
        })

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
        
         $.ajax({
             url: "/kolo/api/Proveedor",
             contentType: "application/json",
             method: "GET",
             dataType: "json"
         }).done(function (data) {
             debugger;
         }).fail(function (xhr, status, error) {
             throw error
         })

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
        if (c == "all")
            c = "";
        for (i = 0; i < x.length; i++) {
            w3RemoveClass(x[i], "show");
            if (x[i].className.indexOf(c) > -1)
                w3AddClass(x[i], "show");
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