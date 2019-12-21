package Controller;

import EJB.DetalleTarjetaFacadeLocal;
import Entity.Cliente;
import Entity.DetalleTarjeta;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "detalleTarjetaController")
@RequestScoped
public class DetalleTarjetaController implements Serializable {
  
    @EJB
    private DetalleTarjetaFacadeLocal DetalleTarjetaEJB;
    private List<DetalleTarjeta> listaTarjeta;
    private DetalleTarjeta detalletarjeta;
    private Cliente cliente;
    String msj;

    public List<DetalleTarjeta> getListaTarjeta() {
        this.listaTarjeta = this.DetalleTarjetaEJB.findAll();
        return listaTarjeta;
    }

    public void setListaTarjeta(List<DetalleTarjeta> listaTarjeta) {
        this.listaTarjeta = listaTarjeta;
    }

    public DetalleTarjeta getDetalletarjeta() {
        return detalletarjeta;
    }

    public void setDetalletarjeta(DetalleTarjeta detalletarjeta) {
        this.detalletarjeta = detalletarjeta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @PostConstruct
    public void init() {
        this.detalletarjeta = new DetalleTarjeta();
        this.cliente = new Cliente();
    }

    public void insertar() {
        try {
            this.detalletarjeta.setCliente(cliente);
            this.DetalleTarjetaEJB.create(detalletarjeta);
            this.detalletarjeta = new DetalleTarjeta();
            this.cliente = new Cliente();
            this.msj = "Detalle de tarjeta ingresado correctamente";
        } catch (Exception e) {
            this.msj = "Error al ingresar" + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);

    }

    public void CargarTarjeta(DetalleTarjeta dta) {
        this.cliente.setIdCliente(dta.getCliente().getIdCliente());
        this.detalletarjeta = dta;
    }

    public void editar() {
        try {
            this.detalletarjeta.setCliente(cliente);
            this.DetalleTarjetaEJB.edit(detalletarjeta);
            this.detalletarjeta = new DetalleTarjeta();
            this.cliente = new Cliente();
            this.msj = "Detalle de tarjeta actualizado correctamente";
        } catch (Exception e) {
            this.msj = "Error al actualizar" + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpiar() {
        this.detalletarjeta = new DetalleTarjeta();
        this.cliente = new Cliente();
    }

    public void eliminar(DetalleTarjeta dta) {
      try {
            this.DetalleTarjetaEJB.remove(dta);
            this.detalletarjeta = new DetalleTarjeta();            
            this.msj = "Detalle de tarjeta eliminado correctamente";
        } catch (Exception e) {
            this.msj = "Error al eliminar" + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

}