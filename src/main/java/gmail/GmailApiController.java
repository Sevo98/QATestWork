package gmail;

import com.google.api.client.util.Base64;
import com.google.api.client.util.StringUtils;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class GmailApiController {
    private static final String user = "me";

    public static void printMessageTo() throws IOException, GeneralSecurityException {
        try {
            Gmail service = GmailConnector.auth();

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
        } catch (NullPointerException e) {
            System.out.println("Letters not found");
        }
    }

    public static void printMessageFrom() throws IOException, GeneralSecurityException {
        try {
            Gmail service = GmailConnector.auth();

            //Access Gmail
            Gmail.Users.Messages.List request = service.users().messages().list(user).setQ("from: " + "jenleroy8@gmail.com");

            ListMessagesResponse messagesResponse = request.execute();
            request.setPageToken(messagesResponse.getNextPageToken());

            //Get ID of the email you are looking for
            String messageId = messagesResponse.getMessages().get(0).getId();
            Message message = service.users().messages().get(user, messageId).execute();
            //Print email
            String emailBody = StringUtils.newStringUtf8(Base64.decodeBase64(message.getPayload().getParts().get(0).getBody().getData()));
            System.out.println("EMail: " + emailBody);
        } catch (NullPointerException e) {
            System.out.println("Letters not found");
        }

    }

    public static void listMessages() throws IOException, GeneralSecurityException {
        try {
            Gmail service = GmailConnector.auth();

            //Access Gmail
            Gmail.Users.Messages.List request = service.users().messages().list(user).setQ("from: " + "jenleroy8@gmail.com");

            ListMessagesResponse messagesResponse = request.execute();
            request.setPageToken(messagesResponse.getNextPageToken());


            //Get ID of the email you are looking for
            String messageId = messagesResponse.getMessages().get(0).getId();
            ListMessagesResponse response = service.users().messages().list("me").execute();

            List<Message> messages = new ArrayList<Message>();
            messages.addAll(response.getMessages());

            String pageToken = response.getNextPageToken();
            response = service.users().messages().list("me").setPageToken(pageToken).execute();

            //Print email
            for (Message message : messages) {
                System.out.println(message.getId());
                Message test = service.users().messages().get("me", message.getId()).execute();
                System.out.println(StringUtils.newStringUtf8(Base64.decodeBase64(test.getPayload().getParts().get(0).getBody().getData())));
            }

        } catch (NullPointerException e) {
            System.out.println("Letters not found");
        }

    }
}
