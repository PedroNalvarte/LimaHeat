package limaHeat.servlets;

import com.google.gson.Gson;
import general.json.JsonHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.List;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import limaHeat.dao.ILimaHeat;
import limaHeat.dao.impl.implLimaHeat;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "limaHeatServlet", urlPatterns = {"/limaHeatServlet"})
public class limaHeatServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String resultado;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        
        //action equals
        
            //String grupo = request.getParameter("grupo");
        
        if(accion.equals("iniciar-sesion")){
            
            String usuario = request.getParameter("usuario");
            String contra = request.getParameter("contra");
            
            ILimaHeat limaDao = new implLimaHeat();
            List<Object[]> listado = limaDao.inicioSesion(usuario);
            resultado = json.matriz(listado);
            
            response.getWriter().write(resultado);
            
        }else if(accion.equals("cambiarContrasena")){
            
            String usuario = request.getParameter("usuario");
            String nuevaContrasena = request.getParameter("nuevaContrasena");
            
            ILimaHeat limaDao = new implLimaHeat();
            
            List<Object[]> listado = limaDao.cambiarContrasena(usuario, nuevaContrasena);
            resultado = json.matriz(listado);

            response.getWriter().write(resultado);
        
        }else if(accion.equals("agregarHTTPSesion")){
        
            String usuario = request.getParameter("usuario");
            
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            
            String jsonLista = new Gson().toJson("Correcto");
            response.getWriter().write(jsonLista);
            
        }else if(accion.equals("obtenerHTTPSesion")){
            
            HttpSession session = request.getSession();
            String usuario = (String) session.getAttribute("usuario");
            
            ILimaHeat limaDao = new implLimaHeat();
            
            List<Object[]> listado = limaDao.obtenerPersonaPorUsuario(usuario);
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
