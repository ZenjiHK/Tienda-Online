package Controller;

import EJB.DetalleVentaFacadeLocal;
import EJB.ProductoFacadeLocal;
import Entity.DetalleVenta;
import Entity.Producto;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jose.cortezusam
 */
@Named(value = "detalleVentaController")
@SessionScoped
public class DetalleVentaController implements Serializable {

    @EJB
    private DetalleVentaFacadeLocal detalleVentaEJB;
    private DetalleVenta detalleVenta;
    private List<DetalleVenta> lista;
    private List<Producto> list;
    private String msg;
    private double total;
    private int contador = 0;
    private ProductoFacadeLocal productoEJB;
    
    

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public List<DetalleVenta> getLista() {
        return lista;
    }

    public void setLista(List<DetalleVenta> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        detalleVenta = new DetalleVenta();
        list = new LinkedList<>();
        

    }

    public void insertar() {
        try {
            detalleVentaEJB.create(detalleVenta);
        } catch (Exception e) {
        }
    }

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
    public void delete(Producto pr){
        try {
            list.remove(pr);
            msg = "Producto eliminado";
        } catch (Exception e) {
            this.msg = "Error";
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(msg, msj);
    }

    public void añadir(Producto p) {
        try {
            list.add(p);
            msg = "Se agrego producto al carrito";
            Total();
        } catch (Exception e) {
            this.msg = "Error";
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(msg, msj);
    }

    public void guardar() {
        int tamaño = lista.size();
        while (tamaño > 0) {
            this.detalleVentaEJB.create(lista.get(tamaño + 1));

            tamaño = tamaño + 1;
        }

    }

    public List<Producto> getList() {
        return list;
    }

    public void setList(List<Producto> list) {
        this.list = list;
    }

    public void Total() {
        total = 0;
        for (int a = 0; a < list.size(); a++) {
            total = total + list.get(a).getPrecioVenta();

        }
        contador++;
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


 
}
