/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.DetalleVenta;
import java.util.LinkedList;
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
public class DetalleVentaFacade extends AbstractFacade<DetalleVenta> implements DetalleVentaFacadeLocal {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleVentaFacade() {
        super(DetalleVenta.class);
    }

    @Override
    public List<DetalleVenta> factura(int iddventa) {
        String sql;
        List<DetalleVenta> lista = new LinkedList<>();
        try {
            sql = "Select v.idVenta,p.nombreProducto,p.precioVenta,dv.cantidad,d.descuento,((p.precio_venta*dv.cantidad))-(d.descuento*(p.precio_venta*dv.cantidad))sub_total from DetalleVenta dv join dv.Venta v join  v.Cliente c join dv.Producto p join dv.Descuento  where idDetalleVenta=?";
            Query query = em.createQuery("Select "
                    + "u "
                    + "from "
                    + "DetalleVenta u "
                    + "inner join Venta as v "
                    + "inner join Cliente as c "
                    + "inner join Producto as p "
                    + "inner join Descuento as d "
                    + "where "
                    + "idDetalleVenta= ?1 ");

            query.setParameter(1, iddventa);
            lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            return lista;
        }

    }

    @Override
    public List<DetalleVenta> detalleFactura(int venta) {
        String jpql = "Select dv from DetalleVenta dv where dv.venta.idVenta =:varVenta";
        Query query = em.createQuery(jpql);
        query.setParameter("varVenta", venta);
        List<DetalleVenta> resu= query.getResultList();
        for (DetalleVenta nombre : resu) {            
            System.out.println("Nombre: " + nombre.getProducto().getNombreProducto());
        }
        return resu;
    }
}
