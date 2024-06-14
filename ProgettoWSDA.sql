CREATE DATABASE IF NOT EXISTS ProgettoWSDA;

USE ProgettoWSDA;

CREATE TABLE Impianti (
    idImpianto VARCHAR(50) PRIMARY KEY,
    descrizione VARCHAR(255),
    latitudine DECIMAL(10, 8),
    longitudine DECIMAL(11, 8),
    palinsesto_path VARCHAR(255),
    stato BOOLEAN
);

SELECT * FROM Impianti;

INSERT INTO Impianti (idImpianto, descrizione, latitudine, longitudine, palinsesto_path, stato) VALUES
('I1',  'Viale delle Scienze',38.12599945,13.35087013, '../../file_xml/palinsesto1.xml', 0),
('I2',  'Via della Libertà',38.10597992,13.35400009, '../../file_xml/palinsesto2.xml', 0),
('I3',  'Viale Regione Siciliana',38.09011841,13.34407997, '../../file_xml/palinsesto3.xml', 0),
('I4',  'Stadio Renzo Barbera',38.15267944,13.34265995, '../../file_xml/palinsesto4.xml', 0),
('I5',  'Spiaggia Mondello',38.20534134,13.32499981, '../../file_xml/palinsesto5.xml', 0);


CREATE TABLE Segnalazioni (
    idSegnalazione INT PRIMARY KEY AUTO_INCREMENT,
    idImpianto VARCHAR(50),
    idPalinsesto VARCHAR(50),
    idCartellone VARCHAR(50),
    durata INT,
    timestamp DATETIME,
    FOREIGN KEY (idImpianto) REFERENCES Impianti(idImpianto)
);

SELECT * FROM Segnalazioni;

CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(45) NOT NULL,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(64) NOT NULL,
    enabled TINYINT(4) DEFAULT NULL,
    PRIMARY KEY (user_id),
    UNIQUE KEY email_UNIQUE (email)
);

SELECT * FROM users;

INSERT INTO users (email, username, password, enabled) VALUES 
    ('sanfi@gmail.com', 'Giuseppe', '$2y$10$3gb3mMHTyTlnLMFtRj3OK.OVYClVhAGhls49Cq88i.WOqiETYhilS', 1), -- pass: sanfi
    ('mineo@gmail.com', 'Federico', '$2y$10$kbridADgpeNvS5h.xQqcsOW90xI4ffNlYR57D9GcC1jKlD1gKnxyq', 1), -- pass: mineo
    ('lindiner@gmail.com', 'Francesco', '$2y$10$CnsprNhyjxtviAQVdffQH.RmEkWvSi3tq8zVmhIG4T8061IBtlQF6', 1); -- pass: linidiner

CREATE TABLE roles (
    role_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (role_id)
);

SELECT * FROM roles;

INSERT INTO roles (name) VALUES ('USER');
INSERT INTO roles (name) VALUES ('CREATOR');
INSERT INTO roles (name) VALUES ('EDITOR');
INSERT INTO roles (name) VALUES ('ADMIN');

CREATE TABLE users_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    KEY user_fk_idx (user_id),
    KEY role_fk_idx (role_id),
    CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES roles(role_id),
    CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users(user_id)
);

SELECT * FROM users_roles;

INSERT INTO users_roles (user_id, role_id) VALUES 
    (1, 4),
    (2, 4),
    (3, 4);
    
CREATE TABLE Palinsesto (
    id_palinsesto VARCHAR(50) PRIMARY KEY,
    path_palinsesto VARCHAR(50)
);

SELECT * FROM Palinsesto;

INSERT INTO Palinsesto (id_palinsesto, path_palinsesto) VALUES
('P1', '../../file_xml/palinsesto1.xml'),
('P2', '../../file_xml/palinsesto2.xml'),
('P3', '../../file_xml/palinsesto3.xml'),
('P4', '../../file_xml/palinsesto4.xml'),
('P5', '../../file_xml/palinsesto5.xml');

CREATE TABLE Cartellone (
	id_cartellone VARCHAR(50) PRIMARY KEY,
    nome_cartellone VARCHAR(50)
);

SELECT * FROM Cartellone;

INSERT INTO Cartellone (id_cartellone, nome_cartellone) VALUES
('C1', 'caffe.html'), ('C2', 'coca_cola.html'), ('C3', 'concessionaria.html'), ('C4', 'pneumatici.html'), ('C5', 'scarpe.html'),
('C6', 'serieTV.html'), ('C7', 'sushi.html'), ('C8', 'telefoni.html'), ('C9', '.vestiti.html'), ('C10', 'voli.html');