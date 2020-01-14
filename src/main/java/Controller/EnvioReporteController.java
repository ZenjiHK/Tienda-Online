/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author evelyn andrade
 */
import EJB.ClienteFacadeLocal;
import EJB.DescuentoFacadeLocal;
import EJB.DetalleVentaFacadeLocal;
import EJB.ProductoFacadeLocal;
import EJB.UserFacadeLocal;
import EJB.VentaFacadeLocal;
import Entity.Cliente;
import Entity.Descuento;
import Entity.DetalleVenta;
import Entity.Producto;
import Entity.User;
import Entity.Venta;
import java.io.Serializable;
import java.util.Date;
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

@Named(value = "envioReporteController")
@SessionScoped
public class EnvioReporteController implements Serializable {

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

    @EJB
    private ProductoFacadeLocal productoFacade;
    private List<Producto> listaproducto;
    private Producto producto;

    @EJB
    private DetalleVentaFacadeLocal detalleFacade;
    private List<DetalleVenta> listaDetalle;
    private DetalleVenta detalle;
    String tabla;

    @EJB
    private VentaFacadeLocal ventaFacade;
    private List<Venta> listaventa;
    private Venta venta;

    @EJB
    private DescuentoFacadeLocal descuentoFacade;
    private List<Descuento> listadescuento;
    private Descuento descuento;

    public List<DetalleVenta> getListaDetalle() {
        this.listaDetalle = this.detalleFacade.findAll();
        return listaDetalle;
    }

    public void setListaDetalle(List<DetalleVenta> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public DetalleVenta getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleVenta detalle) {
        this.detalle = detalle;
    }

    public List<Venta> getListaventa() {
        return listaventa;
    }

    public void setListaventa(List<Venta> listaventa) {
        this.listaventa = listaventa;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    @PostConstruct
    public void init() {
        cliente = new Cliente();
        producto = new Producto();
        detalle = new DetalleVenta();
        venta = new Venta();
        descuento = new Descuento();

    }
/*
    //Metodo para enviar correos
    public void enviarReporte() {
        try {
            int idventa = 3;
            this.listaDetalle = this.detalleFacade.detalleFactura(idventa);
            Double cont = 0.0;
            for (DetalleVenta nombre : this.listaDetalle) {
                this.detalle = nombre;
                double subtotal = 0.00;
                subtotal = ((this.detalle.getProducto().getPrecioVenta() * this.detalle.getCantidad()) - (this.detalle.getDescuento().getDescuento() * (this.detalle.getProducto().getPrecioVenta() * this.detalle.getCantidad())));
                cont += subtotal;
                this.tabla = "<table border='2' style=\"width: 100%\" class=\"table-active table-bordered table-borderless table-dark\" >";
                this.tabla = this.tabla + "<tr align='center'>"
                        + "<td>Código: " + this.detalle.getVenta().getIdVenta() + "</td>"
                        + "<td>Producto: " + this.detalle.getProducto().getNombreProducto() + "</td>"
                        + "<td>Precio Unitario: " + this.detalle.getProducto().getPrecioVenta() + "</td>"
                        + "<td>Cantidad: " + this.detalle.getCantidad() + "</td>"
                        + "<td>Descuento: " + this.detalle.getDescuento().getDescuento() + "</td>"
                        + "<td>Sub-Total: " + subtotal + "</td>"
                        + "</tr>";
                this.tabla = this.tabla + "</table>";
                System.out.println("ajajajaja" + this.detalle.getProducto().getNombreProducto());
            }

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
                    new InternetAddress("moran_andrade@hotmail.com"));
            message.setSubject("Detalle de factura");
            message.setContent(
                    "fecha: " + this.detalle.getVenta().getFecha() + ",\n"
                    + "\n Hola " + this.detalle.getVenta().getCliente().getNombreCliente() + ",\n"
                    + "\n Hemos Recibido tu pedido. "
                    + " \n\n Este es tudetal detalle de Compra C'E La Vie"
                    + " \n Gracias por preferirnos"
                    + this.tabla,
                    "text/html");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("celavieonline@gmail.com", "celavie123");
            t.sendMessage(message, message.getAllRecipients());
            // Cierre.
            t.close();

        } catch (MessagingException e) {
        }
    }*/
}
