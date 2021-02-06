INSERT INTO USER (id, password, username, name, lastname, locked, enabled) VALUES
(1, '{bcrypt}$2y$12$4Fd5gbh5shqEWjXLyD2AleD8SX2ppg2Y/KQOA9DWH6hEQxy7paJj6', 'user', 'Saulius', 'Sauliokas',  false, true),
(2, '{bcrypt}$2y$12$iW4NwnwwwG65uEP.u9ysPOpTHG6eUBLI80r6kp.h2TVwhVsYTZ0I6', 'admin', 'Paulius', 'Pauliokas', false, true);

INSERT INTO COIN (obverse, reverse, title, condition, mintage, metal, hallmark, weight, diameter, year, price, telephone, owner_id, description ) VALUES
('/uploads/1936-vytautas-didysis-a.jpg',   '/uploads/1936-vytautas-didysis-b.jpg',   'Vytautas Didysis, 10 litų, 1936, LIETUVA, sidabras', 'VF/XF',   720000,     'Silver (Ag)',  0.750,    18,       32.2,     1936, 35,      '81231231',      1,'Vytautas Didysis, 10 litų, 1936, Lietuva, sidabras\n Aversas: Lietuvos Didysis kunigaikštis Vytautas Didysis apink jį užrašas: * VYTAUTAS DIDYSIS * 10 DEŠIMTS LITŲ 10 *\n Reversas: Valstybės herbas – Vytis, žemiau jo užrašas „LIETUVA“ po juo nukaldinimo metai 1936.\n Briauna: „TAUTOS * JĖGA * VIENYBĖJE *“'),
('/uploads/1938-antanas-smetona-a.jpg',    '/uploads/1938-antanas-smetona-b.jpg',    'Antanas Smetona, 10 litų, 1938, LIETUVA, sidabras',  'VF/XF',   180000,     'Silver (Ag)',  0.750,    18,       32.2,     1938, 190,     '+37062277799',  1,'Aversas: Prezidento Antano Smetonos biustas, o aplink jį legenda: „VALSTYBĖS PREZIDENTAS A.SMETONA * 10 LITŲ 10 *“.\n Reversas: Gediminaičių stulpai, žemiau jų iškaltas užrašas „LIETUVA“ po juo jubiliejiniai metai 1918 – 1938, aplink legenda: „DVIDEŠIMT METŲ NEPRIKLAUSOMYBĖS *XX*“.\n Briauna: Iškaltas užrašas „TAUTOS * JĖGA * VIENYBĖJE *'),
('/uploads/1936-jonas-basanavicius-a.jpg', '/uploads/1936-jonas-basanavicius-b.jpg', 'Jonas Basanavičius 5 litai, 1936 LIETUVA, sidabras', 'VF/XF',   2612000,    'Silver (Ag)',  0.750,    9,        27,       1936, 15,      '81231231',     1,'Aversas: Monetos centre pavaizduotas lietuvių tautos patriarchas Dr. Jonas Basanavičius aplink jį užrašas „JONAS BASANAVIČIUS * 5 LITAI 5 *“.\n Reversas: Valstybės herbas – Vytis, žemiau jo užrašas LIETUVA, po juo monetos nukaldinimo metai 1936.\n Briauna: „TAUTOS * GEROVĖ * TAVO * GEROVĖ *“.'),
('/uploads/1925-tulpes-a.jpg',             '/uploads/1925-tulpes-b.jpg',             '5 litai, 1925, LIETUVA, sidabras',                   'VF/XF',   1000000,    'Silver (Ag)',  0.500,    13.5,     29.5,     1925, 25,      '37062277799',  1,'Aversas: Monetos centre užrašas 5 LITAI aplink linų dekoraciją.\n Reversas: Valstybės herbas – Vytis, žemiau jo Gediminaičių stulpai dar žemiau nukaldinimo metai 1925. Monetos kraštuose užrašas Lietuvos Respublika.\nBriauna: Ranteliai.');


INSERT INTO ROLE (id, type) VALUES
(1, 'USER'),
(2, 'ADMIN');

INSERT INTO USER_ROLES (user_id, role_id) VALUES
(1, 1),
(2, 2),
(2, 1);
