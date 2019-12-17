/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.DetalleTarjeta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
