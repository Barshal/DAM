-- ============================================
--   CREACIÓN DE BASE DE DATOS
-- ============================================
CREATE DATABASE IF NOT EXISTS trail;
USE trail;

-- ============================================
--   TABLA: CORREDORES
-- ============================================
CREATE TABLE corredores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    dni VARCHAR(20) UNIQUE,
    edad INT,
    club VARCHAR(150)
);

-- ============================================
--   TABLA: CARRERAS
-- ============================================
CREATE TABLE carreras (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    ubicacion VARCHAR(200),
    distancia_km DECIMAL(5,2),
    fecha DATE
);

-- ============================================
--   TABLA: INSCRIPCIONES
-- ============================================
CREATE TABLE inscripciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dorsal INT,
    tiempo_oficial VARCHAR(20),
    corredor_id BIGINT NOT NULL,
    carrera_id BIGINT NOT NULL,
    CONSTRAINT fk_inscripcion_corredor
        FOREIGN KEY (corredor_id)
        REFERENCES corredores(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_inscripcion_carrera
        FOREIGN KEY (carrera_id)
        REFERENCES carreras(id)
        ON DELETE CASCADE
);

-- ============================================
--   INSERTS: CORREDORES
-- ============================================
INSERT INTO corredores (nombre, dni, edad, club) VALUES
('Héctor López', '12345678A', 28, 'Trail Madrid'),
('Laura Sánchez', '87654321B', 32, 'Correcaminos'),
('Carlos Ruiz', '11223344C', 40, 'Montaña Viva'),
('Ana Torres', '99887766D', 25, 'Runners Team'),
('Javier Martín', '55667788E', 35, 'Trail Warriors');

-- ============================================
--   INSERTS: CARRERAS
-- ============================================
INSERT INTO carreras (nombre, ubicacion, distancia_km, fecha) VALUES
('Trail Sierra Norte', 'Madrid', 21.00, '2024-05-12'),
('Ultra Trail Gredos', 'Ávila', 65.50, '2024-06-20'),
('Vertical Pico del Lobo', 'Guadalajara', 5.20, '2024-07-10'),
('Trail Costa Brava', 'Girona', 15.00, '2024-04-03'),
('Ultra Pirineos', 'Lleida', 90.00, '2024-09-15');

-- ============================================
--   INSERTS: INSCRIPCIONES
-- ============================================
INSERT INTO inscripciones (dorsal, tiempo_oficial, corredor_id, carrera_id) VALUES
(101, '02:15:30', 1, 1),
(102, '08:45:10', 2, 2),
(103, '00:45:20', 3, 3),
(104, '01:25:50', 4, 4),
(105, '12:10:00', 5, 5),
(106, NULL, 1, 2),  -- Héctor inscrito pero sin tiempo aún
(107, NULL, 3, 1);  -- Carlos inscrito en otra carrera
