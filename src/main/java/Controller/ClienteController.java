package Controller;

import EJB.ClienteFacadeLocal;
import Entity.Cliente;
import Entity.Pais;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "clienteController")
@SessionScoped
public class ClienteController implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteEJB;
    private List<Cliente> listaCliente, lista2;
    private Cliente cliente;
    private Pais pais;
    String msj;

    public List<Cliente> getLista2() {
        try {
            this.lista2 = clienteEJB.findAll();
        } catch (Exception e) {
            return null;
        }
        return lista2;
    }

    public void setLista2(List<Cliente> lista2) {
        this.lista2 = lista2;
    }

    public List<Cliente> getListaCliente() {
        int idUs = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idUser");
        this.listaCliente = clienteEJB.bucarCliente(idUs);
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @PostConstruct
    public void init() {
        this.cliente = new Cliente();
        this.pais = new Pais();
        this.listaCliente = clienteEJB.findAll();
        this.msj = "";
        this.cliente.setPais(pais);
    }
    
    public void insertarCliente() {
        try {
            this.cliente.setPais(pais);
            this.clienteEJB.create(cliente);
            limpiar();
            this.msj = "Cliente Ingresado correctamente";
            FacesContext.getCurrentInstance().getExternalContext().redirect("insertUsuario.xhtml");
        } catch (Exception e) {
            this.msj = "Error al ingresar Cliente " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void insertar() {
        try {
            this.cliente.setPais(pais);
            this.clienteEJB.create(cliente);
            limpiar();
            this.msj = "Cliente Ingresado correctamente";            
        } catch (Exception e) {
            this.msj = "Error al ingresar Cliente " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarCliente(Cliente c) {
        this.pais.setIdPais(c.getPais().getIdPais());
        this.cliente = c;
    }

    public void editar() {
        try {
            this.cliente.setPais(pais);
            this.clienteEJB.edit(cliente);
            this.cliente = new Cliente();
            this.pais = new Pais();
            this.msj = "Cliente Actualizado correctamente";
        } catch (Exception e) {
            this.msj = "Error al Actualizar Cliente " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpiar() {
        this.cliente = new Cliente();
        this.pais = new Pais();
        this.listaCliente = clienteEJB.findAll();
        this.msj = "";
        this.cliente.setPais(pais);
    }

    public void eliminar(Cliente cl) {
        try {
            this.clienteEJB.remove(cl);
            this.cliente = new Cliente();
            this.msj = "Cliente Eliminado correctamente";
        } catch (Exception e) {
            this.msj = "Error al Eliminar Cliente " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
}
