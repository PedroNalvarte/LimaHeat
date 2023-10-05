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
import limaHeat.dao.IEquipoTemporada;
import limaHeat.dao.impl.impEquipoTemporada;


@WebServlet(name = "equipoTemporadaServlet", urlPatterns = {"/equipoTemporadaServlet"})
public class equipoTemporadaServlet extends HttpServlet {

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
            
            IEquipoTemporada equipoTemporadaDao = new impEquipoTemporada();
            List<Object[]> listado = equipoTemporadaDao.cargarTitulo(idEquipo, idCategoria);
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
        
        }else if(accion.equals("cargarTipoDni")){
            
            IEquipoTemporada equipoTemporadaDao = new impEquipoTemporada();
            List<Object[]> listado = equipoTemporadaDao.cargarTipoDni();
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
        
        }else if(accion.equals("cargarDDLTemporadas")){
            
            IEquipoTemporada equipoTemporadaDao = new impEquipoTemporada();
            List<Object[]> listado = equipoTemporadaDao.cargarDDLTemporadas();
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
        
        }else if(accion.equals("registrarTemporada")){
            
            System.out.println("llegue");
            
            String nombres = request.getParameter("nombres");
            String ape1 = request.getParameter("ape1");
            String ape2 = request.getParameter("ape2");
            String tipoDocIde = request.getParameter("tipoDocIde");
            String numDocIDe = request.getParameter("numDocIDe");
            String idTemporada = request.getParameter("idTemporada");
            String idEquipo = request.getParameter("idEquipo");
            String idCategoria = request.getParameter("idCategoria");
            
            IEquipoTemporada equipoTemporadaDao = new impEquipoTemporada();
            List<Object[]> listado = equipoTemporadaDao.registrarTemporada(nombres, ape1, ape2, tipoDocIde, numDocIDe, idTemporada, idEquipo, idCategoria);
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
        
        }else if(accion.equals("listarTemporadas")){
            
            String idEquipo = request.getParameter("idEquipo");
            String idCategoria = request.getParameter("idCategoria");
            
            System.out.println("hola servlet");
            
            IEquipoTemporada equipoTemporadaDao = new impEquipoTemporada();
            List<Object[]> listado = equipoTemporadaDao.listarTemporadas(idEquipo, idCategoria);
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
