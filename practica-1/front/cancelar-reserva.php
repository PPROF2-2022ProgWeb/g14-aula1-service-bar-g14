<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Formulario de reserva">
    <meta name="keywords" content="Reservas,confirmacion,reserva exitosa,formulario,reservar,disponibilidad">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
        integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="css/styles.css">
    <title>Customer Service Bar</title>
</head>

<body>
    <img src="images/logo.png" alt="logo" class="logo">
    <div>
        <h1 class="title">Customer Service Bar</h1>
    </div>
    <div class="container">
        <div class="row">
            <div class="col mb-4">
                <i class="fas fa-bars menu-button" onclick="toggleMenu(event)"></i>
            </div>
        </div>
    </div>
    <nav>
        <ul class="menu">
            <li><a href="index.html">INICIO</a> </li>
            <li><a href="productos.html">PRODUCTOS</a> </li>
            <li><a href="reserva.html">RESERVAS</a> </li>
            <li><a href="quienes-somos.html">QUIENES SOMOS</a> </li>
            <li><a href="login.html">LOGIN</a> </li>
        </ul>
    </nav>

    <h2 class="title">Cancelación de reserva</h1>


<div class="container">
  <div class="row">
    <div class="col">
<?php
  session_start();
  require_once "database.php";
  if ($_SERVER['REQUEST_METHOD'] === 'GET') {
    header("HTTP/1.1 302 Moved Temporarily");
    header("Location: reserva.html");
    exit;
  }

  if(isset($_SESSION["bar_loggedin"]) && $_SESSION["bar_loggedin"]) {
    $idReserva = $_POST["idReserva"];
    $idCliente = $_SESSION["bar_idCliente"];
    $sql = 'SELECT idReservas, fecha, cantidadPersonas FROM Reservas WHERE idReservas=? AND idCliente = ?';
    $select = $conn -> prepare($sql);
    $select -> bind_param("ii", $idReserva, $idCliente);
    $select -> execute();

    $result = $select -> get_result();

    if($result -> num_rows > 0) {
      $row = $result -> fetch_assoc();
      echo '<h3>Datos de la reserva</h3>';
      echo '<table class="table table-striped"><tr><td>'; 
      echo '<strong>Fecha</strong></td>';
      echo '<td>' . $row["fecha"] . '</td></tr>';
      echo '<tr>';
      echo '<td><strong>Cantidad de personas</strong></td>';
      echo '<td>' . $row["cantidadPersonas"] . '</td>';
      echo '</tr></table>';
      $select -> close();
      $sqlCancelar = 'DELETE FROM Reservas WHERE idReservas = ? AND idCliente = ?';
      $cancelar = $conn->prepare($sqlCancelar);
      $cancelar->bind_param("ii", $idReserva, $idCliente);
      $cancelar->execute();
      $cancelar->close();
    } else {
      echo '<p class="alert alert-danger">No se encontró la reserva para cancelar</p>';
    }
    
  }
  else {
    echo "<p class='alert alert-danger'>Debes estar logueado para cancelar una reserva.</p>";
  }
?>


</div>
  </div>
</div>

<footer class="footer-style">
        Copyright © Todos los derechos reservados
</footer>
    <script src="./funcionesGrupo7.js"></script>
</body>

</html>