
package limaHeat.servlets;

import general.json.JsonHelper;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import limaHeat.dao.ICategoria;
import limaHeat.dao.IDetallePartido;
import limaHeat.dao.impl.impDetallePartido;
import limaHeat.dao.impl.implAgregarCategorias;


@WebServlet(name = "detallePartidoServlet", urlPatterns = {"/detallePartidoServlet"})
public class detallePartidoServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        
        if(accion.equals("ObtenerNombres")){
            String resultado;
            String temporada = request.getParameter("ID_TEMPORADA");
            String categoria = request.getParameter("ID_CATEGORIA");
            String equipo = request.getParameter("ID_EQUIPO");
            IDetallePartido obtenerDao = new impDetallePartido();
            List<Object[]> obtenerNombre = obtenerDao.CargarNombresJugadoresxCategoria(temporada,categoria,equipo);
            resultado = json.matriz(obtenerNombre);
            System.out.println(resultado);
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
