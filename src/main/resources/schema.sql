DROP DATABASE IF EXISTS blogdeviajes;
CREATE DATABASE blogdeviajes CHARACTER SET utf8mb4;
USE blogdeviajes;

CREATE TABLE cliente (
                         id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                         nick VARCHAR(16) UNIQUE,
                         nombre VARCHAR(100) NOT NULL,
                         apellido1 VARCHAR(100) NOT NULL,
                         apellido2 VARCHAR(100),
                         email VARCHAR(20) NOT NULL,
                         teléfono VARCHAR(9) NOT NULL
);

CREATE TABLE post (
                      id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                      titulo VARCHAR(64),
                      id_cliente INT UNSIGNED NOT NULL,
                      FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

CREATE TABLE seccion (
                         id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                         titulo VARCHAR(30) NOT NULL,
                         id_post INT UNSIGNED NOT NULL,
                         FOREIGN KEY (id_post) REFERENCES post(id)
);

CREATE TABLE comentario (
                            id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                            comentario VARCHAR(512) NOT NULL,
                            fecha_comentario DATE NOT NULL,
                            id_cliente INT UNSIGNED NOT NULL,
                            id_seccion INT UNSIGNED NOT NULL,
                            FOREIGN KEY (id_cliente) REFERENCES cliente(id),
                            FOREIGN KEY (id_seccion) REFERENCES seccion(id)
);

CREATE TABLE tipo (
                      id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                      nombre VARCHAR(100) NOT NULL,
                      texto VARCHAR(1032),
                      url_imagen VARCHAR(256)
);

CREATE TABLE seccion_tipo (
                              id_seccion INT UNSIGNED NOT NULL,
                              id_tipo INT UNSIGNED NOT NULL,
                              FOREIGN KEY (id_seccion) REFERENCES seccion(id),
                              FOREIGN KEY (id_tipo) REFERENCES tipo(id)
);
