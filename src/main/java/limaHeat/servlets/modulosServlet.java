package limaHeat.servlets;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import limaHeat.dao.ICategoria;
import limaHeat.dao.impl.implAgregarCategorias;

@WebServlet(name = "modulosServlet", urlPatterns = {"/modulosServlet"})
public class modulosServlet extends HttpServlet {

    
      private ICategoria implAgregarCategoria; 

    @Override
    public void init() throws ServletException {
        super.init();
        
        // Inicializa la referencia a la implementación de ICategoriaDAO
        implAgregarCategoria = new implAgregarCategorias(); // Reemplaza ImplCategoriaDAO con el nombre de tu clase de implementación
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            List<Map<String, String>> categorias = implAgregarCategoria.obtenerTodasLasCategorias();

        // Configurar la respuesta HTTP
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Convertir la lista de mapas (categorías con datos adicionales) a JSON y enviarla como respuesta
        Gson gson = new Gson();
        String categoriasJson = gson.toJson(categorias);

        PrintWriter out = response.getWriter();
        out.print(categoriasJson);
        out.flush();
    }

    
}
