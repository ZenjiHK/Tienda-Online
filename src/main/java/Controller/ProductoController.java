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
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "productoController")
@SessionScoped
public class ProductoController implements Serializable {

    @EJB
    private ProductoFacadeLocal productoEJB;
    private Producto producto;
    private List<Producto> listaproducto;
    private String mensaje;
    private String estado;
    //Listas para mostrar las diferentes opciones del catalogo
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

    //Filtros para el menú
    private List<Producto> listaMujeresBlusas;
    private List<Producto> listaMujeresTop;
    private List<Producto> listaMujeresPantalon;
    private List<Producto> listaMujeresFalda;
    private List<Producto> listaMujeresVestido;
    private List<Producto> listaHombreSport;
    private List<Producto> listaHombreCasual;
    private List<Producto> listaHombreFormales;
    private List<Producto> listaHombreJeans;
    private List<Producto> listaHombrePantalon;
    private List<Producto> listaHombreShort;
    private List<Producto> listaNinoCamisa;
    private List<Producto> listaNinoPijama;
    private List<Producto> listaNinoPantalon;
    private List<Producto> listaNinoShort;
    private List<Producto> listaNinaFaldas;
    private List<Producto> listaMujer;
    private List<Producto> listaHombre;
    private List<Producto> listaInfantil;

    public List<Producto> getListaMujeresBlusas() {
        this.listaMujeresBlusas = this.productoEJB.filtroProductosCategoria("Blusas", "Mujer");
        return listaMujeresBlusas;
    }

    public void setListaMujeresBlusas(List<Producto> listaMujeresBlusas) {
        this.listaMujeresBlusas = listaMujeresBlusas;
    }

    public List<Producto> getListaMujeresTop() {
        this.listaMujeresTop = this.productoEJB.filtroProductosCategoria("Top", "Mujer");
        return listaMujeresTop;
    }

    public void setListaMujeresTop(List<Producto> listaMujeresTop) {
        this.listaMujeresTop = listaMujeresTop;
    }

    public List<Producto> getListaMujeresPantalon() {
        this.listaMujeresPantalon = this.productoEJB.filtroProductosCategoria("Pantalon", "Mujer");
        return listaMujeresPantalon;
    }

    public void setListaMujeresPantalon(List<Producto> listaMujeresPantalon) {
        this.listaMujeresPantalon = listaMujeresPantalon;
    }

    public List<Producto> getListaMujeresFalda() {
        this.listaMujeresFalda = this.productoEJB.filtroProductosCategoria("Falda", "Mujer");
        return listaMujeresFalda;
    }

    public void setListaMujeresFalda(List<Producto> listaMujeresFalda) {
        this.listaMujeresFalda = listaMujeresFalda;
    }

    public List<Producto> getListaMujeresVestido() {
        this.listaMujeresVestido = this.productoEJB.filtroProductosCategoria("Vestido", "Mujer");
        return listaMujeresVestido;
    }

    public void setListaMujeresVestido(List<Producto> listaMujeresVestido) {
        this.listaMujeresVestido = listaMujeresVestido;
    }

    public List<Producto> getListaHombreSport() {
        this.listaHombreSport = this.productoEJB.filtroProductosCategoria("Camisas Sport", "Hombre");
        return listaHombreSport;
    }

    public void setListaHombreSport(List<Producto> listaHombreSport) {
        this.listaHombreSport = listaHombreSport;
    }

    public List<Producto> getListaHombreCasual() {
        this.listaHombreCasual = this.productoEJB.filtroProductosCategoria("Camisas casuales", "Hombre");
        return listaHombreCasual;
    }

    public void setListaHombreCasual(List<Producto> listaHombreCasual) {
        this.listaHombreCasual = listaHombreCasual;
    }

    public List<Producto> getListaHombreFormales() {
        this.listaHombreFormales = this.productoEJB.filtroProductosCategoria("Camisas formales", "Hombre");
        return listaHombreFormales;
    }

    public void setListaHombreFormales(List<Producto> listaHombreFormales) {
        this.listaHombreFormales = listaHombreFormales;
    }

    public List<Producto> getListaHombreJeans() {
        this.listaHombreJeans = this.productoEJB.filtroProductosCategoria("Jeans", "Hombre");
        return listaHombreJeans;
    }

    public void setListaHombreJeans(List<Producto> listaHombreJeans) {
        this.listaHombreJeans = listaHombreJeans;
    }

    public List<Producto> getListaHombrePantalon() {
        this.listaHombrePantalon = this.productoEJB.filtroProductosCategoria("Pantalon de vestir", "Hombre");
        return listaHombrePantalon;
    }

    public void setListaHombrePantalon(List<Producto> listaHombrePantalon) {
        this.listaHombrePantalon = listaHombrePantalon;
    }

    public List<Producto> getListaHombreShort() {
        this.listaHombreShort = this.productoEJB.filtroProductosCategoria("Short", "Hombre");
        return listaHombreShort;
    }

    public void setListaHombreShort(List<Producto> listaHombreShort) {
        this.listaHombreShort = listaHombreShort;
    }

    public List<Producto> getListaNinoCamisa() {
        this.listaNinoCamisa = this.productoEJB.filtroProductosCategoria("Camisas", "Infantil");
        return listaNinoCamisa;
    }

    public void setListaNinoCamisa(List<Producto> listaNinoCamisa) {
        this.listaNinoCamisa = listaNinoCamisa;
    }

    public List<Producto> getListaNinoPijama() {
        this.listaNinoPijama = this.productoEJB.filtroProductosCategoria("Pijama", "Infantil");
        return listaNinoPijama;
    }

    public void setListaNinoPijama(List<Producto> listaNinoPijama) {
        this.listaNinoPijama = listaNinoPijama;
    }

    public List<Producto> getListaNinoPantalon() {
        this.listaNinoPantalon = this.productoEJB.filtroProductosCategoria("Pantalon", "Infantil");
        return listaNinoPantalon;
    }

    public void setListaNinoPantalon(List<Producto> listaNinoPantalon) {
        this.listaNinoPantalon = listaNinoPantalon;
    }

    public List<Producto> getListaNinoShort() {
        this.listaNinoShort = this.productoEJB.filtroProductosCategoria("Short", "Infantil");
        return listaNinoShort;
    }

    public void setListaNinoShort(List<Producto> listaNinoShort) {
        this.listaNinoShort = listaNinoShort;
    }

    public List<Producto> getListaNinaFaldas() {
        this.listaNinaFaldas = this.productoEJB.filtroProductosCategoria("Faldas", "Infantil");
        return listaNinaFaldas;
    }

    public void setListaNinaFaldas(List<Producto> listaNinaFaldas) {
        this.listaNinaFaldas = listaNinaFaldas;
    }

    public List<Producto> getListaMujer() {
        this.listaMujer = this.productoEJB.filtroCategoria("Mujer");
        return listaMujer;
    }

    public void setListaMujer(List<Producto> listaMujer) {
        this.listaMujer = listaMujer;
    }

    public List<Producto> getListaHombre() {
        this.listaHombre = this.productoEJB.filtroCategoria("Hombre");
        return listaHombre;
    }

    public void setListaHombre(List<Producto> listaHombre) {
        this.listaHombre = listaHombre;
    }

    public List<Producto> getListaInfantil() {
        this.listaInfantil = this.productoEJB.filtroCategoria("Infantil");
        return listaInfantil;
    }

    public void setListaInfantil(List<Producto> listaInfantil) {
        this.listaInfantil = listaInfantil;
    }


   
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