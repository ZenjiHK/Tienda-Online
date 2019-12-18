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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author evelyn.andradeusam
 */
@ManagedBean
@SessionScoped
public class FormaPagoController implements Serializable{
    @EJB
private FormaPagoFacadeLocal FormaPagoEJB;
private List<FormaPago> listapago;
private FormaPago formapago;

    public List<FormaPago> getListapago() {
        this.listapago=this.FormaPagoEJB.findAll();
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
    formapago=new FormaPago();    
    }
    

}
