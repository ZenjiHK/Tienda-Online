package Controller;

import EJB.VentaFacadeLocal;
import Entity.Cliente;
import Entity.DetalleTarjeta;
import Entity.Producto;
import Entity.Venta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "ventaController")
@SessionScoped
public class VentaController implements Serializable {

    @EJB
    private VentaFacadeLocal ventaEJB;
    private List<Venta> lista_ventas;
    private Venta venta;
    private Cliente cliente;
    private DetalleTarjeta detalleTarjeta;
    private String msg;
    private List<Producto> lista;

    Timer time = new Timer();

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void cancelar() {
        try {
            venta.setEstado("Cancelado");
            ventaEJB.edit(venta);
            time.cancel();
            time.purge();
        } catch (Exception e) {
        }
    }

    public void crear() {
            System.out.println("Creando");
        try {
            this.venta.setEstado("Pendiente");
            this.venta.setCliente(cliente);
            this.venta.setDetalleTarjeta(detalleTarjeta);
            this.ventaEJB.create(venta);
            limpiar();
            this.msg = "Exito";
            TimerTask tiempo = new TimerTask() {
                @Override
                public void run() {
                    try {
                        venta.setEstado("Enviado");
                        ventaEJB.edit(venta);
                    } catch (Exception e) {
                    }
                }
            };
            System.out.println("Creado**********************************************");
            time.schedule(tiempo, 3000);
            FacesMessage mensaje = new FacesMessage(this.msg);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } catch (Exception e) {
            this.msg = "Error " + e.getMessage();
            e.printStackTrace();
            FacesMessage mensaje = new FacesMessage(this.msg);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            System.out.println("Error");
        }

    }

    public void editar() {
        try {
            this.venta.setCliente(cliente);
            this.venta.setDetalleTarjeta(detalleTarjeta);
            this.ventaEJB.edit(venta);
            limpiar();
            this.msg = "Exito";
        } catch (Exception e) {
            this.msg = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(msg, mensaje);
    }

    public void eliminar(Venta v) {
        try {
            this.ventaEJB.remove(v);
            limpiar();
            this.msg = "Exito";
        } catch (Exception e) {
            this.msg = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(msg, mensaje);
    }

    public void cargarDatos(Venta v) {
        try {
            limpiar();
            this.venta = v;
            this.msg = "Exito";
        } catch (Exception e) {
            this.msg = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(msg, mensaje);
    }

    public void limpiar() {
        this.venta = new Venta();
        this.cliente = new Cliente();
        this.detalleTarjeta = new DetalleTarjeta();
        this.msg = "";
    }

    public void contador() {
        try {

        } catch (Exception e) {
        }
    }

    public List<Venta> getLista_ventas() {
        this.lista_ventas = this.ventaEJB.findAll();
        return lista_ventas;
    }

    public void setLista_ventas(List<Venta> lista_ventas) {
        this.lista_ventas = lista_ventas;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DetalleTarjeta getDetalleTarjeta() {
        return detalleTarjeta;
    }

    public void setDetalleTarjeta(DetalleTarjeta detalleTarjeta) {
        this.detalleTarjeta = detalleTarjeta;
    }

    public void Enviar(List<Producto> l) {
        try {
            lista = l;
            msg = "Proceso Realizado";
        } catch (Exception e) {
            msg = "Error";
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(msg, msj);
    }
}
