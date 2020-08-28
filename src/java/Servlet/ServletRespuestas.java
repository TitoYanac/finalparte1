/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ServletRespuestas", urlPatterns = {"/ServletRespuestas"})
public class ServletRespuestas extends HttpServlet {

    private HttpSession sesion;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sesion = request.getSession(false);
        response.setContentType("text/html;charset=UTF-8");
        String accion = "" + request.getParameter("accion");
        
        
        String region = request.getParameter("region");
        String cantidad = request.getParameter("cantidad");
        switch(accion){
            case "Respuesta1":
                pregunta1(request,response);
            break;
            case "Respuesta2":
                pregunta2(request,response);
            break;
            case "Respuesta3":
                pregunta3(request,response);
            break;
            case "Respuesta4":
                pregunta4(request,response);
            break;
            case "Respuesta5":
                pregunta5(request,response);
            break;
            case "Respuesta6":
                pregunta6(request,response);
            break;
            case "Respuesta7":
                pregunta7(request,response);
            break;
            case "Respuesta8":
                pregunta8(request,response);
            break;
            default:
                  response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet ServletVista</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Servlet ServletVista at " + request.getContextPath() + "</h1>");
                        out.println("<h1>accion " + accion + "</h1>");
                        out.println("<h1>Ocurrio un error</h1>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void pregunta1(HttpServletRequest request, HttpServletResponse response) {
        
        sesion = request.getSession(false);
        String region = request.getParameter("region");
        String cantidad = request.getParameter("cantidad");
        sesion.setAttribute("region", region);
        sesion.setAttribute("cantidad", cantidad);
        
        try {
            request.getRequestDispatcher("respuesta1.jsp").include(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ServletRespuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pregunta2(HttpServletRequest request, HttpServletResponse response) {
        sesion = request.getSession(false);
        String grado = request.getParameter("grado");
        String productor = request.getParameter("productor");
        sesion.setAttribute("grado", grado);
        sesion.setAttribute("productor", productor);
        
        try {
            request.getRequestDispatcher("respuesta2.jsp").include(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ServletRespuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pregunta3(HttpServletRequest request, HttpServletResponse response) {
        sesion = request.getSession(false);        
        try {
            request.getRequestDispatcher("respuesta3.jsp").include(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ServletRespuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pregunta4(HttpServletRequest request, HttpServletResponse response) {
        sesion = request.getSession(false);        
        try {
            request.getRequestDispatcher("respuesta4.jsp").include(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ServletRespuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pregunta5(HttpServletRequest request, HttpServletResponse response) {
        sesion = request.getSession(false);
        String cantidad = request.getParameter("cantidad");
        sesion.setAttribute("cantidad", cantidad);
        
        try {
            request.getRequestDispatcher("respuesta5.jsp").include(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ServletRespuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pregunta6(HttpServletRequest request, HttpServletResponse response) {
        sesion = request.getSession(false);
        String cantidad = request.getParameter("cantidad");
        sesion.setAttribute("cantidad", cantidad);
        
        try {
            request.getRequestDispatcher("respuesta6.jsp").include(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ServletRespuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pregunta7(HttpServletRequest request, HttpServletResponse response) {
        sesion = request.getSession(false);
        String productor = request.getParameter("productor");
        sesion.setAttribute("productor", productor);
        
        try {
            request.getRequestDispatcher("respuesta7.jsp").include(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ServletRespuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pregunta8(HttpServletRequest request, HttpServletResponse response) {
        sesion = request.getSession(false);
        try {
            request.getRequestDispatcher("respuesta8.jsp").include(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ServletRespuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
