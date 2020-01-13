package Controller;

import EJB.RolFacadeLocal;
import Entity.Rol;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "rolController")
@SessionScoped
public class RolController implements Serializable{
    
    @EJB
    private RolFacadeLocal rolFacade;
    private Rol rol;
    private List<Rol> listaRol;
    private String mensaje;

    public List<Rol> getListaRol() {
        this.listaRol = rolFacade.findAll();
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
    }
    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @PostConstruct
    public void init(){
        this.rol = new Rol();
        this.listaRol=rolFacade.findAll();
        this.mensaje="";
    }
    
    public void insertar(){
        try {
            rolFacade.create(rol);
            this.mensaje = "Insertado con éxito";
        } catch (Exception e) {
            this.mensaje = "ERROR: "+e.getMessage();
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
    
    public void cargarDatos(Rol r){
        try {
            this.rol = r;
        } catch (Exception e) {
        }
    }
    
    public void editar(){
        try {
            rolFacade.edit(rol);
            this.mensaje = "Editado con éxito";
        } catch (Exception e) {
            this.mensaje = "ERROR: "+e.getMessage();
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
    
    public void eliminar(Rol r){
        try {
            rolFacade.remove(r);
            this.mensaje = "Eliminado con éxito";
        } catch (Exception e) {
            this.mensaje = "ERROR: "+e.getMessage();
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
    public void limpiar(){
        this.rol = new Rol();
        this.listaRol=rolFacade.findAll();
        this.mensaje="";
    }
}
