/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package limaHeat.servlets;

import general.json.JsonHelper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import limaHeat.dao.IPartidosJugador;
import limaHeat.dao.impl.impPartidosJugador;

@WebServlet(name = "partidosJugadorServlet", urlPatterns = {"/partidosJugadorServlet"})
public class partidosJugadorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
        String lista;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        
         if(accion.equals("listarPartidos")){
             
            String resultado;
            String jugador = request.getParameter("jugador");
            String equipo = request.getParameter("equipo");
            IPartidosJugador partidosJugadorDao = new impPartidosJugador();
            List<Object[]> listado = partidosJugadorDao.listarPartidosJugador(jugador, equipo);
            resultado = json.matriz(listado);
          
            
            
            response.getWriter().write(resultado);
        }
         else if(accion.equals("listarEstadisticaLocal")){
             String resultado;
             String partido = request.getParameter("partido");
             String equipo = request.getParameter("equipo");
             IPartidosJugador partidosJugadorDao = new impPartidosJugador();
             List<Object[]> listado = partidosJugadorDao.mostrarEstadisticaPartidoLocal(partido, equipo);
             resultado = json.matriz(listado);
             
             response.getWriter().write(resultado);
                   
         }
         else if(accion.equals("cargarTitulos")){
             String resultado;
             String partido = request.getParameter("partido");
             IPartidosJugador partidosJugadorDao = new impPartidosJugador();
             List<Object[]> listado = partidosJugadorDao.cargarTitulos(partido);
             resultado = json.matriz(listado);
             response.getWriter().write(resultado);
             
         }
         else if(accion.equals("listarEstadisticaRival")){
             String resultado;
             String partido = request.getParameter("partido");
             String equipo = request.getParameter("equipo");
             IPartidosJugador partidosJugadorDao = new impPartidosJugador();
             List<Object[]> listado = partidosJugadorDao.mostrarEstadisticaPartidoRival(partido, equipo);
             resultado = json.matriz(listado);
             
             response.getWriter().write(resultado);
         }
         else if(accion.equals("rendimientoGeneral")){
             String resultado;
             String jugador = request.getParameter("jugador");
             IPartidosJugador partidosJugadorDao = new impPartidosJugador();
             List<Object[]> listado = partidosJugadorDao.mostrarRendimientoGeneral(jugador);
             resultado = json.matriz(listado);
             
             response.getWriter().write(resultado);
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

}
