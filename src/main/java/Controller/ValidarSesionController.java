
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named (value = "validarSesionController")
@SessionScoped
public class ValidarSesionController implements Serializable{
    String redirect="";
    public void validarSesion() {
        try {
            User dato = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            if (dato == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../PaginaPrincipal/Usuario.xhtml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void index() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("./../PaginaPrincipal/PaginaPrincipal.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void salir() {

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("./../PaginaPrincipal/Usuario.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String redireccion(){
    redirect="/User/perfilUsuario?faces-redirect=true";
    
    return redirect;
    
    }
    public String redireccionTargetas(){
    redirect="/User/misTarjetas?faces-redirect=true";
    
    return redirect;
    
    }
}
