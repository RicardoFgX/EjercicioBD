
package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class Controlador
 */
public class Controlador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ConexionBD accesoBaseDatos;

    /**
     * Default constructor.
     */
    public Controlador() {
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Accedemos a la base de datos
        accesoBaseDatos = new ConexionBD();
        // Lista de asignaturas a mostrar
        List<String> listado =  accesoBaseDatos.listarAsignaturas();
        // Establecer el tipo de contenido a HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Escribir la lista de asignaturas con todos sus datos
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Listado de Asignaturas</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Listado de Asignaturas</h1>");
        out.println("<ul>");
        for (String asignatura : listado) {
            out.println("<li>" + asignatura + "</li>");
        }
        out.println("</ul>");
        out.println("<a href='index.html'>Volver al Inicio</a>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        // Accedemos a la base de datos
        accesoBaseDatos = new ConexionBD();
        // Obtener información de una asignatura por su ID
        String infoAsignatura =  accesoBaseDatos.obtenerAsignaturaPorID(id);

        // Escribir la información de la asignatura con todos sus datos
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Información de Asignatura</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Información de Asignatura</h1>");
        out.println("<ul>");
        out.println("<li>" + infoAsignatura + "</li>");
        out.println("</ul>");
        out.println("<a href='index.html'>Volver al Inicio</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
