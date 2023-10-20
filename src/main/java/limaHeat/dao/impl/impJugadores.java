package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.util.List;
import limaHeat.dao.IJugadores;

public class impJugadores implements IJugadores{

    //ID_POSICION     POSICION     ABREVIATURA
    @Override
    public List<Object[]> cargarDDLPosicion() {
        
        String sql = new StringBuilder()
            .append("select \"ID_POSICION\", \"POSICION\", \"ABREVIATURA\"  from \"POSICION\" p ")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado; 
    }

    @Override
    public List<Object[]> registrarJugador(String nom, String ape1, String ape2, String tipDoc, String numDoc, String peso, String altura, String fecnac, String posicion, String numeroDorsal, String idEquipo, String idCategoria, String idTemporada) {
       
        //System.out.println(nom+" "+ape1+" "+ape2+" "+tipDoc+" "+numDoc+" "+peso+" "+altura+" "+fecnac+" "+posicion+" "+numeroDorsal+" "+idEquipo+" "+idCategoria+" "+idTemporada);
        
        String sql = new StringBuilder()
            .append("CALL public.registrarjugador('"+nom+"', '"+ape1+"', '"+ape2+"', "+tipDoc+", '"+numDoc+"', '"+peso+"', '"+altura+"', '"+fecnac+"'::DATE, "+posicion+", '"+numeroDorsal+"', "+idEquipo+", "+idCategoria+", "+idTemporada+"); ")
            .toString();      
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }
    
}
