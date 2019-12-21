package Controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Named(value = "EnviarController")
@SessionScoped
public class EnviarController implements Serializable {
    //Declaramos la variable que se utilizará    
    private String destinatario;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    
    //Metodo para enviar correos
     public void enviar() {
        try {
            // Propiedades de la conexión
            Properties props = new Properties ();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "pruebadebot8@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pruebadebot8@gmail.com"));
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(destinatario));
            message.setSubject("Prueba de restaurar contraseña");
            message.setText(
                    "PruebaNuevaaaaaa");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("pruebadebot8@gmail.com", "Prueba123");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (MessagingException e) {           
        }
    }
}
