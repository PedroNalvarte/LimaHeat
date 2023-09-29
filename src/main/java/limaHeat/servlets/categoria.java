package limaHeat.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import limaHeat.dao.ICategoria;
import limaHeat.dao.impl.implAgregarCategorias;

@WebServlet(name = "enviar_registro", urlPatterns = {"/enviar_registro"})
public class categoria extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        
        if (accion.equals("Editar")) {
            String ID_CATEGORIA = request.getParameter("ID_CATEGORIA");
            String NOMBRE_CATEGORIA = request.getParameter("NOMBRE_CATEGORIA");
            String ABREVIATURA = request.getParameter("ABREVIATURA");
            String DESC_CATEGORIA = request.getParameter("DESC_CATEGORIA");
            String ESTADO_REGISTRO = request.getParameter("ESTADO_REGISTRO");
            String IMAGEN = request.getParameter("IMAGEN");

          
            ICategoria categoriaDAO = new implAgregarCategorias();

           
            List<Object[]> result = categoriaDAO.editarCategoria(ID_CATEGORIA, NOMBRE_CATEGORIA, ABREVIATURA, DESC_CATEGORIA, ESTADO_REGISTRO, IMAGEN);

            if (result != null && !result.isEmpty()) {
               
                response.sendRedirect("modulos.jsp"); 
            } else {
                
                response.sendRedirect("error.jsp"); 
            }
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("application/json;charset=UTF-8");
        String resultado;
        request.setCharacterEncoding("UTF-8");

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
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("obtener".equals(accion)) {
            ICategoria implementacion = new implAgregarCategorias();
            List<Object[]> categorias = implementacion.obtenerTodasLasCategorias();

            // Configurar la respuesta HTTP
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Convertir la lista de objetos a JSON y enviarla como respuesta
            Gson gson = new Gson();
            String categoriasJson = gson.toJson(categorias);

            PrintWriter out = response.getWriter();
            out.print(categoriasJson);
            out.flush();
        }

    }
}
