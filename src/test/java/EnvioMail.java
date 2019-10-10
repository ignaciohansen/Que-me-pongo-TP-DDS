import Api.Mensajeria.Mail;
import org.junit.Test;

public class EnvioMail {

    @Test
    public void envioDeMail(){
        Mail mailAPI = new Mail();
        mailAPI.enviarEmail("Testeo", "Cuerpo del Testeo");

    }
}
