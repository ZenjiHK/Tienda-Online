/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Venta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
