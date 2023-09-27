
package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DelAsig
 */
public class DelAsig extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConexionBD accesoBaseDatos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelAsig() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        int id = Integer.parseInt(request.getParameter("id"));
        
     // Accedemos a la base de datos
     		accesoBaseDatos = new ConexionBD();
     		
     	// Insertar la nueva asignatura en la base de datos
            boolean exito = accesoBaseDatos.borrarAsignaturaPorID(id);

            // Verificar si la inserción fue exitosa
            if (exito) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Asignatura Borrada</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Asignatura Borrada Exitosamente</h1>");
                out.println("<br>");
                out.println("<a href='index.html'>Volver al Inicio</a>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error al Borrar la Asignatura</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Error al Borrar la Asignatura</h1>");
                out.println("<p>Hubo un problema al borrar la asignatura.</p>");
                out.println("<a href='index.html'>Volver al Inicio</a>");
                out.println("</body>");
                out.println("</html>");
            }
	}
}
