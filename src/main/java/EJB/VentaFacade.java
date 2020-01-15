/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Venta;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author maynor.menjivarusam
 */
@Stateless
public class VentaFacade extends AbstractFacade<Venta> implements VentaFacadeLocal {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaFacade() {
        super(Venta.class);
    }
    
     @Override
    public int idVenta(Venta v){
        Venta venta = null;
        String sql;
        try {
            sql = "SELECT  v FROM Venta v  WHERE v.idVenta=?1";
            Query query = em.createQuery(sql);
            
            query.setParameter(1, v.getIdVenta());
                        
            List<Venta> lista = query.getResultList();
            if (!lista.isEmpty()) {
                venta = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return venta.getIdVenta();
    } 
    @Override
    public int ultimaVenta(int idCliente) { 
        Venta venta=new Venta();
        try {
            //sql = "SELECT  c FROM Cliente c  WHERE c.correo=?1";
            Query query = em.createQuery("SELECT c FROM Venta c  WHERE c.cliente.idCliente=?1");
            System.out.println("Clienteeeeeeeeeeee!!!!!!!!!!"+idCliente);
            query.setParameter(1, idCliente);
            List<Venta> lista = new LinkedList<>();
                    lista = query.getResultList();
                     System.out.println("VENTAA!!!!!!!!!!!!"+venta.getIdVenta());
            if (!lista.isEmpty()) {
                venta = lista.get(0);               
            }
            return venta.getIdVenta();
        } catch (Exception e) {
            System.out.println("****************");
            System.out.println(e);
        }
        return venta.getIdVenta();
    }
    
}
