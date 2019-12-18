/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.ClienteFacadeLocal;
import Entity.Cliente;
import Entity.Pais;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author evelyn.andradeusam
 */
@ManagedBean
@SessionScoped
public class ClienteController implements Serializable{
     @EJB
    
    private ClienteFacadeLocal ClienteEJB;       
    private List<Cliente> listaCliente;
    private Cliente cliente; 
    private Pais pais;

    public List<Cliente> getListaCliente() {
        this.listaCliente= this.ClienteEJB.findAll();
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
    public void init(){
    this.cliente=new Cliente();
    this.pais=new Pais();
    }
    
    public void insertar(){
        try {
            ClienteEJB.create(cliente);
        } catch (Exception e) {
        }
    }
    
    public void cargarDatos(Cliente c){
        try {
            this.cliente=c;
        } catch (Exception e) {
        }
    }
    
    public void editar(){
        try {
            ClienteEJB.edit(cliente);
            this.listaCliente=ClienteEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void eliminar(Cliente c){
        this.cliente=c;
        try {
            ClienteEJB.remove(cliente);
            listaCliente=ClienteEJB.findAll();
        } catch (Exception e) {
        }
}
    
}
