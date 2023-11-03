/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package limaHeat.dao;

import java.util.List;

public interface IRegistrarPartido {

    List<Object[]> registrarPartido(String RESULTADO,String DETALLE_RESULTADO, String LUGAR);

    List<Object[]> listarPartidos(String equipo, String categoria, String temporada);
    
    List<Object[]>EditarPartido(String RESULTADO,String DETALLE_RESULTADO,String LUGAR,String idPartido);

     List<Object[]> eliminarPartido(String idPartido);
     
      List<Object[]> obtenerPartido(String idPartido);
}

