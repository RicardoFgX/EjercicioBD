package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Asignatura;

public class CreacionAsig extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ConexionBD accesoBaseDatos;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtener los valores del formulario
        String nombre = request.getParameter("nombre");
        String clase = request.getParameter("clase");
        String profesor = request.getParameter("profesor");
        int numAlumnos = Integer.parseInt(request.getParameter("num_alumnos"));

        // Accedemos a la base de datos
        accesoBaseDatos = new ConexionBD();

        // Insertar la nueva asignatura en la base de datos
        Asignatura asignatura = new Asignatura(nombre, clase, profesor, numAlumnos);
        boolean exito = accesoBaseDatos.insertarAsignatura(asignatura);

        // Verificar si la inserción fue exitosa
        if (exito) {
        	// Generar la página de éxito si la actualización se realizó con éxito
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Asignatura Creada</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Asignatura Creada Exitosamente</h1>");
            out.println("<p>Nombre: " + nombre + "</p>");
            out.println("<p>Clase: " + clase + "</p>");
            out.println("<p>Profesor Encargado: " + profesor + "</p>");
            out.println("<p>Número de Alumnos: " + numAlumnos + "</p>");
            out.println("<a href='index.html'>Volver al Inicio</a>");
            out.println("</body>");
            out.println("</html>");
        } else {
        	// Generar una página de error si la actualización no se realizó con éxito
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error al Crear la Asignatura</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error al Crear la Asignatura</h1>");
            out.println("<p>Hubo un problema al crear la asignatura.</p>");
            out.println("<a href='index.html'>Volver al Inicio</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
