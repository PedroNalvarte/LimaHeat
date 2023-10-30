/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package limaHeat.dao;

import java.util.List;

/**
 *
 * @author creo0
 */
public interface IHistorialPartidos {
    

    List<Object[]> registrarPartido(String equipoLocal, String equipoVisitante, String fecha, String lugar,String idTemporada,String idCategoria,String idEquipo);

    List<Object[]> listarPartidos(String idEquipo, String idTemporada);

    List<Object[]> editarPartido(String equipoLocal,String equipoVisitante, String fecha, String lugar,String resultado,String detalleResultado, String idPartido);

   
}
