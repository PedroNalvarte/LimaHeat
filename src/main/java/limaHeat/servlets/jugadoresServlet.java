package limaHeat.servlets;

import general.json.JsonHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import limaHeat.dao.IJugadores;
import limaHeat.dao.impl.impJugadores;

@WebServlet(name = "jugadoresServlet", urlPatterns = {"/jugadoresServlet"})
public class jugadoresServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String resultado;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        
        if(accion.equals("cargarDDLPosicion")){
        
            IJugadores jugadoresDAO = new impJugadores();
            List<Object[]> listado = jugadoresDAO.cargarDDLPosicion();
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
            
        }else if(accion.equals("registrar-jugador")){
            
            String nom = request.getParameter("nom");
            String ape1 = request.getParameter("ape1");
            String ape2 = request.getParameter("ape2");
            String tipDoc = request.getParameter("tipDoc");
            String numDoc = request.getParameter("numDoc");
            String peso = request.getParameter("peso");
            String altura = request.getParameter("altura");
            String fecnac = request.getParameter("fecnac");
            String posicion = request.getParameter("posicion");
            String numeroDorsal = request.getParameter("numeroDorsal");
            String idEquipo = request.getParameter("idEquipo");
            String idCategoria = request.getParameter("idCategoria");
            String idTemporada = request.getParameter("idTemporada");
            
            IJugadores jugadoresDAO = new impJugadores();
            List<Object[]> listado = jugadoresDAO.registrarJugador(nom, ape1, ape2, tipDoc, numDoc, peso, altura, fecnac, posicion, numeroDorsal, idEquipo, idCategoria, idTemporada);
            
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
            
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
