/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
import limaHeat.dao.IEquiposRivales;
import limaHeat.dao.ILimaHeat;
import limaHeat.dao.impl.impEquiposRivales;
import limaHeat.dao.impl.implLimaHeat;

@WebServlet(name = "equiposRivalesServlet", urlPatterns = {"/equiposRivalesServlet"})
public class equiposRivalesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String resultado;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        
        if(accion.equals("listarCategorias")){
            
            IEquiposRivales equipoRivalesDao = new impEquiposRivales();
            List<Object[]> listado = equipoRivalesDao.listarCategorias();
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
            
        }else if(accion.equals("registrarEquipo")){
            
            String idCategoria = request.getParameter("idCategoria");
            String nombreEquipo = request.getParameter("nombreEquipo");
            
            IEquiposRivales equipoRivalesDao = new impEquiposRivales();
            List<Object[]> listado = equipoRivalesDao.registrarEquipos(idCategoria, nombreEquipo);
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
            
        }else if(accion.equals("listarEquiposRegistrados")){
            
            IEquiposRivales equipoRivalesDao = new impEquiposRivales();
            List<Object[]> listado = equipoRivalesDao.listarEquiposRegistrados();
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
            
        }else if(accion.equals("cargarDatosEquipo")){
            
            String idEquipo = request.getParameter("id");
            
            IEquiposRivales equipoRivalesDao = new impEquiposRivales();
            List<Object[]> listado = equipoRivalesDao.cargarDatosEquipo(idEquipo);
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
            
        }else if(accion.equals("editarEquipo")){
            
            String idCategoria = request.getParameter("idCategoria");
            String nombreEquipo = request.getParameter("nombreEquipo");
            String idEquipo = request.getParameter("idEquipo");
            
            IEquiposRivales equipoRivalesDao = new impEquiposRivales();
            List<Object[]> listado = equipoRivalesDao.editarEquipo(idCategoria, nombreEquipo, idEquipo);
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
