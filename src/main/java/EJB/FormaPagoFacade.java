/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.FormaPago;
import java.util.LinkedList;
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
    public FormaPago escogerPago(FormaPago f){
        FormaPago formapago = new FormaPago();
        String sql;
        try {
            sql = "SELECT f FROM FormaPago f WHERE f.idFormaPago=?1";
            Query query = em.createQuery(sql);           
            query.setParameter(1, f.getIdFormaPago()); 
            System.out.println(f.getIdFormaPago());
            List<FormaPago> lista = new LinkedList<>();
                   lista = query.getResultList();
            System.out.println(lista);
            if (!lista.isEmpty()) {
                System.out.println(lista);
                formapago = lista.get(0);
            }
        } catch (QueryException e) {
            System.out.println("**Imposible ejecutar**");
            System.out.println("Causa: "+e);
        }
        return formapago;
        }
    
}
