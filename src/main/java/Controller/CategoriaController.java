package Controller;

import EJB.CategoriaFacadeLocal;
import Entity.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "categoriaController")
@SessionScoped
public class CategoriaController implements Serializable{
    
     private String mensaje;//Mensaje
    
    @EJB
    private CategoriaFacadeLocal categoriaEJB;    
    private Categoria categoria;
    private List<Categoria> listaCategoria;

    public List<Categoria> getListaCategoria() {
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
        listaCategoria = categoriaEJB.findAll();
    }
    
    public void insertar(){
        try {
            //Llamamos al método "create", y le mandamos un objeto de Categoria
            categoriaEJB.create(categoria);
            this.mensaje="Insertado con éxito";
            limpiar();
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
    
    public void limpiar(){
        this.categoria = new Categoria();
        this.listaCategoria = categoriaEJB.findAll();
        this.mensaje = "";
    }
    
    //Metodo eliminar
    public void eliminar(Categoria c) {
        try {
            this.categoriaEJB.remove(c);
            this.categoria = new Categoria();
            this.mensaje = "categoria eliminada";
        } catch (Exception e) {
            this.mensaje = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }
    
}
