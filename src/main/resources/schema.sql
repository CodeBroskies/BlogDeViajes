DROP DATABASE IF EXISTS blogdeviajes;
CREATE DATABASE blogdeviajes CHARACTER SET utf8mb4;
USE blogdeviajes;

CREATE TABLE cliente (
     id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
     nick VARCHAR(16) UNIQUE,
     password VARCHAR(255),
     avatar VARCHAR(200),
     nombre VARCHAR(100),
     apellido1 VARCHAR(100),
     apellido2 VARCHAR(100),
     email VARCHAR(20),
     telefono VARCHAR(9)
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
    fecha_comentario DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_cliente INT UNSIGNED NOT NULL,
    id_post INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (id_post) REFERENCES post(id)
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

CREATE OR REPLACE VIEW seccion_contenido AS
SELECT s.id AS id_seccion, s.titulo AS titulo_seccion, s.id_post AS id_post, t.texto AS contenido, t.url_imagen AS url_imagen
FROM seccion s
         JOIN seccion_tipo st ON s.id = st.id_seccion
         JOIN tipo t ON st.id_tipo = t.id;

CREATE OR REPLACE VIEW vista_comentarios AS
SELECT c.id AS id, c.comentario AS comentario, c.fecha_comentario AS fecha_comentario, c.id_cliente AS id_cliente, cl.nick AS nick, cl.avatar AS avatar, c.id_post AS id_post
FROM comentario c
         JOIN cliente cl ON c.id_cliente = cl.id;

CREATE OR REPLACE VIEW vista_post_cliente AS
SELECT p.id AS id_post, p.titulo AS titulo, c.id AS id_cliente, c.nick AS nick, c.avatar AS avatar, t.texto AS descripcion
FROM post p
         JOIN cliente c ON p.id_cliente = c.id
         JOIN seccion s ON p.id = s.id_post
         JOIN (SELECT id_post, MIN(id) AS min_id FROM seccion GROUP BY id_post) min_seccion ON s.id_post = min_seccion.id_post AND s.id = min_seccion.min_id
         JOIN seccion_tipo st ON s.id = st.id_seccion
         JOIN tipo t ON st.id_tipo = t.id;

CREATE OR REPLACE VIEW vista_tipo_seccion AS
SELECT t.id AS id_tipo, t.nombre AS nombre, t.texto AS texto, t.url_imagen AS url_imagen, s.id AS id_seccion
FROM tipo t
         JOIN seccion_tipo st ON t.id = st.id_tipo
         JOIN seccion s ON st.id_seccion = s.id;


