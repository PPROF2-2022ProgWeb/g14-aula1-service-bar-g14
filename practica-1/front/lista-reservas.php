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

    <h2 class="title">Mis reservas</h1>


<div class="container">
  <div class="row">
    <div class="col">
      <table class="table table-striped">
        <thead>
          <tr>
            <th>
              Fecha
            </th>
            <th>
              Cantidad de personas
            </th>
            <th>
            </th>
          </tr>
        </thead>
        <tbody>
        <?php
  require_once('database.php');
  session_start();
  
  if(isset($_SESSION["bar_loggedin"]) && $_SESSION["bar_loggedin"]) {

    # add is logged in 
    $idCliente = $_SESSION["bar_idCliente"];
    $sql = 'SELECT idReservas, fecha, cantidadPersonas from Reservas where idCliente = ?';
    $select = $conn->prepare($sql);
    $select->bind_param("i", $idCliente);
    $select->execute();

    $result = $select->get_result();

    if($result->num_rows > 0) {
      while($row = $result->fetch_assoc()) {
        echo '<tr><td>';
        echo $row["fecha"];
        echo '</td><td>';
        echo $row["cantidadPersonas"];
        echo '</td><td><div class="d-flex"><a href="editar-reserva.php?idReserva='. $row["idReservas"] . '"class="btn btn-primary mr-2">Editar</a>';
        echo '<form action="cancelar-reserva.php" method="post"><input type="hidden" name="idReserva" value=' . $row["idReservas"] . '">';
        echo '<button class="btn btn-danger">Cancelar</button></form>';
        echo '</div></td></tr>';
      }
      $select->close();
    }
    else {
      echo "<p class='alert alert-danger'>No se encontraron reservas</p>";
    }
  }
  else {
    echo "<p class='alert alert-danger'>Debes estar logueado para ver tus reservas.</p>";
  }

  

?>
        </tbody>
</table>
    </div>
  </div>
</div>

<footer class="footer-style">
        Copyright © Todos los derechos reservados
    </footer>
    <script src="./funcionesGrupo7.js"></script>
</body>

</html>