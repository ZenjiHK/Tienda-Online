/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.DetalleVenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maynor.menjivarusam
 */
@Stateless
public class DetalleVentaFacade extends AbstractFacade<DetalleVenta> implements DetalleVentaFacadeLocal {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleVentaFacade() {
        super(DetalleVenta.class);
    }
    
    @Override
    public int cantidad(DetalleVenta dv){
        DetalleVenta detalleventa = null;
        String sql;
        try {
            sql = "SELECT  dv FROM DetalleVenta dv  WHERE dv.idDetalleVenta=?1";
            Query query = em.createQuery(sql);
            
            query.setParameter(1, dv.getIdDetalleVenta());
                        
            List<DetalleVenta> lista = query.getResultList();
            if (!lista.isEmpty()) {
                detalleventa = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return detalleventa.getCantidad();
    } 
    
}
