INSERT INTO `docentes` VALUES 
(1,'Rodriguez','juanca@gmail.com','01','Juan Carlos','3884858348'),
(2,'Vega','arielvega@gmail.com','02','Ariel','3884950580'),
(3,'Apaza','apaza@gmail.com','03','Carolina','3884374375'),
(4,'Perez Ibarra','mperezi@gmail.com','04','Marcelo','3884504205'),
(5,'Cañizares','canizares@gmail.com','05','Norma','3884945747'),
(6, 'Brizuela', 'gbrizuela@unju.fi.com', '001', 'Graciela', '3884567890'),
(7, 'Cañizares', 'ncanizares@unju.fi.com', '002', 'Norma', '3883456789'),
(8, 'Perez Ibarra', 'mperezi@unju.fi.com', '003', 'Marcelo', '3885678901'),
(9, 'Liberatori', 'hliberatori@unju.fi.com', '004', 'Hector', '3888901234'),
(10, 'Battezzati', 'vbattezzati@unju.fi.com', '005', 'Virginia', '3887890123'),
(11, 'Cornell', 'mcornell@unju.fi.com', '006', 'Agustina', '3884567890'),
(12, 'Tarifa', 'htarifa@unju.fi.com', '007', 'Hector', '3884567890'),
(13, 'Vega', 'arielvega@unju.fi.com', '008', 'Ariel', '3882345678'),
(14, 'Rodriguez', 'jcrodriguez@unju.fi.com', '009', 'Juan Carlos', '3881234567'),
(15, 'Zapana', 'josezapana@unju.fi.com', '010', 'Jose', '3884567890'),
(16, 'Ayusa', 'mayusa@unju.fi.com', '011', 'Cristina', '3884567890'),
(17, 'Castillo', 'ccastillo@unju.fi.com', '012', 'Cesar', '3884567890'),
(18, 'Valenzuela', 'vvalenzuela@unju.fi.com', '013', 'Virginia', '3883456789'),
(19, 'Gomez', 'cgomez@unju.fi.com', '014', 'Consuelo', '3884567890'),
(20, 'Espinosa', 'alfredespinosa@unju.fi.com', '015', 'Alfredo', '3884567890'),
(21, 'Caseres', 'caseres@unju.fi.com', '016', 'Nelida', '3884567890'),
(22, 'Aragon', 'saragon@unju.fi.com', '017', 'Sofia', '3884567890'),
(23, 'Apaza', 'carolinaapaza@unju.fi.com', '018', 'Carolina', '3882345678'),
(24, 'Torres', 'veronicatorres@unju.fi.com', '019', 'Veronica', '3886789012'),
(25, 'Rodriguez', 'crodrigueza@unju.fi.com', '020', 'Carolina', '3880123456'),
(26, 'Villarrubia', 'fvillarrubia@unju.fi.com', '021', 'Fernanda', '3881234567'),
(27, 'Garnica', 'ggarnica@unju.fi.com', '022', 'Graciela', '3882345678');

INSERT INTO `carreras` VALUES 
(3, 0, 1, 'APU', 'Analista Programador Universitario'),
(5, 0, 2, 'INF', 'Ingeniería Informática'),
(4, 0, 3, 'ADM', 'Administración de Empresas'),
(5, 0, 4, 'DER', 'Derecho'),
(6, 0, 5, 'MED', 'Medicina'),
(5, 0, 6, 'PSI', 'Psicología'),
(4, 0, 7, 'COM', 'Comunicación Social'),
(5, 1, 8, 'ARQ', 'Arquitectura'),
(4, 1, 9, 'CON', 'Contabilidad'),
(4, 1, 10, 'ECO', 'Economía'),
(5, 1, 11, 'ING', 'Ingeniería Civil');

INSERT INTO `materias` VALUES 
(90,2,0,1,1,2,'AP013','Programacion Visual'),
(70,2,0,2,1,5,'AP014','Laboratorio de Sistemas Operativos II'),
(120,1,0,3,2,4,'APU03','Programacion Estructurada');

INSERT INTO `alumnos` VALUES 
('2001-08-11', 1, 4, 'Véliz', '43527103', 'Gral Savio, Palpala', 'luveliz@gmail.com', '4317', 'Guadalupe', '3884334777'),
('1986-05-14', 1, 5, 'Rodríguez', '41123456', 'Calle Rivadavia 123, San Pedro', 'grodriguez@gmail.com', '3456', 'Gabriela', '3881122334'),
('1991-08-30', 1, 6, 'Sánchez', '41098765', 'Av. Alvear 456, Fraile Pintado', 'msanchez@gmail.com', '5678', 'Miguel', '3882233445'),
('1983-10-21', 1, 7, 'Silva', '39912345', 'Calle Mitre 789, Calilegua', 'vsilva@gmail.com', '7890', 'Valeria', '3883344556'),
('1994-04-17', 2, 8, 'Romero', '37876543', 'Av. Santa Fe 567, Tilcara', 'jromero@gmail.com', '9012', 'José', '3884455667'),
('1982-06-11', 2, 9, 'Ruiz', '42765432', 'Calle Mendoza 234, Maimará', 'pruiz@gmail.com', '3456', 'Patricia', '3885566778'),
('1985-12-03', 2, 10, 'Ortiz', '29654321', 'Av. San Martín 789, Abra Pampa', 'dortiz@gmail.com', '5678', 'Diego', '3886677889'),
('1996-01-25', 3, 11, 'Arias', '36543210', 'Calle Buenos Aires 456, San Antonio', 'narias@gmail.com', '7890', 'Natalia', '3887788990'),
('1974-10-29', 3, 12, 'Aguierrez', '39857294', 'Av. Martigena 69, Palpala', 'gaguierrez@gmail.com', '4566', 'Gonzalo', '3885977892'),
('1990-01-15', 4, 13, 'López', '38234567', 'Av. Belgrano 123, San Salvador', 'alopez@gmail.com', '2345', 'Ana', '3881234567'),
('1988-06-22', 5, 14, 'Gómez', '37987654', 'Calle Independencia 456, Perico', 'jgomez@gmail.com', '6789', 'Javier', '3887654321'),
('1992-09-10', 6, 15, 'Pérez', '35567890', 'Av. 19 de Abril 789, El Carmen', 'mperez@gmail.com', '1122', 'María', '3883456789'),
('1985-12-25', 7, 16, 'Martínez', '28823456', 'Calle Güemes 567, Monterrico', 'lmartinez@gmail.com', '3344', 'Luis', '3888765432'),
('1987-03-05', 7, 17, 'González', '36789012', 'Av. Córdoba 891, La Quiaca', 'lgonzalez@gmail.com', '5566', 'Laura', '3882345678'),
('1995-07-19', 7, 18, 'Ramírez', '39678901', 'Calle San Martín 123, Humahuaca', 'pramirez@gmail.com', '7788', 'Pedro', '3889876543'),
('1989-02-28', 8, 19, 'Fernández', '29456789', 'Av. Uruguay 456, Libertador', 'efernandez@gmail.com', '9900', 'Elena', '3884567890'),
('1993-11-13', 1, 20, 'Mendoza', '41345678', 'Calle Sarmiento 789, Yuto', 'amendoza@gmail.com', '1234', 'Andrés', '3885678901'),
('1991-05-17', 1, 21, 'Gómez', '31567890', 'Calle Belgrano 123, San Pedro', 'lgomez@gmail.com', '5678', 'Laura', '3886789012'),
('1995-08-25', 1, 22, 'Martínez', '42678901', 'Av. Rivadavia 456, Palpalá', 'dmartinez@gmail.com', '9101', 'Diego', '3887890123'),
('1988-09-12', 1, 23, 'López', '33456789', 'Calle San Martín 789, Perico', 'mlopez@gmail.com', '2345', 'María', '3888901234'),
('1994-12-03', 1, 24, 'Rodríguez', '44567890', 'Av. Independencia 321, El Carmen', 'prodriguez@gmail.com', '6789', 'Pablo', '3889012345'),
('1992-04-20', 1, 25, 'Pérez', '35345678', 'Calle Libertad 654, Humahuaca', 'cperez@gmail.com', '3456', 'Cecilia', '3880123456'),
('1996-07-14', 1, 26, 'Sánchez', '46678901', 'Av. 9 de Julio 987, Tilcara', 'fsanchez@gmail.com', '7890', 'Fernando', '3881234567'),
('1990-01-30', 1, 27, 'García', '37345678', 'Calle Las Heras 432, San Salvador', 'agarcia@gmail.com', '4567', 'Ana', '3882345678'),
('1997-10-18', 1, 28, 'Ramírez', '48789012', 'Av. Entre Ríos 876, La Quiaca', 'lramirez@gmail.com', '8901', 'Luis', '3883456789');
