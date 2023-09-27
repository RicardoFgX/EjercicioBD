package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Asignatura;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ActAsig
 */
public class ActAsig extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ConexionBD accesoBaseDatos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActAsig() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // Establecer el tipo de contenido de la respuesta como HTML
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    // Obtener los valores del formulario enviados desde la solicitud POST
	    int id = Integer.parseInt(request.getParameter("id"));
	    String nombre = request.getParameter("nombre");
	    String clase = request.getParameter("clase");
	    String profesor = request.getParameter("profesor");
	    int numAlumnos = Integer.parseInt(request.getParameter("num_alumnos"));

	    // Acceder a la base de datos utilizando la clase ConexionBD
	    accesoBaseDatos = new ConexionBD();

	    // Actualizar la asignatura en la base de datos y obtener el resultado
        Asignatura asignatura = new Asignatura(id, nombre, clase, profesor, numAlumnos);

	    boolean exito = accesoBaseDatos.actualizarAsignatura(asignatura);

	    // Verificar si la actualización fue exitosa
	    if (exito) {
	        // Generar la página de éxito si la actualización se realizó con éxito
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Asignatura Actualizada</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Asignatura Actualizada Exitosamente</h1>");
	        out.println("<p>ID: " + id + "</p>");
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
	        out.println("<title>Error al Actualizar la Asignatura</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Error al Actualizar la Asignatura</h1>");
	        out.println("<p>Hubo un problema al actualizar la asignatura.</p>");
	        out.println("<a href='index.html'>Volver al Inicio</a>");
	        out.println("</body>");
	        out.println("</html>");
	    }
	}


}
