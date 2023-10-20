package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.util.List;
import limaHeat.dao.IModulosEquipo;

//"NOMBRE_EQUIPO"	"NOMBRE_TEMPORADA"	"TIPO_TEMPORADA"	nombre    ID_TIPO_EQUIPO      TIPO_EQUIPO
public class impModulosEquipo implements IModulosEquipo{

    @Override
    public List<Object[]> cargarTitulo(String idEquipo, String idCategoria, String idTemporada) {
        
        String sql = new StringBuilder()
            .append("select e.\"NOMBRE_EQUIPO\", t.\"NOMBRE_TEMPORADA\", tt.\"TIPO_TEMPORADA\", concat(p.\"APELLIDO_1\",' ',p.\"APELLIDO_2\",', ',p.\"NOMBRES\") as nombre , e.\"ID_TIPO_EQUIPO\" , te.\"TIPO_EQUIPO\" ")
            .append("from \"EQUIPO_JUGADOR\" ej ")
            .append("inner join \"EQUIPO\" e on e.\"ID_EQUIPO\" = ej.\"ID_EQUIPO\" ")
            .append("inner join \"TEMPORADA\" t on t.\"ID_TEMPORADA\" = ej.\"ID_TEMPORADA\" ")
            .append("inner join \"TIPO_TEMPORADA\" tt on tt.\"ID_TIPO_TEMPORADA\" = t.\"ID_TIPO_TEMPORADA\" ")
            .append("inner join \"PARTICIPANTE\" p on p.\"ID_PARTICIPANTE\" = ej.\"ID_PARTICIPANTE\" ")
            .append("inner join \"TIPO_EQUIPO\" te on te.\"ID_TIPO_EQUIPO\" = e.\"ID_TIPO_EQUIPO\" ")
            .append("where p.\"ID_TIPO_PARTICIPANTE\" = 1 ")
            .append("and ej.\"ID_EQUIPO\" = "+idEquipo+" and ej.\"ID_CATEGORIA\"  = "+idCategoria+" and ej.\"ID_TEMPORADA\" = "+idTemporada+"")
            .toString();
        
        System.out.println(sql);
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }
    
    
    
}
