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
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "productoController")
@SessionScoped
public class ProductoController implements Serializable{

    @EJB
    private ProductoFacadeLocal productoEJB;
    private Producto producto;
    private List<Producto> listaproducto;
    private List<Producto> consultaProductos;
    private String mensaje;
    private String estado;
    /* Variables para manejar la consulta de condiciones de los items*/
    /* Aviso es el mensaje que va a imprimir en el UX*/
    private String aviso;
    /* variable de tipo booleana para corroborar la eficacia del metodo creado en el Facade */
    private boolean res;

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

    private List<Producto> filtroProducto = new ArrayList<>();


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

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

    public List<Producto> getConsultaProductos() {
        this.consultaProductos = this.productoEJB.filtroProductosCategoria(estado);
        return consultaProductos;
    }

    public void setConsultaProductos(List<Producto> consultaProductos) {
        this.consultaProductos = consultaProductos;
    }
    
    /* Metodo get y set de la variale string aviso */

    /* get */
    /* se utiliza toda la entidad producto*/ 
    public String getAviso(Producto p) {
        /* Mensajito default vacio que muestra la disponibilidad de los productos*/
        String stock = "";
        /* try-catch para verificar que el metodo no va a fallar */
        try {
            /* Variable de tipo booleana que almacena el metodo llamado en la variable de tipo EJB 
            que accede desde el Idproducto, este metodo anteriormente descrito nos indicara si 
            los items de un producto son menores o iguales a cinco*/
            res = this.productoEJB.stockcero(p.getIdProducto());
            /*Si es verdadero colocara un mensajito que diga "agotado" o "fuera de stock" */
            if (res) {
                stock = "Fuera de Stock";
                /* se hace referencia al objeto string aviso */
                this.aviso = "Fuera de Stock";
                /* instanciacion de un objeto de tipo Faces para colocar
                en el UX de primefaces que posee la pagina de catalogo */
                FacesMessage msj = new FacesMessage(aviso);
                /* Uso de FacesContext  para agregar un mensaje y almacenarla en aviso */
                FacesContext.getCurrentInstance().addMessage(aviso, msj);
            } else {
                /* En caso de no cumplir la condicion descrita anteriormente, solo nos imprimira en cosola
                "hay objetos en stock" */
                System.out.println("hay productos en stock");
            }
            /*Un catch que nos indicara si algo salio mal */
        } catch (Exception e) {
            /* referenciamos el objeto aviso y capturamos la excepcion para mostrarla en mensaje */
            this.aviso = "Error" + e.getMessage();
            /* lo presentamos en la traza de error */
            e.printStackTrace();
        }
        /* referenciamos al objeto aviso y le asignamos la variable stock declarada anteriormente */
        this.aviso = stock;
        /* regresamos la variable de tipo string*/
        return aviso;
    }

    /* set */
    public void setAviso(String aviso) {
        this.aviso = aviso;
    }

    @PostConstruct
    public void init() {
        this.marca = new Marca();
        this.talla = new Talla();
        this.tiporopa = new TipoRopa();
        this.categoria = new Categoria();
        this.producto = new Producto();
        this.listamarca = marcaEJB.findAll();
        this.listatalla = tallaEJB.findAll();
        this.listatiporopa = tiporopaEJB.findAll();
        this.listacategoria = categoriaEJB.findAll();
        this.listaproducto = productoEJB.findAll();
    }

    public void consultarMarca() {
        listamarca = marcaEJB.findAll();
    }

    public void consultarTalla() {
        listatalla = tallaEJB.findAll();
    }

    public void consultarTipoRopa() {
        listatiporopa = tiporopaEJB.findAll();
    }

    public void consultarCategoria() {
        listacategoria = categoriaEJB.findAll();
    }

    public void insertar() {
        try {
            this.producto.setMarca(marca);
            this.producto.setTalla(talla);
            this.producto.setTipoRopa(tiporopa);
            this.producto.setCategoria(categoria);
            this.productoEJB.create(producto);
            this.mensaje = "Producto registrado exitosamente";
            limpiar();
        } catch (Exception e) {
            this.mensaje = "Error, imposible registrar";
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void actualizar() {
        try {
            /*metodo para actualizar los productos*/
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

    public void cargarData(Producto p) {
        try {
            this.marca.setIdMarca(p.getMarca().getIdMarca());
            this.talla.setIdTalla(p.getTalla().getIdTalla());
            this.tiporopa.setIdTipoRopa(p.getTipoRopa().getIdTipoRopa());
            this.categoria.setIdCategoria(p.getCategoria().getIdCategoria());
            this.producto = p;
        } catch (Exception e) {
        }
    }

    public void eliminar(Producto p) {
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

    public void limpiar() {
        this.marca = new Marca();
        this.talla = new Talla();
        this.tiporopa = new TipoRopa();
        this.categoria = new Categoria();
        this.producto = new Producto();
        this.listamarca = marcaEJB.findAll();
        this.listatalla = tallaEJB.findAll();
        this.listatiporopa = tiporopaEJB.findAll();
        this.listacategoria = categoriaEJB.findAll();
        this.listaproducto = productoEJB.findAll();
    }

}
