package limaHeat.servlets;

import general.json.JsonHelper;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import limaHeat.dao.IRegistrarPartido;
import limaHeat.dao.impl.impRegistrarPartido;

/**
 *
 * @author creo0
 */
@WebServlet(name = "registrarPartido", urlPatterns = {"/registrarPartido"})
public class registrarPartido extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String resultadoss;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");

        if (accion.equals("listarPartido")) {
            String temporada = request.getParameter("idTemporada");
            String equipo = request.getParameter("idEquipo");
            String categoria = request.getParameter("idCategoria");
            IRegistrarPartido registrarDao = new impRegistrarPartido();
            List<Object[]> listado = registrarDao.listarPartidos(equipo, categoria, temporada);
            String listar;
            listar = json.matriz(listado);
            response.getWriter().write(listar);

        } else if (accion.equals("eliminarPartido")) {
            String resultado;
            String id_partido = request.getParameter("ID_PARTIDO");

            IRegistrarPartido eliminarDao = new impRegistrarPartido();
            List<Object[]> eliminar = eliminarDao.eliminarPartido(id_partido);
            resultado = json.matriz(eliminar);

            response.getWriter().write(resultado);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        String resultadoss;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");

        if (accion.equals("obtenerPartido")) {
            String resultado;
            String ID_PARTIDO = request.getParameter("ID_PARTIDO");
            IRegistrarPartido obtenerDAO = new impRegistrarPartido();
            List<Object[]> partido = obtenerDAO.obtenerPartido(ID_PARTIDO);
            resultado = json.matriz(partido);
            System.out.println(resultado);
            response.getWriter().write(resultado);
        } else if (accion.equals("editarPartido")) {
            
            String resultado = request.getParameter("RESULTADO");
            String detalleResultado = request.getParameter("DETALLE_RESULTADO");
            String lugar = request.getParameter("LUGAR");
            String id_partido = request.getParameter("ID_PARTIDO");
            IRegistrarPartido editarPartidoDAO = new impRegistrarPartido();
            List<Object[]> editar = editarPartidoDAO.EditarPartido(resultado, detalleResultado, lugar, id_partido);
            resultado = json.matriz(editar);
            response.getWriter().write(resultado);
        } else if (accion.equals("registrarPartido")) {

            String resultado = request.getParameter("RESULTADO");
            String detalleResultado = request.getParameter("DETALLE_RESULTADO");
            String lugar = request.getParameter("LUGAR");
            IRegistrarPartido partidoDAO = new impRegistrarPartido();
            List<Object[]> listado = partidoDAO.registrarPartido(resultado, detalleResultado, lugar);

            resultadoss = json.matriz(listado);
            response.getWriter().write(resultadoss);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        String resultadoss;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");

    }

}
