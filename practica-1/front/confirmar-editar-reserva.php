<?php
  session_start();
  require_once "database.php";
  if ($_SERVER['REQUEST_METHOD'] === 'GET') {
    header("HTTP/1.1 302 Moved Temporarily");
    header("Location: reserva.html");
    exit;
  }

  if(isset($_SESSION["bar_loggedin"]) && $_SESSION["bar_loggedin"]) {
    $idCliente = $_SESSION["bar_idCliente"];
    $idReserva = $_POST["idReserva"];
    $cantidadPersonas = $_POST["cantidadPersonas"];
  
    $sql = "UPDATE Reservas SET cantidadPersonas = ? WHERE idReservas = ? AND idCliente = ?";
    $ins_reserva = $conn -> prepare($sql);
    $ins_reserva->bind_param("iii", $cantidadPersonas, $idReserva, $idCliente);
    $ins_reserva->execute();
    $ins_reserva->close();
  }
  
  header("HTTP/1.1 302 Moved Temporarily");
  header("Location: lista-reservas.php");
?>