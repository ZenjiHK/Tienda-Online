package Controller;

import EJB.ClienteFacadeLocal;
import EJB.DetalleVentaFacadeLocal;
import EJB.VentaFacadeLocal;
import Entity.Descuento;
import Entity.DetalleVenta;
import Entity.Producto;
import Entity.Venta;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "detalleVentaController")
@SessionScoped
public class DetalleVentaController implements Serializable {

    @EJB
    private DetalleVentaFacadeLocal detalleVentaEJB;
    private DetalleVenta detalleVenta;
    private List<DetalleVenta> lista;
    private List<Producto> list;
    private List<Integer> cantidades;
    private String msg;
    private double total;
    private int contador = 0;
    private Descuento d;
    private Venta v;
    private DetalleVenta dt;
    private Producto p;
    private List<DetalleVenta> vendidos;

    @EJB
    private ClienteFacadeLocal clientesFacadeLocal;
    @EJB
    private VentaFacadeLocal ventasFacadeLocal;

    public DetalleVenta getDt() {
        return dt;
    }

    public void setDt(DetalleVenta dt) {
        this.dt = dt;
    }

    public List<DetalleVenta> getVendidos() {
        return vendidos;
    }

    public void setVendidos(List<DetalleVenta> vendidos) {
        this.vendidos = vendidos;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public Descuento getD() {
        return d;
    }

    public void setD(Descuento d) {
        this.d = d;
    }

    public Venta getV() {
        return v;
    }

    public void setV(Venta v) {
        this.v = v;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public List<DetalleVenta> getLista() {
        this.lista = this.detalleVentaEJB.findAll();
        return lista;
    }

    public void setLista(List<DetalleVenta> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        detalleVenta = new DetalleVenta();
        v = new Venta();
        d = new Descuento();
        dt = new DetalleVenta();
        list = new LinkedList<>();
        vendidos = new LinkedList<>();
    }

    /*
    public void insertar() {
        try {
            this.detalleVenta.setIdProducto(this.p);
            this.detalleVenta.setVenta(v);
            this.detalleVentaEJB.create(detalleVenta);
            limpiar();
            this.msg = "Detalle de venta ingresado correctamente";
            /* detalleVentaEJB.create(detalleVenta);
        } catch (Exception e) {
            this.msg = "Error";
        }
         FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void limpiar(){
    this.detalleVenta = new DetalleVenta();
    this.p = new Producto();
    this.v = new Venta();
    this.detalleVenta.setIdProducto(this.p);
    this.detalleVenta.setVenta(v);
    }
     */
    public void listar() {
        try {
            lista = detalleVentaEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void leerid(DetalleVenta dv) {
        try {
            this.detalleVenta = dv;
        } catch (Exception e) {
        }
    }

    public void modificar() {
        try {
            detalleVentaEJB.edit(detalleVenta);
        } catch (Exception e) {
        }
    }

    public void eliminar(DetalleVenta dv) {
        try {
            this.detalleVenta = dv;
            detalleVentaEJB.remove(detalleVenta);
            lista = detalleVentaEJB.findAll();
        } catch (Exception e) {
        }
    }

    /*Método para vaciar todos los productos del carrito*/
    public void deleteAll(Producto pro) {
        try {
            list.removeAll(list);
            this.setContador(0);
            this.setTotal(0);
            msg = "Carrito vacío";
        } catch (Exception e) {
            this.msg = "Error al vaciar";
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(msg, msj);
    }

    /*Método para eliminar productos específicos dentro del panel del carrito*/
    public void delete(Producto pr) {
        try {
            list.remove(pr);
            this.Total2();
            msg = "Producto eliminado";
        } catch (Exception e) {
            this.msg = "Error";
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(msg, msj);
    }

    /*Método para borrar la lista de los detalles de la venta*/
    public void borrar(DetalleVenta d) {
        try {
            this.vendidos.remove(d);
            msg = "Producto eliminado";
        } catch (Exception e) {
            this.msg = "Error";
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(msg, msj);
    }

    /*Método para añadir los datos de la tabla de productos al panel del botón "ver carrito"*/
    public void añadir(Producto p) {
        try {
            list.add(p);
            //cantidades.add(detalleVenta.getCantidad());
            msg = "Se agrego producto al carrito";
            Total();
        } catch (Exception e) {
            this.msg = "Error";
            e.printStackTrace();
        }

        FacesMessage msj = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(msg, msj);
    }

    /*Método para guardar los datos que se muestran en el panel de "Ver carrito"*/
    public void guardar() {
        int tamaño = lista.size();
        while (tamaño > 0) {
            this.detalleVentaEJB.create(lista.get(tamaño - 1));

            tamaño = tamaño + 1;
        }
    }

    public List<Producto> getList() {
        return list;
    }

    public void setList(List<Producto> list) {
        this.list = list;
    }

    /*Total y contador del panel que se muestra en el botón "Ver carrito"*/
    public void Total() {
        total = 0;
        for (int a = 0; a < list.size(); a++) {
            total = total + list.get(a).getPrecioVenta();

        }
        contador++;
    }

    public void Total2() {
        total = 0;
        for (int a = 0; a < list.size(); a++) {
            total = total + list.get(a).getPrecioVenta();

        }
        contador--;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    /*Metodo que recibe los datos del carrito y los envia a la vista "Detalle venta"*/
    public void Enviar1() {
        try {
            for (int a = 0; a < this.list.size(); a++) {
                
                this.d = new Descuento();
                this.v = this.ventasFacadeLocal.findAll().get(0);
                this.d.setIdDescuento(1);
                this.d.setDescuento(0);
                this.v.setCliente(this.clientesFacadeLocal.findAll().get(0));
                this.dt = new DetalleVenta();
                this.dt.setIdDetalleVenta(a);
                this.dt.setIdProducto(this.list.get(a));
                this.dt.setCantidad(1);
                this.dt.setTotal(this.dt.getProducto().getPrecioVenta() * this.dt.getCantidad());
                this.dt.setDescuento(this.d);
                this.dt.setVenta(this.v);
                this.vendidos.add(this.dt);
            }
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect("http://localhost:8080/Tienda-Online/faces/User/realizarVenta.xhtml");
        } catch (IOException e) {
            
        }
    }

}

