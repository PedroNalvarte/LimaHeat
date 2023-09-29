package general.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonHelper extends Json{

   public JsonHelper() {
      super();
   }
   
   public String empty(){
      return "{}";
   }
   
   public String message(String msg){
      Map<String,String> map = new HashMap<>();
      map.put("msg", msg);
      
      String result = toString(map);
      return result;
   }
   
   public String messages(List<String> listMsg){
      List<Map<String,String>> list = new ArrayList<>();
      listMsg.forEach(msg ->{
         Map<String,String> map = new HashMap<>();
         map.put("msg", msg);
         list.add(map);
      });
      
      String result = toString(list);
      return result;
   }
   
   public String fila(String[] key, Object[] value){
      Map<String, Object> map = new LinkedHashMap<>();
      
      for (int i = 0; i < key.length; i++) {
         map.put(key[i], value[i]);
      }
      String result = toString(map);
      return result;
   }
   
   public String matriz(List<Object[]> list){
      Map<String, Object> map = new HashMap<>();
      map.put("rows", list);
      
      String result = toString(map);
      return result;
   }

    public String matriz(boolean insercionExitosa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
