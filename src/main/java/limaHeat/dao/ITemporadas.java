/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limaHeat.dao;

import java.util.List;

/**
 *
 * @author HUAWEI
 */

public interface ITemporadas {
     List<Object[]> listarTemporadas();
     List<Object[]> tiposTemporadas();
     boolean registrarTemporadas(String nombreTemporada, String tipoTemporada, String fechaInicio, String fechaFin);
}
