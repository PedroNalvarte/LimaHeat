/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package limaHeat.dao;

import java.util.List;
import java.util.Map;


public interface ICategoria {
    
     boolean insertarDatos(String NOMBRE_CATEGORIA,String ABREVIATURA, String DESC_CATEGORIA, String ESTADO_REGISTRO,String IMAGEN);
     
      List<Map<String,String>>obtenerTodasLasCategorias();
      
      
     }
