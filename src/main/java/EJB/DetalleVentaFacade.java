/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.DetalleVenta;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author maynor.menjivarusam
 * @author evelyn.andradeusam
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
    public List<DetalleVenta> detalleFactura(int venta) {

        String jpql = "Select dv from DetalleVenta dv where dv.venta.idVenta =:varVenta";
        Query query = em.createQuery(jpql);
        query.setParameter("varVenta", venta);

        return query.getResultList();

    }

  

}
