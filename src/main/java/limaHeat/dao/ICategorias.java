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
public interface ICategorias {
    
        
    List<Object[]> crearCategorias( String usuario);
    
    List<Object[]> eliminarCategorias( String usuario);
    
     List<Object[]> ActualizarCategorias( String usuario);
}
