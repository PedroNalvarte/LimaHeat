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
import limaHeat.bean.Usuario;
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
            
            ILimaHeat limaDao = new implLimaHeat();
            
            //"ID_PARTICIPANTE"/"ID_TIPO_PARTICIPANTE"/"TIPO_PARTICIPANTE"/"NOMBRES"/"APELLIDO_1"/"APELLIDO_2"/"TIPO_DOCUMENTO_IDENTIDAD"/
            //"NUMERO_DOCUMENTO_IDENTIDAD"/"FECHA_NACIMIENTO"/"ID_TIPO_CUENTA"/"TIPO_CUENTA"
            List<Object[]> listado = limaDao.obtenerDatosPorUsuario(usuario);
            resultado = json.matriz(listado);
            
            JSONObject jsonObject = new JSONObject(resultado);
            JSONArray rowsArray = jsonObject.getJSONArray("rows");
            JSONArray innerArray = rowsArray.getJSONArray(0);
            
            String idParticipante = innerArray.getInt(0) +"";
            String idTipoParticipante = innerArray.getInt(1) +"";
            String tipoParticipante = innerArray.getString(2);
            String nombres = innerArray.getString(3);
            String apellido1 = innerArray.getString(4);
            String apellido2 = innerArray.getString(5);
            String tipoDocumentoIdentidad = innerArray.getString(6) +"";
            String numeroDocumentoIdentidad = innerArray.getString(7);
            String fechaNacimiento = innerArray.getInt(8)+"";
            String idTipoCuenta = innerArray.getInt(9)+"";
            String tipoCuenta = innerArray.getString(10);

            Usuario usuario_logged = new Usuario();

            usuario_logged.setUsuario(usuario);
            usuario_logged.setIdParticipante(idParticipante);
            usuario_logged.setIdTipoParticipante(idTipoParticipante);
            usuario_logged.setTipoParticipante(tipoParticipante);
            usuario_logged.setNombres(nombres);
            usuario_logged.setApellido1(apellido1);
            usuario_logged.setApellido2(apellido2);
            usuario_logged.setTipoDocumentoIdentidad(tipoDocumentoIdentidad);
            usuario_logged.setNumeroDocumentoIdentidad(numeroDocumentoIdentidad);
            usuario_logged.setFechaNacimiento(fechaNacimiento);
            usuario_logged.setIdTipoCuenta(idTipoCuenta);
            usuario_logged.setTipoCuenta(tipoCuenta);
            
            HttpSession session = request.getSession();
            session.setAttribute("usuario_logged", usuario_logged);
            
            String mensaje = new Gson().toJson("Correcto");
            response.getWriter().write(mensaje);
            
        }else if(accion.equals("obtenerHTTPSesion")){
            
            HttpSession session = request.getSession();
            
            Usuario usuario_logged = (Usuario) session.getAttribute("usuario_logged");
            String json2 = new Gson().toJson(usuario_logged);
            
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json2);
    
        }else if(accion.equals("finalizarHTTPSesion")){
            
            HttpSession session = request.getSession();
            
            session.removeAttribute("usuario_logged");
            
            String mensaje = new Gson().toJson("Correcto");
            response.getWriter().write(mensaje);
    
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
