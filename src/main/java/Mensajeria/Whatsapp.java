package Mensajeria;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Whatsapp<accountSid, authToken, client> {

    public static final String ACCOUNT_SID = "ACebc8e477938be35708e64e1fabc4d43b";
    public static final String AUTH_TOKEN = "1169a535d8a9bfa0b19a90b3d623128a";

    public void sendMessage() {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator( // 1415523886
                new com.twilio.type.PhoneNumber("whatsapp:+5401136274242"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "Hello from your friendly neighborhood Java application!")
                .create();
    }

}


