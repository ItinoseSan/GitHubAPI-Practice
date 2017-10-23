package github.json;

import org.json.JSONArray;
import  org.json.JSONObject;

public class JsonDecodeForScore {
   private String starCount="stargazers_count";
   private String watcherCount="watchers_count";
   private String forksCount="forks_count";

   Integer total;
   public  void decode(String respone_json){
       try {
           JSONArray jsonArray = new JSONArray(respone_json);
           for (int i = 0; i < jsonArray.length(); i++) {
               JSONObject object = jsonArray.getJSONObject(i);
               Integer scorecontent1 = object.getInt(starCount);
               Integer scorecontent2 = object.getInt(watcherCount);
               Integer scorecontent3 = object.getInt(forksCount);
               total = scorecontent1 + scorecontent2 + scorecontent3;

               if (total <= 2) {
                   System.out.println("偏差値は45です");
               } else if (total >= 5) {
                   System.out.println("偏差値は50です");
               } else if (total <= 10) {
                   System.out.println("偏差値55です");
               }
           }
       }
       catch (Exception e){
           e.printStackTrace();
       }
   }
}
