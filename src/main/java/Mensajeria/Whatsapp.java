package Mensajeria;

import Ropas.Atuendo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Whatsapp {

    //CUENTA NACHO
    public static final String ACCOUNT_SID = "AC41d47f5677f96ba8c77f5444fedca805";
    public static final String AUTH_TOKEN = "8ee9624ce305c8cd5a445946da1b799a";

    // public static final String ACCOUNT_SID = "ACebc8e477938be35708e64e1fabc4d43b";
    // public static final String AUTH_TOKEN = "1169a535d8a9bfa0b19a90b3d623128a";

    //num registrados: +5491161906402,+5491136274242

    public void recibirMensaje() {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5491164083480"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "Prueba wpp")
                .create();
    }

    public void recibirMensajeAtuendo(Atuendo unAtuendo) {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5491161906402"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "" + unAtuendo)
                .create();
    }
    
}


