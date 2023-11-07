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
import limaHeat.dao.IDetallePartido;
import limaHeat.dao.IGestionarUsuarios;
import limaHeat.dao.impl.impDetallePartido;
import limaHeat.dao.impl.impGestionarUsuarios;

@WebServlet(name = "gestionarUsuariosServlet", urlPatterns = {"/gestionarUsuariosServlet"})
public class gestionarUsuariosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        String resultado;
        
        if(accion.equals("listarUsuarios")){
            
            //String temporada = request.getParameter("ID_TEMPORADA");

            IGestionarUsuarios usuariosDAO = new impGestionarUsuarios();
            List<Object[]> lista = usuariosDAO.listarUsuarios();
            resultado = json.matriz(lista);
            response.getWriter().write(resultado);
      
        }if(accion.equals("eliminarCuenta")){
            
            String idParticipante = request.getParameter("idParticipante");

            IGestionarUsuarios usuariosDAO = new impGestionarUsuarios();
            List<Object[]> lista = usuariosDAO.eliminarCuenta(idParticipante);
            resultado = json.matriz(lista);
            response.getWriter().write(resultado);
      
        }if(accion.equals("reiniciarCredenciales")){
            
            String idParticipante = request.getParameter("idParticipante");

            IGestionarUsuarios usuariosDAO = new impGestionarUsuarios();
            List<Object[]> lista = usuariosDAO.reiniciarCredenciales(idParticipante);
            resultado = json.matriz(lista);
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
