package supportRequest;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для отправки HTTP запросов по указанному адресу
 */
public class HttpController {
    /**
     * Метод отправки Post запроса
     * @param requestForm класс с данными сообщения техподдержке
     * @throws Exception
     */
    public static void PostSend(RequestForm requestForm) throws Exception {
        final CloseableHttpClient httpclient = HttpClients.createDefault();

        final HttpPost httpPost = new HttpPost("https://gtest.dev.mk.ugmk.com/0200/api-mobile/v1/support/");
        final List<NameValuePair> params = new ArrayList<>();

        if (requestForm == null) {
            NullPointerException nullPointerException = new NullPointerException();
            System.out.println("RequestFor is null");
            throw nullPointerException;
        }

        if (requestForm.getAgreement() != null) {
            params.add(new BasicNameValuePair("fullName", requestForm.getFullName()));
        }
        if (requestForm.getAgreement() != null) {
            params.add(new BasicNameValuePair("mail", requestForm.getMail()));
        }
        if (requestForm.getAgreement() != null) {
            params.add(new BasicNameValuePair("phone", requestForm.getPhone()));
        }
        if (requestForm.getAgreement() != null) {
            params.add(new BasicNameValuePair("comment", requestForm.getComment()));
        }
        if (requestForm.getAgreement() != null) {
            params.add(new BasicNameValuePair("department", requestForm.getDepartment()));
        }
        if (requestForm.getAgreement() != null) {
            params.add(new BasicNameValuePair("position", requestForm.getPosition()));
        }
        if (requestForm.getAgreement() != null) {
            params.add(new BasicNameValuePair("agreement", requestForm.getAgreement()));
        }

        httpPost.setEntity(new UrlEncodedFormEntity(params));


        try (
                CloseableHttpResponse response2 = httpclient.execute(httpPost)
        ) {

            final HttpEntity entity2 = response2.getEntity();

            System.out.println("Params for send: " + params);
            String answer = EntityUtils.toString(entity2);
            System.out.println(answer);
            String statusCode = "\"statusCode\": 200";
            if (!answer.contains(statusCode)) {
                throw new Exception("\"statusCode is not 200!\"");
            }
        } catch (Exception e) {
            System.out.println("statusCode is not 200!");
        }
        httpclient.close();
    }
}
