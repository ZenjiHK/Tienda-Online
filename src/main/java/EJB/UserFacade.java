/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;
import Entity.User;
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
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }   
    
    
    @Override
    public User Sesion(User us){
        User user = null;
        String sql;
        try {
            sql = "SELECT u FROM User u WHERE u.nombreUsuario = ?1 and  u.clave = ?2";
            Query query = em.createQuery(sql);
            
            query.setParameter(1, us.getNombreUsuario());
            query.setParameter(2, us.getClave());
            
            List<User> lista = query.getResultList();
            if (!lista.isEmpty()) {
                user = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return user;
    }
    
}
