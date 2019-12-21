/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.FormaPagoFacadeLocal;
import Entity.FormaPago;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author evelyn.andradeusam
 */
@ManagedBean
@RequestScoped
public class FormaPagoController implements Serializable{
    
    @EJB
    private FormaPagoFacadeLocal formaPagoEJB;
    private List<FormaPago> listapago;
    private FormaPago formapago;
    private String msg;

    public List<FormaPago> getListapago() {
        this.listapago=this.formaPagoEJB.findAll();
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
    public void init(){
        limpiar();
    }
    
    public void limpiar(){
        this.formapago=new FormaPago();
        this.listapago = formaPagoEJB.findAll();
    }
    
    public void crear(){
        try{
            formaPagoEJB.create(formapago);
            limpiar();
            msg = "Exito";
        }catch(Exception e){
            msg = "Error " + e.getMessage();
            e.printStackTrace();
        }
    }
    
    public void editar(){
        try{
            formaPagoEJB.edit(formapago);
            limpiar();
            msg = "Exito";
        }catch(Exception e){
            msg = "Error " + e.getMessage();
            e.printStackTrace();
        }
    }
    
    public void eliminar(){
        try{
            formaPagoEJB.remove(formapago);
            limpiar();
            msg = "Exito";
        }catch(Exception e){
            msg = "Error " + e.getMessage();
            e.printStackTrace();
        }
    }
    
    public void cargarDatos(FormaPago fp){
        try{
            limpiar();
            this.formapago = fp;
            msg = "Exito";
        }catch(Exception e){
            msg = "Error " + e.getMessage();
            e.printStackTrace();
        }
    }
}