package limaHeat.dao;

import java.util.List;
public interface IRegistrarEstadisticasPartido {
    List<Object[]> listarEquiposRivales(String idEquipo, String idTemporada, String idCategoria);
    List<Object[]> listarJugadores(String idEquipo, String idTemporada, String idCategoria);
    List<Object[]> registarEstadisticas(String idEquipoLoc,String idCategoriaLoc, String idTemporadaLoc, String idEquipoRiv, String idCategoriaRiv, String idTemporadaRiv,String Id_loc ,String Id_riv,
    String lugar, String detalleResultado, String resultado, String MINloc, String TCAloc, String TCRloc, String dosTPCAloc, String dosTPCRloc, String 
    tresPTCAloc, String tresPTCRloc, String TLAloc, String TLRloc, String REBROloc, String REBRDloc, String ASloc, String TOloc, String RBloc, String TPloc, 
    String FPCloc, String FPDloc, String masmenosloc, String PTSloc, String MINriv, String TCAriv, String TCRriv, String dosTPCAriv, String dosTPCRriv, 
    String tresPTCAriv, String tresPTCRriv, String TLAriv, String TLRriv, String REBROriv, String REBRDriv, String ASriv, String TOriv, String RBriv, 
    String TPriv, String FPCriv, String FPDriv, String masmenosriv, String PTSriv);



}