/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.DetalleTarjeta;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
}