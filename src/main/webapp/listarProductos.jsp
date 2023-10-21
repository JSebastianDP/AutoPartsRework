<%@include file="./Gerente/DashBoardAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <title>Listar productos</title>
</head>
<body>
    <div class="my-added-content">
        <h1>Listar Productos</h1>
        <table class="table table-striped datatable" id="miTabla">
            <thead>
                <tr>
                    <th>Producto ID</th>
                    <th>Nombre producto</th>
                    <th>Marca Producto</th>
                    <th>Cantidad producto</th>
                    <th>Foto</th>
                    <th>Precio producto</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${producto}">
                    <tr>
                        <td>${producto.id}</td>
                        <td>${producto.nombre_producto}</td>
                        <td>${producto.marca_producto}</td>
                        <td>${producto.cantidad_producto}</td>
                        <td><img src="${producto.imagen}" width="50px" height="50px"></td>
                        <td>${producto.precio_producto}</td>
                        <td>${producto.estado}</td>
                        <td>
                            <button class="btn-open-description" onclick="openDescriptionModal('${producto.nombre_producto}', '${producto.descripcion_producto}')">Abrir Descripción</button>
                            <a href="editarProducto.jsp?id=${producto.id}" class="btn-edit">Editar</a>
                            <a href="eliminarProducto.jsp?id=${producto.id}" class="btn-delete">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Modal de descripción -->
    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close" id="closeButton">&times;</span>
            <h2 id="modalTitle"></h2>
            <p id="descriptionText"></p>
        </div>
    </div>

    <script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#miTabla').DataTable();
        });

        // Función para abrir el modal con una descripción
        function openDescriptionModal(productName, description) {
            const modal = document.getElementById("myModal");
            const modalTitle = document.getElementById("modalTitle");
            const descriptionText = document.getElementById("descriptionText");
            const closeButton = document.getElementById("closeButton"); // Botón de cierre

            modal.style.display = "block";
            modalTitle.textContent = productName;
            descriptionText.textContent = description;

            // Agregar el evento para cerrar el modal
            closeButton.addEventListener("click", function () {
                modal.style.display = "none";
            });
        }
    </script>
</body>
</html>
