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

    @Override
    public List<Object[]> listarJugadores(String idEquipo, String idCategoria, String idTemporada) {
        
        String sql = new StringBuilder()
            .append("select ej.\"ID_PARTICIPANTE\", p.\"NOMBRES\", p.\"APELLIDO_1\", p.\"APELLIDO_2\", ej.\"NUMERO_DORSAL\", ")
            .append("pp.\"POSICION\", EXTRACT(YEAR FROM AGE(p.\"FECHA_NACIMIENTO\")), p.\"PESO\", p.\"ALTURA\", tdi.\"ABREVIATURA\", p.\"NUMERO_DOCUMENTO_IDENTIDAD\", p.\"ID_TIPO_DOCUMENTO_IDENTIDAD\"  ")
            .append("from \"EQUIPO_JUGADOR\" ej ")
            .append("inner join \"PARTICIPANTE\" p on p.\"ID_PARTICIPANTE\" = ej.\"ID_PARTICIPANTE\" ")
            .append("inner join \"POSICION\" pp on pp.\"ID_POSICION\" = ej.\"ID_POSICION\" ")
            .append("inner join \"TIPO_DOCUMENTO_IDENTIDAD\" tdi on tdi.\"ID_TIPO_DOCUMENTO_IDENTIDAD\" = p.\"ID_TIPO_DOCUMENTO_IDENTIDAD\" ")
            .append("where p.\"ID_TIPO_PARTICIPANTE\" = 2 and ej.\"ID_EQUIPO\" = "+idEquipo+" and ej.\"ID_CATEGORIA\" = "+idCategoria+" and ej.\"ID_TEMPORADA\" = "+idTemporada+"")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado; 
        
    }

    @Override
    public List<Object[]> editarJugador(String nom, String ape1, String ape2, String tipDoc, String numDoc, String peso, String altura, String posicion, String numeroDorsal, String idEquipo, String idCategoria, String idTemporada, String idParticipante) {
       
        String sql = new StringBuilder()
            .append("CALL public.editarjugador('"+nom+"', '"+ape1+"', '"+ape2+"', "+tipDoc+", '"+numDoc+"', '"+peso+"', '"+altura+"', "+posicion+", '"+numeroDorsal+"', "+idEquipo+", "+idCategoria+", "+idTemporada+", "+idParticipante+"); ")
            .toString();      
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }

    @Override
    public List<Object[]> cargarRendimientoGeneralJugador(String idEquipo, String idCategoria, String idTemporada, String idParticipante) {
        
        String sql = new StringBuilder()
                .append("select sum(\"TC_TOTALES\"), sum(\"TC_ACERTADOS\"), sum(\"TC_2P_TOTALES\"),sum(\"TC_2P_ACERTADOS\"),sum(\"TC_3P_TOTALES\"),sum(\"TC_3P_ACERTADOS\"), ")
                .append("sum(\"REB_RO\"),sum(\"REB_RD\"),sum(\"AS\"),sum(\"TO\"),sum(\"RB\"),sum(\"TP\"),sum(\"FP_C\"),sum(\"FP_D\"),sum(\"DIFERENCIA_PUNTOS\"),sum(\"PTS\"),sum(\"TL_ACERTADOS\"), ")
                .append("sum(\"TL_TOTALES\"), ")
                .append("concat(p.\"APELLIDO_1\",' ',p.\"APELLIDO_2\",' ',p.\"NOMBRES\") ")
                .append("from \"ESTADISTICAS_JUGADOR\" ej ")
                .append("inner join \"PARTICIPANTE\" p on p.\"ID_PARTICIPANTE\" = ej.\"ID_PARTICIPANTE\" ")
                .append("where ej.\"ID_EQUIPO\" = "+idEquipo+" and ej.\"ID_CATEGORIA\" = "+idCategoria+" and ej.\"ID_TEMPORADA\" = "+idTemporada+" and ej.\"ID_PARTICIPANTE\" = "+idParticipante+" ")
                .append("group by concat(p.\"APELLIDO_1\",' ',p.\"APELLIDO_2\",' ',p.\"NOMBRES\") ")
                .toString();
        
        System.out.println(sql);
        
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        return listado;
    }
    
}
