/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import EJB.FormaPagoFacadeLocal;
import Entity.FormaPago;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author evelyn.andradeusam
 */

@ManagedBean
@SessionScoped
public class FormaPagoControl implements Serializable{
@EJB
private FormaPagoFacadeLocal FormaPagoEJB;
private FormaPago formapago;
private List<FormaPago> lista;

    public FormaPago getFormapago() {
        return formapago;
    }

    public void setFormapago(FormaPago formapago) {
        this.formapago = formapago;
    }

    public List<FormaPago> getLista() {
        this.lista=this.FormaPagoEJB.findAll();
        return lista;
    }

    public void setLista(List<FormaPago> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init(){
    formapago=new FormaPago();    
    }
    
    public void insertar(){
        try {
            FormaPagoEJB.create(formapago);
        } catch (Exception e) {
        }
    }
    
    public  void leerById(FormaPago fp){
        try {
            this.formapago=fp;
        } catch (Exception e) {
        }
    }
    
    public void modificar(){
        try {
            FormaPagoEJB.edit(formapago);
            this.lista=FormaPagoEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void eliminar(FormaPago fp){
        this.formapago=fp;
        try {
            FormaPagoEJB.remove(formapago);
            lista=FormaPagoEJB.findAll();
        } catch (Exception e) {
        }
    
    }


}
