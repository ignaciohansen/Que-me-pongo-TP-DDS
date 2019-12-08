package Api.Mensajeria;


import Entities.Usuario.Usuario;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;

public class Mail {

    /*

    -COMO USAR EL MAIL-

    Mail mail = new Mail();
    mail.enviarEmail("asuntoDelMail","cuerpoDelMail");

     */

    public void enviarEmail(String subject, String body, Usuario usuario){

        if(usuario.getEmail() != null){
        Email email = EmailBuilder.startingBlank()
                .from("QueMePongo", "correo.2019-mi-no-group-10@hotmail.com")
                .to(usuario.getNombre(), usuario.getEmail())
                .withSubject(subject)
                .withPlainText(body)
                .buildEmail();

        Mailer inhouseMailer = MailerBuilder
              //  .withSMTPServer("server", 25, "username", "password")
                .withSMTPServer("smtp.live.com", 25,
                        "correo.2019-mi-no-group-10@hotmail.com",
                        "OjalaNosAprueben")
                .buildMailer();

        inhouseMailer.sendMail(email);
        }
    }
}
