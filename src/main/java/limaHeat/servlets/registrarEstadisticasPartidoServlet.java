/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package limaHeat.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import general.json.JsonHelper;
import java.io.PrintWriter;
import java.util.List;
import limaHeat.dao.IRegistrarEstadisticasPartido;
import limaHeat.dao.impl.impRegistrarEstadisticasPartido;
/**
 *
 * @author HUAWEI
 */
@WebServlet(name = "registrarEstadisticasPartidoServlet", urlPatterns = {"/registrarEstadisticasPartidoServlet"})
public class registrarEstadisticasPartidoServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String lista;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        
          if(accion.equals("listarEquiposRivales")){
            String idTemporada = request.getParameter("idTemporada");
            String idCategoria = request.getParameter("idCategoria");
            String idEquipo = request.getParameter("idEquipo");
            
             IRegistrarEstadisticasPartido registrarPartidoDao = new impRegistrarEstadisticasPartido();
            List<Object[]> listado = registrarPartidoDao.listarEquiposRivales(idEquipo, idTemporada, idCategoria);
            lista = json.matriz(listado);
            
            response.getWriter().write(lista);
        }
          else if(accion.equals("listarJugadoresLocales")){
            String idTemporada = request.getParameter("idTemporada");
            String idCategoria = request.getParameter("idCategoria");
            String idEquipo = request.getParameter("idEquipo");
            
              IRegistrarEstadisticasPartido registrarPartidoDao = new impRegistrarEstadisticasPartido();
            List<Object[]> listado = registrarPartidoDao.listarJugadores(idEquipo, idTemporada, idCategoria);
            lista = json.matriz(listado);
            
            response.getWriter().write(lista);
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
