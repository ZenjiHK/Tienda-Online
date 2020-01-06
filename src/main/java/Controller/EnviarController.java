package Controller;

import EJB.UserFacadeLocal;
import Entity.User;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.Properties;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Named(value = "EnviarController")
@SessionScoped
public class EnviarController implements Serializable {

    @EJB
    private UserFacadeLocal userFacade;
    private User user;
    private List<User> listaUser;
    private String mensaje;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getListaUser() {
        return listaUser;
    }

    public void setListaUser(List<User> listaUser) {
        this.listaUser = listaUser;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

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
        User usCorreo;
        try {
            usCorreo = userFacade.ExisteCorreo(destinatario);
            if (usCorreo != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Existe", "Correo enviado"));               
                System.out.println(destinatario);
                System.out.println(usCorreo+" AAAAAAAAAAAAAAAAAAAAAAA");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso de no existe", "El correo ingresado no coincide con los registrados en esta aplicación."));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso error", "Error"));
        }

        try {
            // Propiedades de la conexión
            Properties props = new Properties();
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
                    "Correo nuevo");

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
