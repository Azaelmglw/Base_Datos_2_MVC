dropdb PersonasDB;
creatdb PersonasDB;
psql PersonasDB;

CREATE TABLE Personas(
PersonaID           SERIAL                  NOT NULL                PRIMARY KEY,
Nombre              varchar(50)             NOT NULL,
Teléfono            varchar(13)             NOT NULL,
Email               varchar(30)             NOT NULL
);

CREATE TABLE Direcciones(
DirecciónID         SERIAL                  NOT NULL                PRIMARY KEY,
Calle               varchar(30)             NOT NULL,
Colonia             varchar(20)             NOT NULL,
Número              integer                 CHECK(Número > 0)       NOT NULL,
Ciudad              varchar(20)             NOT NULL,
Estado              varchar(15)             NOT NULL
);

INSERT INTO Personas(Nombre, Teléfono, Email)
VALUES
('Boris Mandujano Contreras',       '775-105-54-55',    'bomaco@gmail.com'),
('Cleyton Ordoñez Baeza',           '775-227-71-20',    'coba@gmail.com'),
('Atenea Godinez Moroco',           '442-537-70-82',    'agomo@gmail.com'),
('Erendira Palomos Gonzales',       '442-812-24-51',    'epago@gmail.com'),
('Ursula Viena  Perez',             '775-333-32-21',    'uvipe@gmail.com');

INSERT INTO Direcciones(Calle, Colonia, Número, Ciudad, Estado)
VALUES
('Pajaritos',               'Lindavista',       407,        'Tulancingo',       'Hidalgo'),
('Heroico Col. Militar',    'El Pueblito',      3,          'Corregidora',      'Querétaro'),
('Orión',                   'El Sol',           127,        'Corregidora',      'Querétaro'),
('Francisco Villa',         'Medias Tierras',   552,        'Tulancingo',       'Hidalgo'),
('Durazno',                 'Tejeda',           58,         'Corregidora',      'Querétaro');

