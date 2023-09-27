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
import limaHeat.dao.ITemporadas;
import limaHeat.dao.impl.implTemporadas;
/**
 *
 * @author HUAWEI
 */
@WebServlet(name = "temporadasServlet", urlPatterns = {"/temporadasServlet"})
public class temporadasServlet extends HttpServlet {

     private static final long serialVersionUID = 1L;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String lista;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        

        if(accion.equals("listar")){
             ITemporadas temporadasDao = new implTemporadas();
            List<Object[]> listado = temporadasDao.listarTemporadas();
            lista = json.matriz(listado);
            
            response.getWriter().write(lista);
        }
        else if(accion.equals("listarTipos")){
            ITemporadas temporadasDao = new implTemporadas();
            List<Object[]> listado = temporadasDao.tiposTemporadas();
            String listaTipos;
            listaTipos = json.matriz(listado);
            
            response.getWriter().write(listaTipos);
        }
        else if(accion.equals("registrar-temporada")){
           
            String resultado;
            String nombreTemporada = request.getParameter("nombreTemporada");
            String tipoTemporada = request.getParameter("tipoTemporada");
            String fechaInicio = request.getParameter("fechaInicio");
            String fechaFin = request.getParameter("fechaFin");
            
           ITemporadas temporadaDao = new implTemporadas();
           List<Object[]> listado = temporadaDao.registrarTemporada(nombreTemporada, tipoTemporada, fechaInicio, fechaFin);
           
           resultado = json.matriz(listado);
      

            response.getWriter().write(resultado);
       
        }
        else if(accion.equals("obtener-temporada")){
            String resultado;
            String temporadaSeleccionada = request.getParameter("idTemporada");
            ITemporadas temporadasDao = new implTemporadas();
            List<Object[]> temporada = temporadasDao.obtenerTemporada(temporadaSeleccionada);
            resultado = json.matriz(temporada);
            System.out.println(resultado);
            response.getWriter().write(resultado);
          
        }
        else if(accion.equals("eliminar-temporada")){
            String resultado;
            String temporadaSeleccionada = request.getParameter("idTemporada");
            ITemporadas temporadasDao = new implTemporadas();
            List<Object[]> temporada = temporadasDao.eliminarTemporada(temporadaSeleccionada);
            resultado = json.matriz(temporada);
            response.getWriter().write(resultado);
            
         
        }
        else if(accion.equals("editar-temporada")){
            String resultado;
            String nombreTemporada = request.getParameter("nombreTemporada");
            String tipoTemporada = request.getParameter("tipoTemporada");
            String fechaInicio = request.getParameter("fechaInicio");
            String fechaFin = request.getParameter("fechaFin");
            String temporadaSeleccionada = request.getParameter("idTemporada");
            
            ITemporadas temporadasDao = new implTemporadas();
            List<Object[]> temporada = temporadasDao.editarTemporada(nombreTemporada, tipoTemporada, fechaInicio, fechaFin, temporadaSeleccionada);
           resultado = json.matriz(temporada);
           response.getWriter().write(resultado);
        }
       
              
    }

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("application/json;charset=UTF-8");
           /* String resultado;
            request.setCharacterEncoding("UTF-8");
            

            String nombreTemporada = request.getParameter("nombreTemporada");
            String tipoTemporada = request.getParameter("tipoTemporada");
            String fechaInicio = request.getParameter("fechaInicio");
            String fechaFin = request.getParameter("fechaFin");      
         

            ITemporadas temporadaDao = new implTemporadas();
            boolean registro = temporadaDao.registrarTemporadas(nombreTemporada, tipoTemporada, fechaInicio, fechaFin);

            if (registro) {
                resultado = "Ok";
                response.setStatus(HttpServletResponse.SC_OK);
                response.sendRedirect("temporadas.jsp"); 
            } else {
                resultado = "Error";
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }

            response.getWriter().write(resultado);


        }*/
           
           processRequest(request, response);
     }
}


