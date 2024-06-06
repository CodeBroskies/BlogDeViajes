INSERT INTO `cliente` (`id`, `nick`, `password`, `avatar`, `nombre`, `apellido1`, `apellido2`, `email`, `telefono`) VALUES
(1, 'Test', '$2a$10$DM9rPx7A8valD9eIrqbNO.huy0uqrRIE4quWuh/Ecppe6GdQAMeua', 'null', 'null', 'null', 'null', 'null', 'null'),
(2, 'Test2', '$2a$10$FNIDf3Z1mBtCooe98X9HjOR257nL7CsCtLXhhXOKBUBGsMpPPy2wG', 'null', 'null', 'null', 'null', 'null', 'null'),
(3, 'Test3', '$2a$10$k//qGlxiiWAbIHb0F9752ekfsdIrHAWI4.QEN4UuRBywioG8OBKfu', 'null', 'null', 'null', 'null', 'null', 'null');

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

INSERT INTO comentario (comentario, fecha_comentario, id_cliente, id_post) VALUES
('¡Qué emocionante! Estoy deseando leer más sobre tu aventura.', '2024-05-01', 2, 1),
('París es una ciudad increíble. ¡Disfruta mucho!', '2024-05-02', 3, 2),
('Las fotos son impresionantes. ¡Quiero ir a Tailandia ahora mismo!', '2024-05-03', 1, 2),
('Me encantaría hacer ese trekking. ¿Qué agencia recomiendas?', '2024-05-04', 2, 3);

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

INSERT INTO roles (name)
VALUES
    ('ROLE_USER'),
    ('ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id)
VALUES
    (1, 1),
    (2, 1),
    (3, 2);
