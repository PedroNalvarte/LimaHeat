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
import limaHeat.dao.IMisEquipos;
import limaHeat.dao.impl.impMisEquipos;

@WebServlet(name = "misEquiposServlet", urlPatterns = {"/misEquiposServlet"})
public class misEquiposServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String resultado;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        
        if(accion.equals("cargarMisEquipos")){
               
            IMisEquipos misEquiposDao = new impMisEquipos();
            List<Object[]> listado = misEquiposDao.cargarMisEquipos();
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
            
        }else if(accion.equals("registrarEquipo")){
            
            String idCategoria = request.getParameter("idCategoria");
            String nombreEquipo = request.getParameter("nombreEquipo");
            
            IMisEquipos misEquiposDao = new impMisEquipos();
            List<Object[]> listado = misEquiposDao.registrarNuevoEquipo(nombreEquipo, idCategoria);
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
