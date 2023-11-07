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
public interface IDetallePartido {

List<Object[]> CargarNombresJugadoresxCategoria(String ID_TEMPORADA, String ID_CATEGORIA,String ID_EQUIPO);

List<Object[]> RegistrarEstadisticasJugador(int ID_TEMPORADA,int ID_EQUIPO,int ID_CATEGORIA,int ID_PARTICIPANTE,int  ID_PARTIDO,int MINUTOS_JUGADOS,int SEGUNDOS_JUGADOS,int TC_TOTALES

,int TC_ACERTADOS );
        
}