/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package limaHeat.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import general.json.JsonHelper;
import java.util.List;
import limaHeat.dao.IRegistrarEstadisticasPartido;
import limaHeat.dao.impl.impRegistrarEstadisticasPartido;

/**
 *
 * @author HUAWEI
 */
@WebServlet(name = "registrarEstadisticasPartidoServlet", urlPatterns = {"/registrarEstadisticasPartidoServlet"})
public class registrarEstadisticaPartidoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String lista;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");

        if (accion.equals("listarEquiposRivales")) {
            String idTemporada = request.getParameter("idTemporada");
            String idCategoria = request.getParameter("idCategoria");
            String idEquipo = request.getParameter("idEquipo");

            IRegistrarEstadisticasPartido registrarPartidoDao = new impRegistrarEstadisticasPartido();
            List<Object[]> listado = registrarPartidoDao.listarEquiposRivales(idEquipo, idTemporada, idCategoria);
            lista = json.matriz(listado);

            response.getWriter().write(lista);
        } else if (accion.equals("listarJugadoresLocales")) {
            String idTemporada = request.getParameter("idTemporada");
            String idCategoria = request.getParameter("idCategoria");
            String idEquipo = request.getParameter("idEquipo");

            IRegistrarEstadisticasPartido registrarPartidoDao = new impRegistrarEstadisticasPartido();
            List<Object[]> listado = registrarPartidoDao.listarJugadores(idEquipo, idTemporada, idCategoria);
            lista = json.matriz(listado);

            response.getWriter().write(lista);
        } 
        
        else if (accion.equals("registrarEstadisticas")) {
            
            String idEquipoLoc = request.getParameter("idEquipoLoc");
            String idCategoriaLoc = request.getParameter("idCategoriaLoc");
            String idTemporadaLoc = request.getParameter("idTemporadaLoc");
            String idEquipoRiv = request.getParameter("idEquipoRiv");
            String idCategoriaRiv = request.getParameter("idCategoriaRiv");
            String idTemporadaRiv = request.getParameter("idTemporadaRiv");
            String lugar = request.getParameter("lugar");
            String fechaPartido = request.getParameter("fechaPartido");
            String detalleResultado = request.getParameter("detalleResultado");
            String resultado = request.getParameter("resultado");
            String idJugadoresLoc = request.getParameter("idJugadoresLoc");
            String MINloc = request.getParameter("MINloc");
            String SECloc = request.getParameter("SECloc");
            String TCAloc = request.getParameter("TCAloc");
            String TCRloc = request.getParameter("TCRloc");
            String dosTPCAloc = request.getParameter("dosTPCAloc");
            String dosTPCRloc = request.getParameter("dosTPCRloc");
            String tresPTCAloc = request.getParameter("tresPTCAloc");
            String tresPTCRloc = request.getParameter("tresPTCRloc");
            String TLAloc = request.getParameter("TLAloc");
            String TLRloc = request.getParameter("TLRloc");
            String REBROloc = request.getParameter("REBROloc");
            String REBRDloc = request.getParameter("REBRDloc");
            String ASloc = request.getParameter("ASloc");
            String TOloc = request.getParameter("TOloc");
            String RBloc = request.getParameter("RBloc");
            String TPloc = request.getParameter("TPloc");
            String FPCloc = request.getParameter("FPCloc");
            String FPDloc = request.getParameter("FPDloc");
            String masmenosloc = request.getParameter("masmenosloc");
            String PTSloc = request.getParameter("PTSloc");
            String idJugadoresRiv = request.getParameter("idJugadoresRiv");
            String MINriv = request.getParameter("MINriv");
            String SECriv = request.getParameter("SECriv");
            String TCAriv = request.getParameter("TCAriv");
            String TCRriv = request.getParameter("TCRriv");
            String dosTPCAriv = request.getParameter("dosTPCAriv");
            String dosTPCRriv = request.getParameter("dosTPCRriv");
            String tresPTCAriv = request.getParameter("tresPTCAriv");
            String tresPTCRriv = request.getParameter("tresPTCRriv");
            String TLAriv = request.getParameter("TLAriv");
            String TLRriv = request.getParameter("TLRriv");
            String REBROriv = request.getParameter("REBROriv");
            String REBRDriv = request.getParameter("REBRDriv");
            String ASriv = request.getParameter("ASriv");
            String TOriv = request.getParameter("TOriv");
            String RBriv = request.getParameter("RBriv");
            String TPriv = request.getParameter("TPriv");
            String FPCriv = request.getParameter("FPCriv");
            String FPDriv = request.getParameter("FPDriv");
            String masmenosriv = request.getParameter("masmenosriv");
            String PTSriv = request.getParameter("PTSriv");
            
            /*
            System.out.println("Datos local"+idEquipoLoc+" / "+idCategoriaLoc+" / "+idTemporadaLoc+" datos rival "+idEquipoRiv+" / "+idCategoriaRiv+" / "+
            idTemporadaRiv+" datos partido "+lugar+" / "+detalleResultado+" / "+resultado+" estadistica local "+" "+idJugadoresLoc +" "+MINloc+" / "+SECloc+" / "+TCAloc+" / "+
            TCRloc+" / "+dosTPCAloc+" / "+dosTPCRloc+" / "+tresPTCAloc+" / "+tresPTCRloc+" / "+TLAloc+" / "+TLRloc+" / "+REBROloc+" / "+
            REBRDloc+" / "+ASloc+" / "+TOloc+" / "+RBloc+" / "+TPloc+" / "+FPCloc+" / "+FPDloc+" / "+masmenosloc+" / "+PTSloc+" estadisticas rival "+
            " "+idJugadoresRiv +" "+MINriv+" / "+SECriv+" / "+TCAriv+" / "+TCRriv+" / "+dosTPCAriv+" / "+dosTPCRriv+" / "+tresPTCAriv+" / "+tresPTCRriv+" / "+TLAriv+" / "+TLRriv+" / "+
            REBROriv+" / "+REBRDriv+" / "+ASriv+" / "+TOriv+" / "+RBriv+" / "+TPriv+" / "+FPCriv+" / "+FPDriv+" / "+masmenosriv+" / "+PTSriv);
            */
            

            IRegistrarEstadisticasPartido registrarPartidoDao = new impRegistrarEstadisticasPartido();
            List<Object[]> listado = registrarPartidoDao.registarEstadisticas(idEquipoLoc, idCategoriaLoc, idTemporadaLoc, idEquipoRiv, idCategoriaRiv, idTemporadaRiv, lugar, fechaPartido, detalleResultado, resultado, idJugadoresLoc, MINloc, SECloc, TCAloc, TCRloc, dosTPCAloc, dosTPCRloc, tresPTCAloc, tresPTCRloc, TLAloc, TLRloc, REBROloc, REBRDloc, ASloc, TOloc, RBloc, TPloc, FPCloc, FPDloc, masmenosloc, PTSloc, idJugadoresRiv, MINriv, SECriv, TCAriv, TCRriv, dosTPCAriv, dosTPCRriv, tresPTCAriv, tresPTCRriv, TLAriv, TLRriv, REBROriv, REBRDriv, ASriv, TOriv, RBriv, TPriv, FPCriv, FPDriv, masmenosriv, PTSriv);
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
