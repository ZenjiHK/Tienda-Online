package Controller;

import EJB.MarcaFacadeLocal;
import Entity.Marca;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "marcaController")
@SessionScoped
public class MarcaController implements Serializable{
    
    @EJB
    private MarcaFacadeLocal marcaEJB;
    private Marca marca;
    private List<Marca> listamarca;
    private String mensaje;

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Marca> getListamarca() {
        this.listamarca = this.marcaEJB.findAll();
        return listamarca;
    }

    public void setListamarca(List<Marca> listamarca) {
        this.listamarca = listamarca;
    }
    
    @PostConstruct
    public void init(){
        this.marca = new Marca();
        this.listamarca= marcaEJB.findAll();
        this.mensaje="";
    }
    
    public void insertar(){
        try {
            marcaEJB.create(marca);
            this.mensaje = "insertado con exito";   
            limpiar();
        } catch (Exception e) {
            this.mensaje = "Error insertando datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
    
    public void leerid(Marca mar){
         try {
            this.marca = mar;
        } catch (Exception e) {
        }
        
    }
    
    public void actualizar(){
        try {
            marcaEJB.edit(marca);
            this.mensaje = "actualizado con exito";          
        } catch (Exception e) {
            this.mensaje = "Error actualizando datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
    
    public void eliminar(Marca mar){
        try {
            this.marca = mar;
            marcaEJB.remove(marca);
            listamarca = marcaEJB.findAll();
        this.mensaje="Eliminado con éxito";
        } catch (Exception e) {
            this.mensaje="ERROR";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
    
    public void limpiar(){
        this.marca = new Marca();
        this.listamarca= marcaEJB.findAll();     
    }
}