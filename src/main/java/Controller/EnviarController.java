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
    //Declaramos la variable que se utilizará    
    private String destinatario;
    private String claveGenerada;

    public String getClaveGenerada() {
        return claveGenerada;
    }

    public void setClaveGenerada(String claveGenerada) {
        this.claveGenerada = claveGenerada;
    }

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

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @PostConstruct
    public void init() {
        cliente = new Cliente();
    }

    //Metodo para enviar correos
    public void enviar() {       
        int clienteId;     
        this.cliente.setCorreo(this.destinatario);//Envio del correo a la clase cliente
        clienteId = this.clienteFacade.ExisteCorreo(cliente);//Se guarda el id de cliente que retorna el metodo Existe Correo
        this.cliente.setIdCliente(clienteId);
        try {
            if (clienteId != 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha enviado un correo a la dirección ingresada. Verifique.", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El correo ingresado no coincide con ninguna cuenta existente.", ""));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Ha ocurrido un error, intente más tarde", ""));
        }

        //Validamos si ya existe una contraseña generada para enviar el correo
        if (!claveGenerada.isEmpty()) {             
            try {
                //Obtenemos el nombre del cliente                
                String nombreCliente = this.clienteFacade.nombreCliente(cliente);

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
                message.setSubject("Restablecer contraseña");
                message.setText(
                        "Hola " + nombreCliente + ",\n"
                        + "\nRecibimos una solicitud para restablecer tu contraseña. "
                        + " \n\n Esta es tu nueva clave: " + claveGenerada);

                // Lo enviamos.
                Transport t = session.getTransport("smtp");
                t.connect("celavieonline@gmail.com", "celavie123");
                t.sendMessage(message, message.getAllRecipients());

                // Cierre.
                t.close();

                //Actualizar clave
                User us = new User();
                us.setCliente(cliente);
                us.setClave(claveGenerada);
                userFacade.ActualizarUsuario(us);
            } catch (MessagingException e) {

            }
        } else {
            mensaje = "Debe generar una clave nueva. Después seleccione enviar.";
        }
    }
    
    //Metodo para enviar correos
    public void enviarReporte() {
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
                    new InternetAddress(destinatario));//Acá se recupera el correo de destino ingresado en el formulario.
            message.setSubject("Prueba de restaurar contraseña");
            message.setContent("<table class=\"egt\">\n"
                    + "\n"
                    + "  <tr>\n"
                    + "\n"
                    + "    <td><b>Celda 1</b></td>\n"
                    + "\n"
                    + "    <td>Celda"+destinatario+"</td>\n"
                    + "\n"
                    + "    <td><input type =\"button\" > </td>\n"
                    + "\n"
                    + "  </tr>\n"
                    + "\n"
                    + "  <tr>\n"
                    + "\n"
                    + "    <td>Celda 4</td>\n"
                    + "\n"
                    + "    <td>Celda 5</td>\n"
                    + "\n"
                    + "    <td>Celda 6</td>\n"
                    + "\n"
                    + "  </tr>\n"
                    + "\n"
                    + "</table>", "text/html");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("celavieonline@gmail.com", "celavie123");//la dirección de correo y la contraseña desde donde se enviará el mensaje.
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (MessagingException e) {
        }
    }
}
