// build.gradle -> dependencies -> implementation("com.fasterxml.jackson.core:jackson-databind:2.16.0")
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpResult extends AsyncTask<String, Void, String> {
    private String result;
    @Override
    protected String doInBackground(String... params) {
        try {
            String temp = null;
            URL url = new URL("http://158.179.162.75:8080/"+params[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            while ((temp = reader.readLine()) != null) buffer.append(temp);
            result = buffer.toString();
            reader.close();
        } catch (Exception e) {
            result = "서버 연결 실패";
        }

        return result;
    }
}
