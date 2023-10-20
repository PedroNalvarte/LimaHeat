package limaHeat.dao;

import java.util.List;

public interface IJugadores {
    
    public List<Object[]> cargarDDLPosicion();
    
    public List<Object[]> registrarJugador(String nom, String ape1, String ape2, String tipDoc, String numDoc, String peso, String altura, 
                                    String fecnac, String posicion, String numeroDorsal, String idEquipo, String idCategoria, String idTemporada);
    
}
