/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.FormaPago;
import java.util.List;
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
public class FormaPagoFacade extends AbstractFacade<FormaPago> implements FormaPagoFacadeLocal {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormaPagoFacade() {
        super(FormaPago.class);
    }
    
    @Override
    public boolean escogerPago(int formp){
        boolean formap = false;
        String sql;
        try {
            sql = "SELECT  fp FROM FormaPago fp WHERE fp.idFormaPago=?1 AND fp.NombreFormaPago = 'paypal'";
            Query query = em.createQuery(sql);           
            query.setParameter(1, formp);                       
            List<FormaPago> lista = query.getResultList();
            if (!lista.isEmpty()) {
                formap =  true;  
            }
            return formap;
        } catch (QueryException e) {
            System.out.println("**Imposible ejecutar**");
            System.out.println("Causa: "+e);
            return formap;
        }
        }
    
}
