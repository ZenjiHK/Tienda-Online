/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Cliente;
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
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    @Override
    public Cliente ExisteCorreo(Cliente c){
        Cliente cliente = null;
        String sql;
        try {
            sql = "SELECT  c FROM Cliente c  WHERE c.correo=?1";
            Query query = em.createQuery(sql);
            
            query.setParameter(1, c.getCorreo());
                        
            List<Cliente> lista = query.getResultList();
            if (!lista.isEmpty()) {
                cliente = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return cliente;
    }   
    
}
