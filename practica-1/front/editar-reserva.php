<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Formulario de reservas">
  <meta name="keywords" content="Reservar,disponibilidad,formulario">
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

  <h1 class="title">Editar reserva</h1>
  <div class="usuario-form">
    <?php
      require_once('database.php');
      session_start();
      $mostrarForm = false;
      if ($_SERVER['REQUEST_METHOD'] !== 'GET') {
        header("HTTP/1.1 302 Moved Temporarily");
        header("Location: reserva.html");
        exit;
      }

      if(isset($_SESSION["bar_loggedin"]) && $_SESSION["bar_loggedin"]) {
        $idCliente = $_SESSION["bar_idCliente"];
        $idReserva = $_GET["idReserva"];
        $sql = 'SELECT idReservas, fecha, cantidadPersonas FROM Reservas WHERE idReservas= ? AND idCliente = ?';
        $select = $conn -> prepare($sql);
        $select -> bind_param("ii", $idReserva, $idCliente);
        $select -> execute();

        $result = $select -> get_result();
        if($result -> num_rows > 0) {
          $row = $result -> fetch_assoc();
          $mostrarForm = true;
        }
        else {
          echo "<p class='alert alert-danger'>No se encontró la reserva solicitada.</p>";
          echo "<a href='lista-reservas.php'>Ir a mis reservas</a>";
          exit;  
        }
      }
      else {
        echo "<p class='alert alert-danger'>Debes estar logueado para editar una reserva.</p>";
      }

    ?>

    <?php if($mostrarForm): ?>
      <div class="container">
        <div class="row">
          <div class="col">
          <form action="confirmar-editar-reserva.php" class="needs-validation-editar-reserva" method="post" novalidate>
      <div class="row">
        <div class="col">
          <label for="txt-datetime" class="form-label">Fecha y hora</label>
          <input class="user form-control" id="txt-datetime" type="text" name="fechaHora" readonly value="<?php echo $row['fecha'];?>"> 
        </div>
      </div>
      <div class="row">
        <div class="col">
          <label for="txt-personas" class="form-label">Cantidad de personas</label>
          <input class="user form-control" id="txt-personas" type="number" name="cantidadPersonas" required value="<?php echo $row['cantidadPersonas'];?>">
          <div class="invalid-feedback">
            Ingrese una cantidad de personas entre 1 y 100
          </div>
        </div>
      </div>
      <input type="hidden" name="idReserva" value="<?php echo $row['idReservas'];?>">
      <button class="btn btn-bar">Enviar</button>
    </form>
          </div>
        </div>
      </div>
    <?php endif; ?>

  </div>
  <footer class="footer-style">
    Copyright © Todos los derechos reservados
  </footer>
  <script src="./funcionesGrupo7.js"></script>
</body>

</html>