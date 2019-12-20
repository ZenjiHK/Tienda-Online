package Controller;

import EJB.CategoriaFacadeLocal;
import Entity.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "categoriaController")
@RequestScoped
public class CategoriaController implements Serializable{
    
     private String mensaje;
    
    @EJB
    //Este NO tiene Get y Set
    private CategoriaFacadeLocal categoriaEJB;
    
    //Solamente a este se le coloca Get y Set
    private Categoria categoria;
    private List<Categoria> listaCategoria;

    public List<Categoria> getListaCategoria() {
        //Llenamos listaCategoria a través de categoriaFacade
        this.listaCategoria = this.categoriaEJB.findAll();
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    //Anotaciones de JPA para poder inyectar/invocar librerías de persistencia.
    //Sirve para que el método init se vuelva un constructor
    @PostConstruct
    //La palabra init es obligación. De lo contrario, da problemas
    public void init(){
        //Inicializamos variable categoría. Es lo primero que se ejecuta
        categoria = new Categoria();
    }
    
    public void insertar(){
        try {
            //Llamamos al método "create", y le mandamos un objeto de Categoria
            categoriaEJB.create(categoria);
            this.mensaje="Insertado con éxito";
        } catch (Exception e) {
            this.mensaje="ERROR";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
    
    public void leerid(Categoria cat){
        try {
            this.categoria = cat;
        } catch (Exception e) {
        }
        
    }
    
    public void modificar(){
        try {
            categoriaEJB.edit(categoria);
           this.mensaje="Editado con éxito";
        } catch (Exception e) {
            this.mensaje="ERROR";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
    
    public void eliminar(Categoria cat){
        try {
            this.categoria = cat;
            categoriaEJB.remove(categoria);
            listaCategoria = categoriaEJB.findAll();
          this.mensaje="Eliminado con éxito";
        } catch (Exception e) {
            this.mensaje="ERROR";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
}
