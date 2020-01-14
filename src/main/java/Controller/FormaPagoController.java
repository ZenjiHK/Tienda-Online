/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.FormaPagoFacadeLocal;
import Entity.FormaPago;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author evelyn.andradeusam
 */
@Named(value = "formaPagoController")
@SessionScoped
public class FormaPagoController implements Serializable {

    @EJB
    private FormaPagoFacadeLocal formaPagoEJB;
    private List<FormaPago> listapago;
    private FormaPago formapago;
    private String msg;

    public List<FormaPago> getListapago() {
        this.listapago = this.formaPagoEJB.findAll();
        return listapago;
    }

    public void setListapago(List<FormaPago> listapago) {
        this.listapago = listapago;
    }

    public FormaPago getFormapago() {
        return formapago;
    }

    public void setFormapago(FormaPago formapago) {
        this.formapago = formapago;
    }

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        this.formapago = new FormaPago();
    }

    public void crear() {
        try {
            formaPagoEJB.create(this.formapago);
            limpiar();
            msg = "Exito";
        } catch (Exception e) {
            msg = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editar() {
        try {
            formaPagoEJB.edit(this.formapago);
            limpiar();
            msg = "Exito";
        } catch (Exception e) {
            msg = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(FormaPago fp) {
        try {
            formaPagoEJB.remove(fp);
            limpiar();
            msg = "Exito";
        } catch (Exception e) {
            msg = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(FormaPago fp) {
        try {
            limpiar();
            this.formapago = fp;
            msg = "Exito";
        } catch (Exception e) {
            msg = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void escogerPago() {
        FormaPago fp = new FormaPago();
        String redireccion = "";
        try {
            fp = this.formaPagoEJB.escogerPago(this.formapago);
            if (fp != null) {
                if (fp.getIdFormaPago() == 1) {
                    redireccion = "http://localhost:8080/Tienda-Online/faces/admin/producto.xhtml";
                } else if (fp.getIdFormaPago() == 2) {
                    redireccion = "http://localhost:8080/Tienda-Online/faces/admin/user.xhtml";
                } else if (fp.getIdFormaPago() == 3) {
                    redireccion = "http://localhost:8080/Tienda-Online/faces/admin/pagopaypal.xhtml";
                }
            }
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(redireccion);
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage((null), new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }

    }
}
