CREATE TABLE IF NOT EXISTS viaggi(
id INT AUTO_INCREMENT,
destinazione VARCHAR (60) NOT NULL,
durata INT,
prezzoPersona DOUBLE(7, 2),
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS prenotazioni(
id INT AUTO_INCREMENT,
utente_id INT, 
viaggio_id INT,
prezzoTotale DOUBLE(7, 2),
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS utente(
id INT AUTO_INCREMENT,
nome VARCHAR (60) NOT NULL, 
cognome VARCHAR (60) NOT NULL, 
email VARCHAR (60) NOT NULL UNIQUE,
numeroCarta DECIMAL (16) NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO viaggi (destinazione, durata, prezzoPersona) VALUES
('New York', 8, 2500.00),
('Havana', 12, 3200.00),
('Barcellona', 6, 1800.00),
('Londra', 14, 5000.00),
('La Paz', 14, 4000.00),
('Amsterdam', 5, 3300.00),
('Singapore', 10, 4500.00),
('Tokyo', 14, 8000.00),
('Cairo', 10, 6000.00);

INSERT INTO utente (nome, cognome, email, numeroCarta) VALUES
('Giacomo', 'Zocchi', 'giacomo@gmail.com', 123456789012345),
('Lorenzo', 'Rosa', 'lorenzo@gmail.com', 098765432109876),
('Simone', 'Palermo', 'simonep@gmail.com', 123456789054321),
('Simone', 'Scarantino', 'simones@gmail.com', 657846789012345);

ALTER TABLE `prenotazioni` ADD CONSTRAINT `fk_utente_id` FOREIGN KEY (`utente_id`) REFERENCES `utente`(`id`) ON DELETE RESTRICT ON UPDATE CASCADE; ALTER TABLE `prenotazioni` ADD CONSTRAINT `fk_viaggio_id` FOREIGN KEY (`viaggio_id`) REFERENCES `viaggi`(`id`) ON DELETE RESTRICT ON UPDATE CASCADE;
