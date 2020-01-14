/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Cliente;
import Entity.User;
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
    public void ocultar(User u){
        int rowsUpdated;
        try {
            Query q = em.createQuery("UPDATE User u SET u.estado = ?1 WHERE u.cliente.idCliente = ?2");
            q.setParameter(1, !u.isEstado());
            q.setParameter(2, u.getCliente().getIdCliente());
            rowsUpdated = q.executeUpdate();
        } catch (QueryException e) {
            System.out.println("---Error: imposible ejecutar---");
            System.out.println("causa "+e);
        }
    }

    @Override
    public User Sesion(User us) {
        User user = null;
        String sql;
        try {
            sql = "select u from User u where u.nombreUsuario=?1 and u.clave=?2";
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

    @Override
    public void ActualizarUsuario(User u) {
        String sql;
        try {
            sql = "UPDATE  User u SET u.clave= ?1 WHERE u.cliente.idCliente= ?2";
            Query query = em.createQuery(sql);
            query.setParameter(1, u.getClave());
            query.setParameter(2, u.getCliente().getIdCliente());
            int rowsUpdated = query.executeUpdate();
        } catch (QueryException e) {

        }
    }
}
