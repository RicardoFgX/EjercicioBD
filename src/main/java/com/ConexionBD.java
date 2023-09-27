package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Asignatura;

public class ConexionBD {

    // Método para listar todas las asignaturas en la base de datos
    public List<String> listarAsignaturas() {
        // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/mi_bbdd_proyecto";
        String usuario = "root";
        String contraseña = "1234";
        List<String> asignaturas = new ArrayList<>();

        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
                String consulta = "SELECT * FROM asignaturas";
                try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(consulta)) {
                    // Bucle para obtener y listar información de asignaturas
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nombre = rs.getString("nombre");
                        String clase = rs.getString("clase");
                        String profesor = rs.getString("profesor_encargado");
                        int numeroAlumnos = rs.getInt("numero_alumnos");

                        String asignaturaInfo = String.format(
                                "ID: %d, Nombre: %s, Clase: %s, Profesor: %s, Número de Alumnos: %d", id, nombre, clase,
                                profesor, numeroAlumnos);
                        asignaturas.add(asignaturaInfo);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return asignaturas;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return asignaturas;
    }

    // Método para obtener información de una asignatura por su ID
    public String obtenerAsignaturaPorID(int idParam) {
        // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/mi_bbdd_proyecto";
        String usuario = "root";
        String contraseña = "1234";
        String asignaturaInfo = "No existe asignatura con esa ID";

        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
                String consulta = "SELECT * FROM asignaturas WHERE id = ?";
                try (PreparedStatement pstmt = conexion.prepareStatement(consulta)) {
                    pstmt.setInt(1, idParam);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            int id = rs.getInt("id");
                            String nombre = rs.getString("nombre");
                            String clase = rs.getString("clase");
                            String profesor = rs.getString("profesor_encargado");
                            int numeroAlumnos = rs.getInt("numero_alumnos");

                            asignaturaInfo = String.format(
                                    "ID: %d, Nombre: %s, Clase: %s, Profesor: %s, Número de Alumnos: %d", id, nombre,
                                    clase, profesor, numeroAlumnos);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return asignaturaInfo;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return asignaturaInfo;
    }

    // Método para insertar una asignatura en la base de datos
    public boolean insertarAsignatura(Asignatura asignatura) {
        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/mi_bbdd_proyecto";
        String usuario = "root";
        String contraseña = "1234";
        boolean exito = false;
        String sql = "INSERT INTO asignaturas (nombre, clase, profesor_encargado, numero_alumnos) VALUES (?, ?, ?, ?)";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, asignatura.getNombre());
            pstmt.setString(2, asignatura.getClase());
            pstmt.setString(3, asignatura.getProfesor_encargado());
            pstmt.setInt(4, asignatura.getNumero_alumnos());

            int filasInsertadas = pstmt.executeUpdate();

            if (filasInsertadas > 0) {
                exito = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exito;
    }

    // Método para actualizar una asignatura en la base de datos por su ID
    public boolean actualizarAsignatura(Asignatura asignatura) {
        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/mi_bbdd_proyecto";
        String usuario = "root";
        String contraseña = "1234";
        boolean exito = false;
        String sql = "UPDATE asignaturas SET nombre=?, clase=?, profesor_encargado=?, numero_alumnos=? WHERE id=?";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        	pstmt.setString(1, asignatura.getNombre());
            pstmt.setString(2, asignatura.getClase());
            pstmt.setString(3, asignatura.getProfesor_encargado());
            pstmt.setInt(4, asignatura.getNumero_alumnos());
            pstmt.setInt(5, asignatura.getId());

            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                exito = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exito;
    }

    // Método para borrar una asignatura de la base de datos por su ID
    public boolean borrarAsignaturaPorID(int id) {
        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/mi_bbdd_proyecto";
        String usuario = "root";
        String contraseña = "1234";
        boolean exito = false;
        String sql = "DELETE FROM asignaturas WHERE id=?";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                exito = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exito;
    }
}
