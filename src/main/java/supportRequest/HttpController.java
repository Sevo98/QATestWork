package supportRequest;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpController {
    public static void PostSend(String postData) throws Exception {
        URL url = new URL("https://gtest.dev.mk.ugmk.com/0200/api-mobile/v1/support/");


        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));

        try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
            dos.writeBytes(postData);
        }

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(
                conn.getInputStream())))
        {
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = bf.readLine()) != null) {
                response.append(line);
//                System.out.println(line);
            }
            JSONObject jsonObject = new JSONObject(response.toString());
            System.out.println(jsonObject);
        }

    }
}
