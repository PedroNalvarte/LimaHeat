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
import limaHeat.dao.IColaboradores;
import limaHeat.dao.impl.impColaboradores;

/**
 *
 * @author HUAWEI
 */
@WebServlet(name = "colaboradores", urlPatterns = {"/colaboradores"})
public class colaboradores extends HttpServlet {

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
        String Lista;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        
        if(accion.equals("listar")){
            String resultado;
            String equipo = request.getParameter("equipo");
            String temporada = request.getParameter("temporada");
            String categoria = request.getParameter("categoria");
            IColaboradores colaboradoresDao = new impColaboradores();
            List<Object[]> listado = colaboradoresDao.listarColaboradores(equipo, temporada, categoria);
            
            resultado = json.matriz(listado);
      

            response.getWriter().write(resultado);
        }
        else if(accion.equals("listarTipoDocumento")){
            String resultado;
            IColaboradores colaboradoresDao = new impColaboradores();
            List<Object[]> listado = colaboradoresDao.listarTipoDocumento();
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
        }
        else if(accion.equals("registrarColaborador")){
            String resultado;
            String nombre = request.getParameter("nombre");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");
            String idTipoDocumento = request.getParameter("idTipoDoc");
            String numDocumento = request.getParameter("numDocumento");
            String fecha_nacimiento = request.getParameter("fecha_nacimiento");
            String idEquipo = request.getParameter("idEquipo");
            String idCategoria = request.getParameter("idCategoria");
            String idTemporada = request.getParameter("idTemporada");
            
            IColaboradores colaboradoresDao = new impColaboradores();
            List<Object[]> listado = colaboradoresDao.registrarColaborador(nombre, apellido1, apellido2, idTipoDocumento, numDocumento, fecha_nacimiento, idEquipo, idCategoria, idTemporada);
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
        }
        else if(accion.equals("eliminarColaborador")){
            String resultado;
            String id = request.getParameter("idColaborador");
            
            IColaboradores colaboradoresDao = new impColaboradores();
            List<Object[]> listado = colaboradoresDao.eliminarColaborador(id);
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
        }
        else if(accion.equals("obtenerColaborador")){
            String resultado;
            String id = request.getParameter("idColaborador");
            IColaboradores colaboradoresDao = new impColaboradores();
            List<Object[]> listado = colaboradoresDao.obtenerColaborador(id);
            resultado = json.matriz(listado);
            response.getWriter().write(resultado);
        }
        else if(accion.equals("editarColaborador")){
            
            String resultado;
            String nombre = request.getParameter("nombre");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");
            String idTipoDocumento = request.getParameter("idTipoDoc");
            String numDocumento = request.getParameter("numDocumento");
            String fecha_nacimiento = request.getParameter("fecha_nacimiento");
            String id = request.getParameter("idColaborador");
            

            IColaboradores colaboradoresDao = new impColaboradores();
            List<Object[]> listado = colaboradoresDao.editarColaborador(nombre, apellido1, apellido2, idTipoDocumento, numDocumento, fecha_nacimiento, id);
            resultado = json.matriz(listado);
            response.getWriter().write(resultado);
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
        processRequest(request, response);
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
