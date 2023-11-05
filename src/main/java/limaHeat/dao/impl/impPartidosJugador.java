package limaHeat.dao.impl;
import general.sql.SelectGeneral;
import java.util.List;
import limaHeat.dao.IPartidosJugador;

public class impPartidosJugador implements IPartidosJugador{

    @Override
    public List<Object[]> listarPartidosJugador(String jugador, String equipo) {
         String sql = new StringBuilder("select distinct p.\"ID_PARTIDO\", e.\"NOMBRE_EQUIPO\"  , p.\"RESULTADO\", p.\"DETALLE_RESULTADO\", p.\"LUGAR\", p.fecha_partido, t.\"NOMBRE_TEMPORADA\" || ' ' || tt.\"TIPO_TEMPORADA\"  from \"PARTIDO\" p ")
            .append("join \"ESTADISTICAS_JUGADOR\" ej on ej.\"ID_PARTIDO\" = p.\"ID_PARTIDO\" ")
            .append("join \"TEMPORADA\" t on ej.\"ID_TEMPORADA\"  = t.\"ID_TEMPORADA\" ")
            .append("join \"TIPO_TEMPORADA\" tt on t.\"ID_TIPO_TEMPORADA\" = tt.\"ID_TIPO_TEMPORADA\" ")
            .append("join \"EQUIPO\" e on e.\"ID_EQUIPO\" = ej.\"ID_EQUIPO\" ")
            .append("where p.\"ID_PARTIDO\" in (select ej2.\"ID_PARTIDO\" from \"ESTADISTICAS_JUGADOR\" ej2 where ej2.\"ID_PARTICIPANTE\" = " + jugador + ") ")
            .append("and ej.\"ID_EQUIPO\" != " + equipo  + ";")
            .toString();
            
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado; 
    }

    @Override
    public List<Object[]> mostrarEstadisticaPartidoLocal(String partido, String equipo) {
         String sql = new StringBuilder("select ej2.\"NUMERO_DORSAL\", p.\"NOMBRES\" || ', ' || p.\"APELLIDO_1\" || ' ' || p.\"APELLIDO_2\", ")
               .append("ej.\"MINUTOS_JUGADOS\"  || ':' || ej.\"SEGUNDOS_JUGADOS\", ej.\"TC_ACERTADOS\" || '/' || ej.\"TC_TOTALES\", ")
               .append("round(CAST(ej.\"TC_ACERTADOS\" AS NUMERIC) / ej.\"TC_TOTALES\",2), ej.\"TC_2P_ACERTADOS\" || '/' || ej.\"TC_2P_TOTALES\", round(CAST(ej.\"TC_2P_ACERTADOS\" AS NUMERIC)  / ej.\"TC_2P_TOTALES\",2), ")
               .append("ej.\"TC_3P_ACERTADOS\" || '/' || ej.\"TC_3P_TOTALES\", round(CAST(ej.\"TC_3P_ACERTADOS\" AS NUMERIC) / ej.\"TC_3P_TOTALES\",2), ej.\"TL_ACERTADOS\" || '/' || ej.\"TL_TOTALES\", ")
               .append("round(cast(ej.\"TL_ACERTADOS\" as NUMERIC) / ej.\"TL_TOTALES\",2), ej.\"REB_RO\", ej.\"REB_RD\", ej.\"REB_RO\"  + ej.\"REB_RD\", ej.\"AS\", ej.\"TO\", ej.\"RB\", ej.\"TP\", ej.\"FP_C\", ej.\"FP_D\", ")
               .append("ej.\"DIFERENCIA_PUNTOS\", ej.\"PTS\" from \"ESTADISTICAS_JUGADOR\" ej join \"PARTICIPANTE\" p on p.\"ID_PARTICIPANTE\" = ej.\"ID_PARTICIPANTE\" ")
               .append("join \"EQUIPO_JUGADOR\" ej2 on ej2.\"ID_PARTICIPANTE\"  = ej.\"ID_PARTICIPANTE\" ")
               .append("where ej.\"ID_PARTIDO\" = " + partido)
               .append(" and ej.\"ID_EQUIPO\" = " + equipo + ";")
               .toString();
       
      
       SelectGeneral obj = new SelectGeneral();
       List<Object[]> listado = obj.selectGeneral(sql);
       return listado;
    }

    @Override
    public List<Object[]> cargarTitulos(String partido) {
       String sql = new StringBuilder("select distinct  e.\"ID_EQUIPO\", e.\"NOMBRE_EQUIPO\"  from \"ESTADISTICAS_JUGADOR\" ej ")
               .append("join \"EQUIPO\" e on e.\"ID_EQUIPO\" = ej.\"ID_EQUIPO\" ")
               .append("where \"ID_PARTIDO\" = " +  partido + ";")
               .toString();
       SelectGeneral obj = new SelectGeneral();
       List<Object[]> listado = obj.selectGeneral(sql);
       return listado;
    }

    @Override
    public List<Object[]> mostrarEstadisticaPartidoRival(String partido, String equipo) {
          String sql = new StringBuilder("select ej2.\"NUMERO_DORSAL\", p.\"NOMBRES\" || ', ' || p.\"APELLIDO_1\" || ' ' || p.\"APELLIDO_2\", ")
               .append("ej.\"MINUTOS_JUGADOS\"  || ':' || ej.\"SEGUNDOS_JUGADOS\", ej.\"TC_ACERTADOS\" || '/' || ej.\"TC_TOTALES\", ")
               .append("round(CAST(ej.\"TC_ACERTADOS\" AS NUMERIC) / ej.\"TC_TOTALES\",2), ej.\"TC_2P_ACERTADOS\" || '/' || ej.\"TC_2P_TOTALES\", round(CAST(ej.\"TC_2P_ACERTADOS\" AS NUMERIC)  / ej.\"TC_2P_TOTALES\",2), ")
               .append("ej.\"TC_3P_ACERTADOS\" || '/' || ej.\"TC_3P_TOTALES\", round(CAST(ej.\"TC_3P_ACERTADOS\" AS NUMERIC) / ej.\"TC_3P_TOTALES\",2), ej.\"TL_ACERTADOS\" || '/' || ej.\"TL_TOTALES\", ")
               .append("round(cast(ej.\"TL_ACERTADOS\" as NUMERIC) / ej.\"TL_TOTALES\",2), ej.\"REB_RO\", ej.\"REB_RD\", ej.\"REB_RO\"  + ej.\"REB_RD\", ej.\"AS\", ej.\"TO\", ej.\"RB\", ej.\"TP\", ej.\"FP_C\", ej.\"FP_D\", ")
               .append("ej.\"DIFERENCIA_PUNTOS\", ej.\"PTS\" from \"ESTADISTICAS_JUGADOR\" ej join \"PARTICIPANTE\" p on p.\"ID_PARTICIPANTE\" = ej.\"ID_PARTICIPANTE\" ")
               .append("join \"EQUIPO_JUGADOR\" ej2 on ej2.\"ID_PARTICIPANTE\"  = ej.\"ID_PARTICIPANTE\" ")
               .append("where ej.\"ID_PARTIDO\" = " + partido)
               .append(" and ej.\"ID_EQUIPO\" <> " + equipo + ";")
               .toString();
       
      
       SelectGeneral obj = new SelectGeneral();
       List<Object[]> listado = obj.selectGeneral(sql);
       return listado;
    }

    @Override
    public List<Object[]> mostrarRendimientoGeneral(String jugador) {
          String sql = new StringBuilder("select  round( sum(ej.\"TC_ACERTADOS\") * 100/ sum(ej.\"TC_TOTALES\"), 2) || '%' as \"TC\", round(sum(ej.\"TC_2P_ACERTADOS\") * 100 / sum(ej.\"TC_2P_TOTALES\"), 2) || '%' as \"TC_2\", ")
                  .append("round(sum(ej.\"TC_3P_ACERTADOS\") * 100 / sum(ej.\"TC_3P_TOTALES\"), 2) || '%' as \"TC_3\", round(sum(ej.\"TL_ACERTADOS\") * 100 / sum(ej.\"TL_TOTALES\"), 2) || '%' as \"TL\", ")
                  .append(" sum(ej.\"REB_RO\") + sum(ej.\"REB_RD\"), sum(ej.\"AS\"), sum(ej.\"TO\"), sum(ej.\"RB\"), sum(ej.\"TP\"), sum(ej.\"FP_C\"), sum(ej.\"FP_D\"), sum(ej.\"DIFERENCIA_PUNTOS\"), sum(ej.\"PTS\") ")
                  .append(" from \"ESTADISTICAS_JUGADOR\" ej ")
                  .append("where ej.\"ID_PARTICIPANTE\"  = " +  jugador + ";")
                  .toString();
          System.out.println(sql);
          SelectGeneral obj = new SelectGeneral();
          List<Object[]> listado = obj.selectGeneral(sql);
          return listado;
    }
    
}
