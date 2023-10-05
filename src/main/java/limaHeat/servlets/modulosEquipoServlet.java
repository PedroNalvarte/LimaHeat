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
import limaHeat.dao.IModulosEquipo;
import limaHeat.dao.impl.impModulosEquipo;

@WebServlet(name = "modulosEquipoServlet", urlPatterns = {"/modulosEquipoServlet"})
public class modulosEquipoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String resultado;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        
        if(accion.equals("cargarTitulo")){
        
            String idEquipo = request.getParameter("idEquipo");
            String idCategoria = request.getParameter("idCategoria");
            String idTemporada = request.getParameter("idTemporada");
            
            IModulosEquipo modulosequipoDao = new impModulosEquipo();
            List<Object[]> listado = modulosequipoDao.cargarTitulo(idEquipo, idCategoria, idTemporada);
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
