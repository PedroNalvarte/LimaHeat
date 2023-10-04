package limaHeat.servlets;

import general.json.JsonHelper;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import limaHeat.dao.ICategoria;
import limaHeat.dao.impl.implAgregarCategorias;

@WebServlet(name = "categoria", urlPatterns = {"/categoria"})
public class categoria extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String lista;
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String lista;
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");

        if (accion.equals("listar")) {
            ICategoria CategoriaDao = new implAgregarCategorias();
            List<Object[]> listado = CategoriaDao.listarCategorias();
            lista = json.matriz(listado);

            response.getWriter().write(lista);

        } else if (accion.equals("obtener-categoria")) {
            String resultado;
            String categoriaSeleccionada = request.getParameter("ID_CATEGORIA");
            ICategoria categoriaDao = new implAgregarCategorias();
            List<Object[]> categoria = categoriaDao.obtenerCategoria(categoriaSeleccionada);
            resultado = json.matriz(categoria);
            System.out.println(resultado);
            response.getWriter().write(resultado);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        JsonHelper json = new JsonHelper();
        String accion = request.getParameter("accion");
        
       if (accion.equals("registrar-categoria")) {

            String resultado;
            String NOMBRE_CATEGORIA = request.getParameter("NOMBRE_CATEGORIA");
            String ABREVIATURA = request.getParameter("ABREVIATURA");
            String DESC_CATEGORIA = request.getParameter("DESC_CATEGORIA");
            String IMAGEN = request.getParameter("IMAGEN");

            ICategoria categoriaDao = new implAgregarCategorias();
            List<Object[]> listado = categoriaDao.insertarDatos(NOMBRE_CATEGORIA, ABREVIATURA, DESC_CATEGORIA, IMAGEN);

            resultado = json.matriz(listado);

            response.getWriter().write(resultado);

        }
       else if (accion.equals("editar-categoria")) {
            String resultado;
            String NOMBRE_CATEGORIA = request.getParameter("NOMBRE_CATEGORIA");
            String ABREVIATURA = request.getParameter("ABREVIATURA");
            String DESC_CATEGORIA = request.getParameter("DESC_CATEGORIA");
            String CategoriaSeleccionada = request.getParameter("ID_CATEGORIA");

            ICategoria categoriaDao = new implAgregarCategorias();
            List<Object[]> categoria = categoriaDao.editarCategoria(NOMBRE_CATEGORIA, ABREVIATURA, DESC_CATEGORIA, CategoriaSeleccionada);
            resultado = json.matriz(categoria);
            response.getWriter().write(resultado);
        } 
    }

}