package limaHeat.servlets;

import general.json.JsonHelper;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import limaHeat.dao.IHistorialPartidos;
import limaHeat.dao.IJugadores;
import limaHeat.dao.impl.impHistorialPartidos;
import limaHeat.dao.impl.impJugadores;

@WebServlet(name = "historialPartidosServlet", urlPatterns = {"/historialPartidosServlet"})
public class historialPartidos extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String resultado;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        
        if(accion.equals("cargarRendimientoGeneral")){
            
            String idEquipo = request.getParameter("idEquipo");
            String idCategoria = request.getParameter("idCategoria");
            String idTemporada = request.getParameter("idTemporada");
        
            IHistorialPartidos histoPartidosDAO = new impHistorialPartidos();
            List<Object[]> listado = histoPartidosDAO.cargarRendimientoGeneral(idEquipo, idCategoria, idTemporada);
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
            
        }else if(accion.equals("eliminarPartido")){
            
            String idPartido = request.getParameter("idPartido");
            
            IHistorialPartidos histoPartidosDAO = new impHistorialPartidos();
            List<Object[]> listado = histoPartidosDAO.eliminarPartido(idPartido);
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
