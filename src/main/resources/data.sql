INSERT INTO `cliente` (`id`, `nick`, `password`, `avatar`, `nombre`, `apellido1`, `apellido2`, `email`, `telefono`) VALUES
    (1, 'Test', '$2a$10$DM9rPx7A8valD9eIrqbNO.huy0uqrRIE4quWuh/Ecppe6GdQAMeua', 'null', 'null', 'null', 'null', 'null', 'null'),
    (2, 'Test2', '$2a$10$FNIDf3Z1mBtCooe98X9HjOR257nL7CsCtLXhhXOKBUBGsMpPPy2wG', 'null', 'null', 'null', 'null', 'null', 'null'),
    (3, 'Test3', '$2a$10$k//qGlxiiWAbIHb0F9752ekfsdIrHAWI4.QEN4UuRBywioG8OBKfu', 'null', 'null', 'null', 'null', 'null', 'null'),
    (4, 'juanriosg1', '$2a$10$DPNIpT8bkDwVOVjkjHIngOkYcoSSEFoTfkrDcuLoFctonWPtR6tce', 'https://png.pngtree.com/png-clipart/20230927/original/pngtree-man-avatar-image-for-profile-png-image_13001877.png', 'Juan Jose', 'Rios', 'Gangas', 'jjrgthelaw@gmail.com', '627318092'),
    (5, 'ana-elena', '$2a$10$KXNrs9GRDivTvPPeal0Ubezi7n92D52tss7Ctii1eP7rxrRN0SXxa', 'https://cdn.pixabay.com/photo/2021/02/27/16/25/woman-6055084_1280.jpg', 'Ana Elena', 'Rios', 'Gangas', 'anaele@hotmail.com', '600895627'),
    (6, 'JaJaJaime', '$2a$10$u8r6mi7boMZ76zMnIj7kTuhSuvL6669k/huzxF7IduotQkRhGXKUW', 'https://img.freepik.com/vector-premium/ilustracion-avatar-estudiante-cono-perfil-usuario-avatar-jovenes_118339-4402.jpg', 'Jaime', 'González', 'Ajanel', 'jaime@hotmail.com', '627456123');

INSERT INTO `post` (`id`, `titulo`, `id_cliente`) VALUES
    (26, 'Mi viaje a Paris', 4),
    (27, 'Mi viaje a Mexico', 4),
    (34, 'Viaje por Mexico', 4),
    (36, 'Mi viaje a Barcelona', 5),
    (38, 'Mi viaje a China ', 5),
    (39, 'Mi viaje a Galicia', 6),
    (40, 'Mi viaje a Portugal', 6);

INSERT INTO `roles` (`id`, `name`) VALUES
    (1, 'ROLE_USER'),
    (2, 'ROLE_ADMIN');

INSERT INTO `seccion` (`id`, `titulo`, `id_post`) VALUES
    (29, 'Dia 1: Explorando París', 26),
    (30, 'Día 2: Arte y cultura', 26),
    (31, 'Día 3: Belleza y relajación', 26),
    (38, 'Día 1', 34),
    (39, 'Día 2', 34),
    (40, 'Día 3', 34),
    (44, 'Dia 1: Centro de barcelona', 36),
    (45, 'Día 2: Gaudí y más', 36),
    (46, 'Día 3: Playas y Montjuic', 36),
    (48, 'Día 1: Beijing', 38),
    (49, 'Día 2: Gran Muralla', 38),
    (50, 'Día 3: Shanghai', 38),
    (51, 'Día 1: Santiago de Compostela', 39),
    (52, 'Día 2: Rías Baixas', 39),
    (53, 'Día 3: Costa da Morte', 39),
    (54, 'Día 1: Lisboa', 40),
    (55, 'Día 2: Sintra y Cascais', 40),
    (56, 'Día 3: Porto', 40);

INSERT INTO `tipo` (`id`, `nombre`, `texto`, `url_imagen`) VALUES
    (1, 'Galería de fotos', 'Echa un vistazo a las fotos de mi viaje.', 'https://example.com/gallery.jpg'),
    (2, 'Consejos de viaje', 'Descubre algunos consejos útiles para viajar.', 'https://example.com/tips.jpg'),
    (3, 'Experiencias culinarias', 'Explora la deliciosa comida local.', 'https://example.com/food.jpg'),
    (4, 'Contenido', '¡Hola a todos! Acabo de regresar de un viaje increíble a París con mi familia y quería compartir con ustedes nuestra experiencia. Solo estuvimos tres días, pero logramos aprovechar al máximo nuestro tiempo. Aquí les dejo una guía de nuestro itinerario, incluyendo algunos de los mejores lugares turísticos y restaurantes que visitamos.\r\n\r\n Día 1: Explorando el Corazón de París\r\n\r\nMañana:\r\n- Notre Dame y Sainte-Chapelle: Comenzamos nuestra aventura en la catedral de Notre Dame. Aunque no pudimos entrar por las renovaciones, caminar alrededor y admirar la arquitectura gótica fue impresionante. Luego, visitamos la Sainte-Chapelle, famosa por sus vitrales que te dejan sin aliento.\r\n\r\nTarde:\r\n\r\n', ''),
    (5, 'Contenido', '¡Acabamos de regresar de un viaje de 3 días a París! Visitamos Notre Dame y Sainte-Chapelle, el Louvre y cenamos en \"Le Comptoir du Relais\". El segundo día disfrutamos del Museo de Orsay, Montmartre y cenamos en \"Le Relais de Entrecote\". El tercer día subimos a la Torre Eiffel, hicimos un crucero por el Sena y cenamos en \"Chez Janou\". Usamos el metro para movernos y compramos entradas anticipadas para evitar filas. París es un paraíso gastronómico, ¡no se pierdan los croissants y el vino!', 'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1b/4b/59/86/caption.jpg'),
    (6, 'Contenido', 'Quiero compartir mi reciente viaje de tres días a París con mi familia.\r\n\r\n\r\nNos hospedamos cerca de la Torre Eiffel y empezamos con una visita a esta icónica torre. Luego, almorzamos en Café Constant y paseamos por los Campos Elíseos hasta el Arco del Triunfo. Para la cena, disfrutamos de un delicioso bistec en Le Relais de l Entrecote.', 'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1b/4b/59/86/caption.jpg'),
    (7, 'Contenido', 'Visitamos el Museo del Louvre temprano y luego almorzamos en Angelina. Por la tarde, exploramos la Catedral de Notre-Dame y paseamos por Le Marais. Cenamos en Le Comptoir du Relais en Saint-Germain.', 'https://fotos.perfil.com/2020/11/05/trim/1200/900/museo-louvre-1072536.jpg'),
    (8, 'Contenido', 'Comenzamos el día en los Jardines de Luxemburgo y luego visitamos Montmartre y la Basílica del Sagrado Corazón. Almorzamos en Le Moulin de la Galette y por la tarde tomamos un crucero por el Sena con Bateaux Parisiens. Terminamos con una cena especial en Le Jules Verne en la Torre Eiffel.\r\n\r\nEspero que estas recomendaciones les sean útiles. ¡Buen viaje!', 'https://www.paris.es/f/francia/paris/guia/jardines-luxemburgo-m.jpg'),
    (9, 'Contenido', 'Quiero compartir con ustedes mi reciente viaje de tres días a México con mi familia. Fue una experiencia inolvidable y espero que estas recomendaciones les sean útiles si están planeando visitar este hermoso país.\r\n\r\nDía 1: Ciudad de México\r\n\r\nLlegamos a la Ciudad de México por la mañana y nos hospedamos en un hotel en el centro histórico. Comenzamos nuestro recorrido visitando el Zócalo, donde pudimos admirar la Catedral Metropolitana y el Palacio Nacional con sus impresionantes murales de Diego Rivera. Luego, caminamos hasta la Casa de los Azulejos para almorzar en su encantador restaurante Sanborns.\r\n\r\nPor la tarde, visitamos el Museo Frida Kahlo en Coyoacán. La casa azul donde vivió Frida es fascinante y llena de historia. Después, paseamos por el mercado de artesanías de Coyoacán y probamos los churros y chocolate caliente en El Jarocho.\r\n\r\nPara la cena, fuimos a Pujol, uno de los mejores restaurantes de la ciudad, donde disfrutamos de una experiencia culinaria única con platillos mexicanos contemporáneos.\r\n\r\n', ''),
    (10, 'Contenido', 'Quiero compartir con ustedes mi reciente viaje de tres días a México con mi familia. Fue una experiencia inolvidable y espero que estas recomendaciones les sean útiles si están planeando visitar este hermoso país.\r\n\r\nDía 1: Ciudad de México\r\n\r\nVisitamos el Zócalo, la Catedral Metropolitana y el Palacio Nacional. Almorzamos en Sanborns en la Casa de los Azulejos. Luego, fuimos al Museo Frida Kahlo en Coyoacán y disfrutamos de churros en El Jarocho. Para la cena, elegimos Pujol.\r\n', ''),
    (11, 'Contenido', 'Quiero compartir con ustedes mi reciente viaje de tres días a México con mi familia. Fue una experiencia inolvidable y espero que estas recomendaciones les sean útiles si están planeando visitar este hermoso país.\r\n\r\nDía 1: Ciudad de México\r\n\r\nVisitamos el Zócalo, la Catedral Metropolitana y el Palacio Nacional. Almorzamos en Sanborns en la Casa de los Azulejos. Luego, fuimos al Museo Frida Kahlo en Coyoacán y disfrutamos de churros en El Jarocho. Para la cena, elegimos Pujol.\r\n', ''),
    (12, 'Contenido', 'Quiero compartir con ustedes mi reciente viaje de tres días a México con mi familia. Fue una experiencia inolvidable y espero que estas recomendaciones les sean útiles si están planeando visitar este hermoso país.\r\n\r\nDía 1: Ciudad de México\r\n\r\nVisitamos el Zócalo, la Catedral Metropolitana y el Palacio Nacional. Almorzamos en Sanborns en la Casa de los Azulejos. Luego, fuimos al Museo Frida Kahlo en Coyoacán y disfrutamos de churros en El Jarocho. Para la cena, elegimos Pujol.\r\n', ''),
    (13, 'Contenido', 'Quiero compartir con ustedes mi reciente viaje de tres días a México con mi familia. Fue una experiencia inolvidable y espero que estas recomendaciones les sean útiles si están planeando visitar este hermoso país.\r\n\r\nVisitamos el Zócalo, la Catedral Metropolitana y el Palacio Nacional. Almorzamos en Sanborns en la Casa de los Azulejos. Luego, fuimos al Museo Frida Kahlo en Coyoacán y disfrutamos de churros en El Jarocho. Para la cena, elegimos Pujol.\r\n', ''),
    (14, 'Contenido', 'Quiero compartir con ustedes mi reciente viaje de tres días a México con mi familia. Fue una experiencia inolvidable y espero que estas recomendaciones les sean útiles si están planeando visitar este hermoso país.\r\n\r\nVisitamos el Zócalo, la Catedral Metropolitana y el Palacio Nacional. Almorzamos en Sanborns en la Casa de los Azulejos. Luego, fuimos al Museo Frida Kahlo en Coyoacán y disfrutamos de churros en El Jarocho. Para la cena, elegimos Pujol.\r\n', ''),
    (15, 'Contenido', 'Ciudad de Mexico,\r\nQuiero compartir con ustedes mi reciente viaje de tres días a México con mi familia. Fue una experiencia inolvidable y espero que estas recomendaciones les sean útiles si están planeando visitar este hermoso país.\r\n\r\nVisitamos el Zócalo, la Catedral Metropolitana y el Palacio Nacional. Almorzamos en Sanborns en la Casa de los Azulejos. Luego, fuimos al Museo Frida Kahlo en Coyoacán y disfrutamos de churros en El Jarocho. Para la cena, elegimos Pujol.\r\n', 'https://media.cntraveler.com/photos/5a92f25dc6516a534a5304e9/16:9/w_2560,c_limit/Metropolitan-Cathedral_GettyImages-115006326.jpg'),
    (16, 'Contenido', 'Teotihuacán y Xochimilco,\r\nVisitamos las pirámides de Teotihuacán y almorzamos en La Gruta. Por la tarde, paseamos en trajinera en Xochimilco. Cenamos en Contramar.\r\n\r\n', 'https://media.admagazine.com/photos/6215cb21270b6c35ebf618b2/16:9/w_2560%2Cc_limit/Chichen%2520itza%25CC%2581%2520.jpg'),
    (17, 'Contenido', 'Chapultepec y Polanco,\r\nExploramos el Bosque de Chapultepec, visitando el Castillo de Chapultepec y el Museo Nacional de Antropología. Almorzamos en El Cardenal. Por la tarde, paseamos por Polanco y terminamos con una cena en Quintonil.\r\n\r\nEspero que estas recomendaciones les sean útiles. Buen viaje', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Sobrevuelos_CDMX_HJ2A5116_%2826515134738%29.jpg/1200px-Sobrevuelos_CDMX_HJ2A5116_%2826515134738%29.jpg'),
    (18, 'Contenido', 'Visitamos La Rambla y el Mercado de La Boquería. Exploramos el Barrio Gótico y la Catedral de Barcelona. Almorzamos en El Xampanyet. Por la tarde, paseamos por el Parc de la Ciutadella y vimos el Arc de Triomf. Cenamos en Can Culleretes.', 'https://visitbarcelonawithfamily.com/wp-content/uploads/2019/06/Catedral-barcelona-2-870x1024.jpg'),
    (19, 'Contenido', 'Comenzamos en la Sagrada Familia y luego visitamos el Parc Güell. Almorzamos en Cervecería Catalana. Por la tarde, recorrimos la Casa Batlló y la Casa Milà. Cenamos en Tapas 24.', 'https://www.barcelo.com/guia-turismo/wp-content/uploads/2019/04/parque-guell.jpg'),
    (20, 'Contenido', 'Disfrutamos de la playa en Barceloneta y almorzamos en La Barceloneta. Luego, visitamos el Montjuïc, el Castillo de Montjuïc y el Pueblo Español. Terminamos con una cena en El Nacional.', 'https://hotelmiramarbarcelona.com/assets/themes/hotelmiramarbarcelona.com/img/posts/castell_montjuic_Justin.jpg'),
    (21, 'Contenido', 'Visitamos La Rambla y el Mercado de La Boquería. Exploramos el Barrio Gótico y la Catedral de Barcelona. Almorzamos en El Xampanyet. Por la tarde, paseamos por el Parc de la Ciutadella y vimos el Arc de Triomf. Cenamos en Can Culleretes.\r\n', 'https://visitbarcelonawithfamily.com/wp-content/uploads/2019/06/Catedral-barcelona-2-870x1024.jpg'),
    (22, 'Contenido', 'Comenzamos en la Sagrada Familia y luego visitamos el Parc Güell. Almorzamos en Cervecería Catalana. Por la tarde, recorrimos la Casa Batlló y la Casa Milà. Cenamos en Tapas 24.\r\n', 'https://www.barcelo.com/guia-turismo/wp-content/uploads/2019/04/parque-guell.jpg'),
    (23, 'Contenido', 'Disfrutamos de la playa en Barceloneta y almorzamos en La Barceloneta. Luego, visitamos el Montjuïc, el Castillo de Montjuïc y el Pueblo Español. Terminamos con una cena en El Nacional.\r\n', 'https://hotelmiramarbarcelona.com/assets/themes/hotelmiramarbarcelona.com/img/posts/castell_montjuic_Justin.jpg'),
    (24, 'Contenido', 'Visitamos la Ciudad Prohibida y luego caminamos por la Plaza de Tiananmen. Almorzamos en Quanjude, famoso por su pato laqueado. Por la tarde, exploramos el Templo del Cielo y paseamos por el mercado de la calle Wangfujing. Cenamos en Din Tai Fung, conocido por sus dumplings.', 'https://media.istockphoto.com/id/482334184/photo/night-on-beijing-central-business-district-buildings-skyline-china-cityscape.jpg'),
    (25, 'Contenido', 'Visitamos la Ciudad Prohibida y luego caminamos por la Plaza de Tiananmen. Almorzamos en Quanjude, famoso por su pato laqueado. Por la tarde, exploramos el Templo del Cielo y paseamos por el mercado de la calle Wangfujing. Cenamos en Din Tai Fung, conocido por sus dumplings.', 'https://cdn-3.expansion.mx/dims4/default/f2f542b/2147483647/resize/1280x/quality/90/?url=https%3A%2F%2Fcdn-3.expansion.mx%2F23%2Fa7%2F345c42be4ba6817b1b2ce587b9d6%2Fistock-540842018.jpg'),
    (26, 'Contenido', 'Tomamos una excursión a la Gran Muralla en Mutianyu, disfrutando de las impresionantes vistas. Almorzamos en un restaurante local cercano. Por la tarde, visitamos el Palacio de Verano y sus hermosos jardines. Para la cena, fuimos a Dadong, otro gran lugar para el pato laqueado.', 'https://static.nationalgeographicla.com/files/styles/image_3200/public/nationalgeographic2710344.jpg'),
    (27, 'Contenido', 'Volamos a Shanghai y comenzamos con una visita al Jardín Yuyuan. Almorzamos en Nanxiang Steamed Bun Restaurant, famoso por sus xiaolongbao. Por la tarde, paseamos por el Malecón de Shanghai (The Bund) y disfrutamos de las vistas del skyline. Cenamos en Lost Heaven, que ofrece cocina de Yunnan.', 'https://www.disfrutashanghai.com/f/china/shanghai/guia/jardin-yuyuan-m.jpg'),
    (28, 'Contenido', 'Empezamos visitando la majestuosa Catedral de Santiago de Compostela y paseando por la Plaza del Obradoiro. Almorzamos en Café Casino, un lugar acogedor con comida deliciosa. Por la tarde, recorrimos las callejuelas del casco antiguo y visitamos el Mercado de Abastos. Para la cena, probamos la cocina gallega en Casa Marcelo.\r\n\r\n', 'https://fotografias.lasexta.com/clipping/cmsimages02/2021/04/25/FDAB0551-E8F9-4727-B56F-5E75B35F92F0/98.jpg'),
    (29, 'Contenido', 'Tomamos un viaje en coche por las impresionantes Rías Baixas. Visitamos el encantador pueblo de Combarro con sus hórreos y paseamos por el hermoso puerto de Sanxenxo. Almorzamos mariscos frescos en O Grove y disfrutamos de las vistas en Mirador de A Siradella. Para la cena, nos deleitamos con pescado fresco en Casa Solla.\r\n\r\n', 'https://www.spain.info/.content/imagenes/cabeceras-grandes/galicia/combarro-pontevedra-s650344639.jpg'),
    (30, 'Contenido', 'Exploramos la mística Costa da Morte. Visitamos el pueblo de Muxía y su icónico santuario, la Virxe da Barca. Almorzamos en O Camiño das Estrelas, un restaurante con vistas al mar. Por la tarde, nos maravillamos con los acantilados en Fisterra y disfrutamos de una cena de despedida en Mesón do Mar.\r\n\r\n', 'https://unaideaunviaje.com/wp-content/uploads/2020/05/que-ver-en-muxia-mirador-corpin%CC%83o.jpg'),
    (31, 'Contenido', 'Comenzamos explorando el encantador barrio de Alfama en Lisboa, con sus estrechas calles y vistas panorámicas desde el Castillo de San Jorge. Almorzamos en Casa do Alentejo, un restaurante histórico con cocina tradicional portuguesa. Por la tarde, visitamos la emblemática Torre de Belém y probamos los famosos pasteles de nata en Pasteis de Belém. Para la cena, disfrutamos de mariscos frescos en Ramiro.\r\n\r\n', 'https://www.disfrutalisboa.com/f/portugal/lisboa/guia/castillo-san-jorge-m.jpg'),
    (32, 'Contenido', 'Tomamos un día para explorar los encantadores pueblos de Sintra y Cascais. Visitamos el impresionante Palacio Nacional de Sintra y paseamos por los exuberantes jardines del Palacio da Pena. Almorzamos en Apeadeiro, un restaurante acogedor en el centro de Sintra. Por la tarde, nos dirigimos a la costa y disfrutamos de las vistas en el Cabo da Roca, el punto más occidental de Europa. Para la cena, probamos pescado fresco en Mar do Inferno en Cascais.\r\n\r\n', 'https://media.traveler.es/photos/61376c25f130191a954c7911/4:3/w_1764,h_1323,c_limit/141642.jpg'),
    (33, 'Contenido', 'Exploramos la hermosa ciudad de Porto, paseando por el encantador barrio de Ribeira a lo largo del río Duero. Visitamos la famosa Torre dos Clérigos y degustamos vino de Oporto en una de las muchas bodegas del río. Almorzamos en Cantinho do Avillez, un restaurante moderno con cocina portuguesa reinventada. Por la tarde, recorrimos los históricos barrios de Porto y disfrutamos de las vistas desde el Puente Luis I. Para la cena, nos deleitamos con platos tradicionales en DOP.\r\n\r\n', 'https://i.natgeofe.com/n/a418b667-c00b-417d-9ee5-32dfec838a8f/coverstory_portugal_GettyImages-533960357_HR.jpg');

INSERT INTO `seccion_tipo` (`id_seccion`, `id_tipo`) VALUES
     (29, 6),
     (30, 7),
     (31, 8),
     (38, 15),
     (39, 16),
     (40, 17),
     (44, 21),
     (45, 22),
     (46, 23),
     (48, 25),
     (49, 26),
     (50, 27),
     (51, 28),
     (52, 29),
     (53, 30),
     (54, 31),
     (55, 32),
     (56, 33);

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
    (1, 1),
    (2, 1),
    (2, 2);

INSERT INTO `comentarios` (`id`, `comentario`, `fecha`, `id_cliente`, `id_post`) VALUES
    (1, '¡Qué experiencia tan increíble! Me encantaría visitar París algún día.', '2024-01-01', 1, 26),
    (2, 'Gracias por las recomendaciones, definitivamente visitaré esos lugares.', '2024-01-01', 2, 26),
    (3, '¡Las fotos son espectaculares!', '2024-01-01', 3, 26),
    (4, '¿Cuánto tiempo estuviste en París?', '2024-01-01', 4, 26),

    (5, 'México parece fascinante, quiero ir.', '2024-01-02', 5, 27),
    (6, 'Las pirámides de Teotihuacán están en mi lista de deseos.', '2024-01-02', 6, 27),

    (7, 'Barcelona tiene una arquitectura impresionante.', '2024-01-03', 1, 36),
    (8, 'Me encantan tus fotos de Barcelona.', '2024-01-03', 2, 36),
    (9, '¡Gaudí fue un genio!', '2024-01-03', 3, 36),
    (10, '¿Cuántos días recomendarías para visitar Barcelona?', '2024-01-03', 4, 36),
    (11, 'Gracias por compartir tu itinerario.', '2024-01-03', 5, 36),

    (12, 'China tiene una cultura tan rica.', '2024-01-04', 6, 38),
    (13, 'Me gustaría visitar la Gran Muralla.', '2024-01-04', 1, 38),
    (14, '¡Qué hermoso es Beijing por la noche!', '2024-01-04', 2, 38),

    (15, 'Galicia tiene unos paisajes impresionantes.', '2024-01-05', 3, 39),
    (16, 'Gracias por las recomendaciones gastronómicas.', '2024-01-05', 4, 39),
    (17, '¿Cuál fue tu lugar favorito en Galicia?', '2024-01-05', 5, 39),
    (18, 'Espero poder visitar Santiago de Compostela pronto.', '2024-01-05', 6, 39),
    (19, 'Las Rías Baixas son un destino que no puedo perderme.', '2024-01-05', 1, 39),
    (20, 'La Costa da Morte tiene una belleza única.', '2024-01-05', 2, 39),
    (21, '¡Qué gran viaje a Galicia!', '2024-01-05', 3, 39);
