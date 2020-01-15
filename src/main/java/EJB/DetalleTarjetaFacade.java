/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.DetalleTarjeta;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.eclipse.persistence.exceptions.QueryException;

/**
 *
 * @author maynor.menjivarusam
 */
@Stateless
public class DetalleTarjetaFacade extends AbstractFacade<DetalleTarjeta> implements DetalleTarjetaFacadeLocal {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleTarjetaFacade() {
        super(DetalleTarjeta.class);
    }  

    @PreDestroy
    public void destruct()
    {
        getEntityManager().getEntityManagerFactory().close();
    }
    
    @Override
    public List<DetalleTarjeta> findByC(int idCliente) {
        return null;
    }
    
    @Override
    public void ocultar(DetalleTarjeta d){
        int rowsUpdated;
        try {
            Query q = em.createQuery("UPDATE DetalleTarjeta d SET d.estado = ?1 WHERE d.idDetalleTarjeta = ?2");
            q.setParameter(1, !d.isEstado());
            q.setParameter(2, d.getIdDetalleTarjeta());
            rowsUpdated = q.executeUpdate();
        } catch (QueryException e) {
            System.out.println("---Error: imposible ejecutar---");
            System.out.println("causa "+e);
        }
    }
     
      @Override
    public List<DetalleTarjeta> taregetaEspecifica(int id) {
        String sql = "";
        try {
            sql = "SELECT d FROM DetalleTarjeta d WHERE d.cliente.idCliente = ?1";
            Query query = em.createQuery(sql);
            query.setParameter(1, id);
            List<DetalleTarjeta> lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("nulo");
            return null;
        }

    }
    
}
    