import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.Base64;
import com.google.api.client.util.StringUtils;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GmailAPI {
    private static final String APPLICATION_NAME = "Gmail API Java Quickstart";

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    private static final String user = "me";
    static Gmail service = null;
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        InputStream in = GmailQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        //Credential builder
        Credential authorize = new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
                .setJsonFactory(JSON_FACTORY)
                .setClientSecrets(clientSecrets.getDetails().getClientId().toString(), clientSecrets.getDetails().getClientSecret().toString())
                .build()
                .setAccessToken(getAccessToken())
                .setRefreshToken("1//0cn2Ktpr57KPdCgYIARAAGAwSNwF-L9IrHUfLzWZsrwl1MH_6Camlgnl6LpEG1pxmfTL-lbjvm92TwaU_ywJo6tFb2jBPyUP5JR0");

        //Gmail Service
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, authorize)
                .setApplicationName(APPLICATION_NAME)
                .build();

        //Access Gmail
        Gmail.Users.Messages.List request = service.users().messages().list(user).setQ("to: " + "jenleroy8@gmail.com");

        ListMessagesResponse messagesResponse = request.execute();
        request.setPageToken(messagesResponse.getNextPageToken());

        //Get ID of the email you are looking for
        String messageId = messagesResponse.getMessages().get(0).getId();
        Message message = service.users().messages().get(user, messageId).execute();

        //Print email
        String emailBody = StringUtils.newStringUtf8(Base64.decodeBase64(message.getPayload().getParts().get(0).getBody().getData()));
        System.out.println("EMail: " + emailBody);
    }

    private static String getAccessToken() {
        try {
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("grant_type", "refresh_token");
            params.put("client_id", "18306162202-qpvhpauraicd80efp009u52cfrsod9k4.apps.googleusercontent.com");
            params.put("client_secret", "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");
            params.put("refresh_token",
                    "1//0cn2Ktpr57KPdCgYIARAAGAwSNwF-L9IrHUfLzWZsrwl1MH_6Camlgnl6LpEG1pxmfTL-lbjvm92TwaU_ywJo6tFb2jBPyUP5JR0");

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            URL url = new URL("https://accounts.google.com/o/oauth2/token");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setRequestMethod("POST");
            con.getOutputStream().write(postDataBytes);

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                buffer.append(line);
            }

            JSONObject json = new JSONObject(buffer.toString());
            String accessToken = json.getString("access_token");
            return accessToken;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
