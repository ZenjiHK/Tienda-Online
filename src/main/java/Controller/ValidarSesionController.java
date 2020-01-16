
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
    
    public void validarCompra() {
        try {
            User dato = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            if (dato == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../User/userInactivo.xhtml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void index() {
        try {
            User dato = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
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
    
    public String redireccionCompra(){
    redirect="/User/realizarVenta?faces-redirect=true";
    
    return redirect;
    
    }
    
    public String redireccionInicio(){
    redirect="/PaginaPrincipal/PaginaPrincipal?faces-redirect=true";
    
    return redirect;
    
    }
    
    public String redireccionSesion(){
    redirect="/PaginaPrincipal/Usuario?faces-redirect=true";
    
    return redirect;
    
    }
    
    public String redireccionRegistro(){
    redirect="/PaginaPrincipal/RegistroUsuario?faces-redirect=true";
    
    return redirect;
    
    }
    
    public String redireccionCambioContra(){
    redirect="/PaginaPrincipal/cambioClave?faces-redirect=true";
    
    return redirect;
    
    }
    
    public String redireccionMetodoPago(){
    redirect="/User/metodoPago?faces-redirect=true";
    
    return redirect;    
    }
}
