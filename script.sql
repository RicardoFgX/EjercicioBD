-- Creación de la base de datos (si no existe)
CREATE DATABASE IF NOT EXISTS mi_bbdd_proyecto;
USE mi_bbdd_proyecto;
CREATE TABLE asignaturas (
   id INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(255) NOT NULL,
   clase VARCHAR(255) NOT NULL,
   profesor_encargado VARCHAR(255) NOT NULL,
   numero_alumnos INT
);
-- Insertar 10 asignaturas ficticias en la tabla "asignaturas"
INSERT INTO asignaturas (nombre, clase, profesor_encargado, numero_alumnos) VALUES
   ('Matemáticas', 'Aula 101', 'Profesor A', 30),
   ('Historia', 'Aula 102', 'Profesora B', 25),
   ('Inglés', 'Aula 103', 'Profesora C', 20),
   ('Ciencias', 'Aula 104', 'Profesor D', 28),
   ('Literatura', 'Aula 105', 'Profesora E', 22),
   ('Programación', 'Aula 201', 'Profesor F', 18),
   ('Arte', 'Aula 202', 'Profesora G', 15),
   ('Educación Física', 'Aula 203', 'Profesor H', 32),
   ('Química', 'Aula 204', 'Profesora I', 27),
   ('Geografía', 'Aula 205', 'Profesor J', 23);