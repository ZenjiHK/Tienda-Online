package Controller;

import EJB.CategoriaFacadeLocal;
import EJB.MarcaFacadeLocal;
import EJB.ProductoFacadeLocal;
import EJB.TallaFacadeLocal;
import EJB.TipoRopaFacadeLocal;
import Entity.Categoria;
import Entity.Marca;
import Entity.Producto;
import Entity.Talla;
import Entity.TipoRopa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "ProductoController")
@RequestScoped
public class ProductoController implements Serializable{
    
    @EJB
    private ProductoFacadeLocal productoEJB;
    private Producto producto;
    private List<Producto> listaproducto;
    private String mensaje;
    
    @EJB
    private MarcaFacadeLocal marcaEJB;
    private Marca marca;
    private List<Marca> listamarca;
   
    @EJB
    private TallaFacadeLocal tallaEJB;
    private Talla talla;
    private List<Talla> listatalla;
   
    @EJB
    private TipoRopaFacadeLocal tiporopaEJB;
    private TipoRopa tiporopa;
    private List<TipoRopa> listatiporopa;
   
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    private Categoria categoria;
    private List<Categoria> listacategoria;

    private List<Producto> filtroProducto=new ArrayList<>();
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaproducto() {
         this.listaproducto = this.productoEJB.findAll();
        return listaproducto;
    }

    public void setListaproducto(List<Producto> listaproducto) {
        this.listaproducto = listaproducto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Marca> getListamarca() {
        return listamarca;
    }

    public void setListamarca(List<Marca> listamarca) {
        this.listamarca = listamarca;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public List<Talla> getListatalla() {
        return listatalla;
    }

    public void setListatalla(List<Talla> listatalla) {
        this.listatalla = listatalla;
    }

    public TipoRopa getTiporopa() {
        return tiporopa;
    }

    public void setTiporopa(TipoRopa tiporopa) {
        this.tiporopa = tiporopa;
    }

    public List<TipoRopa> getListatiporopa() {
        return listatiporopa;
    }

    public void setListatiporopa(List<TipoRopa> listatiporopa) {
        this.listatiporopa = listatiporopa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getListacategoria() {
        return listacategoria;
    }

    public void setListacategoria(List<Categoria> listacategoria) {
        this.listacategoria = listacategoria;
    }

    public List<Producto> getFiltroProducto() {
        return filtroProducto;
    }

    public void setFiltroProducto(List<Producto> filtroProducto) {
        this.filtroProducto = filtroProducto;
    }

    @PostConstruct
    public void init(){
        this.marca = new Marca();
        this.talla = new Talla();
        this.tiporopa = new TipoRopa();
        this.categoria = new Categoria();
        this.producto = new Producto();
        this.listamarca=marcaEJB.findAll();
        this.listatalla=tallaEJB.findAll();
        this.listatiporopa=tiporopaEJB.findAll();
        this.listacategoria=categoriaEJB.findAll();
        this.listaproducto=productoEJB.findAll();
        this.mensaje="";
    }
   
   public void consultarMarca(){
       listamarca = marcaEJB.findAll();
   }
    public void consultarTalla(){
        listatalla = tallaEJB.findAll();
    }
   
    public void consultarTipoRopa(){
        listatiporopa = tiporopaEJB.findAll();
    }
   
    public void consultarCategoria(){
        listacategoria = categoriaEJB.findAll();
    }
   
    public void insertar(){
        try {
            this.producto.setMarca(marca);
            this.producto.setTalla(talla);
            this.producto.setTipoRopa(tiporopa);
            this.producto.setCategoria(categoria);
            this.productoEJB.create(producto);
            this.mensaje = "Producto registrado exitosamente";
        } catch (Exception e) {
            this.mensaje = "Error, imposible registrar";
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
   
   
    public void actualizar(){
         try {
            this.producto.setMarca(marca);
            this.producto.setTalla(talla);
            this.producto.setTipoRopa(tiporopa);
            this.producto.setCategoria(categoria);
            this.productoEJB.edit(producto);
            this.mensaje = "Producto actualizado exitosamente";
        } catch (Exception e) {
            this.mensaje = "Error, imposible editar";
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
   
    public void cargarData(Producto p){
        try {
            this.marca.setIdMarca(p.getMarca().getIdMarca());
            this.talla.setIdTalla(p.getTalla().getIdTalla());
            this.tiporopa.setIdTipoRopa(p.getTipoRopa().getIdTipoRopa());
            this.categoria.setIdCategoria(p.getCategoria().getIdCategoria());
            this.producto = p;
        } catch (Exception e) {
        }
    }
   
    public void eliminar(Producto p){
        try {
           this.producto.setMarca(marca);
           this.producto.setTalla(talla);
           this.producto.setTipoRopa(tiporopa);
           this.producto.setCategoria(categoria);
           this.productoEJB.remove(p);
           this.mensaje = "Producto eliminado";
        } catch (Exception e) {
            this.mensaje = "Error" + e.getMessage();
            e.printStackTrace();
        }
    }

    public void limpiar(){
        this.marca = new Marca();
        this.talla = new Talla();
        this.tiporopa = new TipoRopa();
        this.categoria = new Categoria();
        this.producto = new Producto();
        this.listamarca=marcaEJB.findAll();
        this.listatalla=tallaEJB.findAll();
        this.listatiporopa=tiporopaEJB.findAll();
        this.listacategoria=categoriaEJB.findAll();
        this.listaproducto=productoEJB.findAll();
        this.mensaje="";
    }
}