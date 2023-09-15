package general.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

   private final ObjectMapper MAPPER;
   
   public Json() {
      MAPPER = new ObjectMapper();
   }
   
   public String toString(Object object){
      String json = "{}";
      
      try {
         json = MAPPER.writeValueAsString(object);
      } catch (JsonProcessingException e) {
         
      }
      
      return json;
   }
   
}
