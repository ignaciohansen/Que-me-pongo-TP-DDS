import Api.Mensajeria.Mail;
import Entities.Usuario.Usuario;
import org.junit.Test;

public class EnvioMail {

    @Test
    public void envioDeMail(){
        Mail mailAPI = new Mail();
        Usuario juan = new Usuario();
        juan.setEmail("jc.sala@hotmail.com");
       mailAPI.enviarEmail("Testeo", "Cuerpo del Testeo",juan);

    }
}
