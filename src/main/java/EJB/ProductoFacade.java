package EJB;

/* By Michelle */

import Entity.Producto;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.eclipse.persistence.exceptions.QueryException;

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
    /* Metodo que tiene como proposito validar cuantos items existen sobre un producto en
    formulario catalogo de productos */
    /* Override por que posee metodos abstractos declarados en el Facade Local */
    @Override
    /* Es un metodo booleano porque lo que nos interesa es que valide si el inventario de productos esta
    en su limite - pedimos lo que es el id del producto como parametro */
    public boolean stockcero(int idProducto){
        /* valor inicial de la condicion: false */
        boolean valor = false;
        /* Lista para poder recorrer los registros */
        List<Producto> lista = new LinkedList<>();
        /* Ejecución de queries para corroborrar la condicion inicial */
        try {
            /*Query de tipo JPQL donde se necesita el id del producto y que el stock sea menor o igual a 5 */
             Query q = em.createQuery("SELECT p FROM Producto p WHERE p.idProducto = ?1 AND p.stock <= 5");
             /* Parametro que especifica que id de producto se esta consultando */
             q.setParameter(1, idProducto);
             /* Ejecutando query en un result list almacenado en una variable de lista */
             lista  = q.getResultList();
             /* Condicion que consulta si hay items del producto consultado
             si los hay, valor se vuelve verdadero */
             if (!lista.isEmpty()) {
                  valor =  true;  
                }
             /* regresamos un valor booleano */
             return valor;
             /* En dado caso a fallar: consultamos si hay un error en nuestra consulta a la base de datos */
        } catch (QueryException e) {
            /*Imprimimos en consola la causa del error para corregir si falla */
            System.out.println("**Imposible ejecutar**");
            System.out.println("Causa: "+e);
            return valor;
        }
    }
   
    @Override
    public String nombreProducto(Producto p){
        Producto producto = null;
        String sql;
        try {
            sql = "SELECT  p FROM Producto p  WHERE p.idProducto=?1";
            Query query = em.createQuery(sql);
           
            query.setParameter(1, p.getIdProducto());
                       
            List<Producto> lista = query.getResultList();
            if (!lista.isEmpty()) {
                producto = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return producto.getNombreProducto();
    }
   
      @Override
    public Double precioVenta(Producto po){
        Producto producto = null;
        String sql;
        try {
            sql = "SELECT  p FROM Producto p  WHERE p.idProducto=?1";
            Query query = em.createQuery(sql);
           
            query.setParameter(1, po.getIdProducto());
                       
            List<Producto> lista = query.getResultList();
            if (!lista.isEmpty()) {
                producto = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return producto.getPrecioVenta();
    }
   
   
    //Métodos para obtener las listas que irán en las diferentes opciones del catalogo
    @Override
     public List<Producto> filtroProductosCategoria(String tipoRopa, String cat) {
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.tipoRopa.nombreTipoRopa = ?1 and p.categoria.nombreCategoria = ?2");  
        query.setParameter(1, tipoRopa);
        query.setParameter(2, cat);
        List<Producto> resu= query.getResultList();
        for (Producto lista : resu) {            
        }
        return resu;
    }
     //Métodos para obtener las listas que irán en las diferentes opciones del catalogo
    @Override
     public List<Producto> filtroCategoria(String cat) {
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.categoria.nombreCategoria =:cat");    
        query.setParameter("cat", cat);
        List<Producto> resu= query.getResultList();
        for (Producto lista : resu) {            
            System.out.println("Tipo : " + lista.getNombreProducto());
        }
        return resu;
    }
     
}

