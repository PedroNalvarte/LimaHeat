
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import general.json.JsonHelper;
import static java.awt.SystemColor.window;
import limaHeat.dao.ICategoria;
import limaHeat.dao.impl.implAgregarCategorias;

@WebServlet(name = "enviar_registro", urlPatterns = {"/enviar_registro"})
public class categoria extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String resultado;
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();

        String NOMBRE_CATEGORIA = request.getParameter("NOMBRE_CATEGORIA");
        String ABREVIATURA = request.getParameter("ABREVIATURA");
        String DESC_CATEGORIA = request.getParameter("DESC_CATEGORIA");
        String ESTADO_REGISTRO = request.getParameter("ESTADO_REGISTRO");      
        String IMAGEN = request.getParameter("IMAGEN");

        ICategoria categoriaDao = new implAgregarCategorias();
        boolean insercionExitosa = categoriaDao.insertarDatos(NOMBRE_CATEGORIA, ABREVIATURA, DESC_CATEGORIA, ESTADO_REGISTRO,IMAGEN);

        if (insercionExitosa) {
            resultado = "Inserción exitosa";
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("modulos.jsp"); 
        } else {
            resultado = "Error en la inserción";
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

        response.getWriter().write(resultado);
        
     
    }

}
