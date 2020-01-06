package Controller;

import EJB.ClienteFacadeLocal;
import EJB.UserFacadeLocal;
import Entity.Cliente;
import Entity.User;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.Properties;
import javax.annotation.PostConstruct;
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

     @EJB    
    private ClienteFacadeLocal clienteFacade;       
    private List<Cliente> listaCliente;
    private Cliente cliente; 

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
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

    @PostConstruct
    public void init(){
        cliente = new Cliente();
    }
    
    //Metodo para enviar correos
    public void enviar() {
        Cliente usCorreo;
        cliente.setCorreo(destinatario);
        try {
            usCorreo = clienteFacade.ExisteCorreo(cliente);
            System.out.println(destinatario);
            if (usCorreo != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha enviado un correo a la dirección ingresada. Verifique.", "Existe"));                             
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El correo ingresado no coincide con ninguna cuenta existente.", "El correo ingresado no coincide con los registrados en esta aplicación."));              
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Ha ocurrido un error, intente más tarde", "Error"));
        }

        try {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "celavieonline@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("celavieonline@gmail.com"));
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(destinatario));
            message.setSubject("Prueba de restaurar contraseña");
            message.setText(
                    "Su clave nueva es AHJSGASGHJG.");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("celavieonline@gmail.com", "celavie123");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (MessagingException e) {
        }
    }
}
