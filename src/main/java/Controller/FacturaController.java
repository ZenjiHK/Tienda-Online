package Controller;

import EJB.FacturaFacadeLocal;
import Entity.Factura;
import Entity.FormaPago;
import Entity.Venta;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "facturaController")
@SessionScoped
public class FacturaController implements Serializable {

    @EJB
    private FacturaFacadeLocal facturaEJB;
    private List<Factura> lista_facturas;
    private Factura factura;
    private Venta venta;
    private FormaPago formaPago;
    private String msg;

    @PostConstruct
    public void init(){
        limpiar();
    }
    
    public void crear(){
        try{
              this.factura.setVenta(venta);
            this.facturaEJB.create(factura);
            limpiar();
            this.msg = "Exito";
        }catch(Exception e){
            this.msg = "Error "+e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void editar(){
        try{
            this.factura.setVenta(venta);
            this.facturaEJB.edit(factura);
            limpiar();
            this.msg = "Exito";
        }catch(Exception e){
            this.msg = "Error "+e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminar(Factura f){
        try{
            this.facturaEJB.remove(f);
            limpiar();
            this.msg = "Exito";
        }catch(Exception e){
            this.msg = "Error "+e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void cargarDatos(Factura f){
        try{
            limpiar();
            this.factura=f;
            this.msg = "Exito";
        }catch(Exception e){
            this.msg = "Error "+e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void limpiar(){
        this.factura = new Factura();
        this.lista_facturas = facturaEJB.findAll();
        this.venta = new Venta();
        this.formaPago = new FormaPago();
        this.msg = "";
        this.factura.setVenta(venta);
    }

    public List<Factura> getLista_facturas() {
        return lista_facturas;
    }

    public void setLista_facturas(List<Factura> lista_facturas) {
        this.lista_facturas = lista_facturas;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
}