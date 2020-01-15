/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Cliente;
import Entity.DetalleVenta;
import Entity.Venta;
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

   @Override
    public String obtenerCorreo(Cliente c) {
        Cliente cliente = null;       
        try {
            //sql = "SELECT  c FROM Cliente c  WHERE c.correo=?1";
            Query query = em.createQuery("SELECT c FROM Cliente c  WHERE c.idCliente=?1");
            query.setParameter(1, c.getIdCliente());

            List<Cliente> lista = query.getResultList();
            if (!lista.isEmpty()) {
                cliente = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return cliente.getCorreo();    
    }
    
    
    
}
