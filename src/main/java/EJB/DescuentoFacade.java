/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Descuento;
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
public class DescuentoFacade extends AbstractFacade<Descuento> implements DescuentoFacadeLocal {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DescuentoFacade() {
        super(Descuento.class);
    }
    
      @Override
    public double descuento(Descuento d){
          Descuento descuento = null;
        String sql;
        try {
            sql = "SELECT  d FROM Descuento d  WHERE d.idDescuento=?1";
            Query query = em.createQuery(sql);
            
            query.setParameter(1, d.getIdDescuento());
                        
            List<Descuento> lista = query.getResultList();
            if (!lista.isEmpty()) {
                descuento = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return descuento.getDescuento();
    } 
    
}
