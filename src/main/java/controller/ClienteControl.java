/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import EJB.ClienteFacadeLocal;
import Entity.Cliente;
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
public class ClienteControl implements Serializable{
    @EJB
    
    private ClienteFacadeLocal ClienteEJB;
    private Cliente cliente;
    private List<Cliente> lista;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getLista() {
        this.lista=this.ClienteEJB.findAll();
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init(){
    cliente =new Cliente();
    }
    
    public void insertar(){
        try {
            ClienteEJB.create(cliente);
        } catch (Exception e) {
        }
    }
    
    public void leerById(Cliente c){
        try {
            this.cliente=c;
        } catch (Exception e) {
        }
    }
    
    public void modificar(){
        try {
            ClienteEJB.edit(cliente);
            this.lista=ClienteEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void eliminar(Cliente c){
        this.cliente=c;
        try {
            ClienteEJB.remove(cliente);
            lista=ClienteEJB.findAll();
        } catch (Exception e) {
        }
}
    
}
