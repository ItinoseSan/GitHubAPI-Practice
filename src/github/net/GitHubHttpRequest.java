package github.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitHubHttpRequest {
    public String get(String url){
        try {
            URL sendUrl = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) sendUrl.openConnection();
            urlConnection.setRequestProperty("Content-Type","application/github.json");
            urlConnection.connect();

            InputStreamReader isr = urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK ?
                    new InputStreamReader(urlConnection.getInputStream())
                    : new InputStreamReader(urlConnection.getErrorStream());
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder sb=new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            return sb.toString();
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
