INSERT INTO cliente (nick, nombre, apellido1, apellido2, email, teléfono) VALUES
('user1', 'Juan', 'García', 'López', 'juangarcia@example.com', '123456789'),
('user2', 'María', 'Martínez', 'Fernández', 'mariamartinez@example.com', '987654321'),
('user3', 'Pedro', 'Sánchez', 'Gómez', 'pedrosanchez@example.com', '654987321');

INSERT INTO post (titulo, id_cliente) VALUES
('Mi viaje a París', 1),
('Vacaciones en Tailandia', 2),
('Aventuras en Machu Picchu', 3);

INSERT INTO seccion (titulo, id_post) VALUES
('Día 1: Llegada a París', 1),
('Día 2: Explorando la ciudad', 1),
('Día 3: Torre Eiffel y Louvre', 1),
('Preparativos del viaje', 2),
('Excursiones en Tailandia', 2),
('Descubriendo la cultura tailandesa', 2),
('El inicio del trekking', 3),
('Llegada a Machu Picchu', 3),
('Explorando las ruinas', 3);

INSERT INTO comentario (comentario, fecha_comentario, id_cliente, id_seccion) VALUES
('¡Qué emocionante! Estoy deseando leer más sobre tu aventura.', '2024-05-01', 2, 1),
('París es una ciudad increíble. ¡Disfruta mucho!', '2024-05-02', 3, 2),
('Las fotos son impresionantes. ¡Quiero ir a Tailandia ahora mismo!', '2024-05-03', 1, 5),
('Me encantaría hacer ese trekking. ¿Qué agencia recomiendas?', '2024-05-04', 2, 7);

INSERT INTO tipo (nombre, texto, url_imagen) VALUES
('Galería de fotos', 'Echa un vistazo a las fotos de mi viaje.', 'https://example.com/gallery.jpg'),
('Consejos de viaje', 'Descubre algunos consejos útiles para viajar.', 'https://example.com/tips.jpg'),
('Experiencias culinarias', 'Explora la deliciosa comida local.', 'https://example.com/food.jpg');

INSERT INTO seccion_tipo (id_seccion, id_tipo) VALUES
(1, 1),
(2, 3),
(3, 1),
(4, 2),
(5, 1),
(6, 3),
(7, 2),
(8, 1),
(9, 3);
