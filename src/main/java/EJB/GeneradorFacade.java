/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Generador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jose.cortezusam
 */
@Stateless
public class GeneradorFacade extends AbstractFacade<Generador> implements GeneradorFacadeLocal {

    @PersistenceContext(unitName = "generadorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GeneradorFacade() {
        super(Generador.class);
    }
    
}
