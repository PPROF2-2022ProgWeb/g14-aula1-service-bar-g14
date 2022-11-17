CREATE TABLE Cliente 
(
    idCliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    apellido VARCHAR(200) NOT NULL,
    telefono VARCHAR(40) NOT NULL,
    dni VARCHAR(20) NOT NULL
)

CREATE TABLE Producto
(
    idProducto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    precio DECIMAL(18,2) NOT NULL,
    stockAct INT NOT NULL DEFAULT 0,
    stockMin INT NOT NULL DEFAULT 0,
    stockMax INT NOT NULL DEFAULT 0,
    urlImagen VARCHAR(500) NOT NULL

)

CREATE TABLE Carrito 
(
	idCarrito INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	idCliente INT NOT NULL,
	idProducto INT NOT NULL,

    CONSTRAINT fk_Carrito_Cliente 
    FOREIGN KEY (idCliente)
    REFERENCES Cliente (idCliente),
    CONSTRAINT fk_Carrito_Producto 
    FOREIGN KEY (idProducto)
    REFERENCES Producto (idProducto)
)

CREATE TABLE MetodoPago
(
    idMetodoPago INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL
)

CREATE TABLE Pedido 
(
    idPedido INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idCliente INT NOT NULL,
    idProducto INT NOT NULL,
    fechaHora DATETIME NOT NULL,
    
    CONSTRAINT fk_Pedido_Cliente 
    FOREIGN KEY (idCliente)
    REFERENCES Cliente (idCliente),
    CONSTRAINT fk_Pedido_Producto 
    FOREIGN KEY (idProducto)
    REFERENCES Producto (idProducto)
)

CREATE TABLE Reserva
(
    idReserva INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL,
    cantidadPersonas INT NOT NULL,
    idCliente INT NOT NULL,
    
    CONSTRAINT fk_Reserva_Cliente FOREIGN KEY (idCliente)
    REFERENCES Cliente (idCliente)
)

CREATE TABLE Usuario
(
    idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL, 
    idCliente INT NOT NULL,

    CONSTRAINT fk_Usuario_Cliente FOREIGN KEY (idCliente)
    REFERENCES Cliente (idCliente)
)

CREATE TABLE Role
(
    idRole INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
)

CREATE TABLE UserRoles
(
	idRole INT NOT NULL,
    idUsuario INT NOT NULL,

    CONSTRAINT fk_UserRoles_User FOREIGN KEY (idUsuario)
    REFERENCES Usuario (idUsuario),
    CONSTRAINT fk_UserRoles_Role FOREIGN KEY (idRole)
    REFERENCES Role (idRole)
)