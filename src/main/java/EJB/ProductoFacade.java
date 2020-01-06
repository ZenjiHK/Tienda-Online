package EJB;

import Entity.Producto;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeLocal {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }

    @Override
    public List<Producto> consultaProductos() {

        List<Producto> lista = new LinkedList<>();
        try {
            String sql = "Select p from producto p order by p.id_producto Limit 5";
            Query query = em.createQuery(sql);            
        } catch (Exception e) {
        }
        return lista;
    }
    
    
}
