/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.FacturaFacadeLocal;
import Entity.Factura;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario
 */
@Named(value = "facturaController")
@SessionScoped
public class FacturaController implements Serializable {

    @EJB
    private FacturaFacadeLocal facturaEJB;
    private List<Factura> lista_facturas;
    private Factura factura;
    private String msg;

    @PostConstruct
    public void init(){
        this.factura = new Factura();
        this.lista_facturas = facturaEJB.findAll();
        this.msg = "";
    }
    
    public void guardar(){
        try{
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
    public void actualizar(){
        try{
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
    public void cargar(Factura f){
        this.factura=f;
    }
    public void limpiar(){
        this.factura = new Factura();
        this.lista_facturas = facturaEJB.findAll();
        this.msg = "";
    }
}
