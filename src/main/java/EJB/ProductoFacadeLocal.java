package EJB;

import Entity.Producto;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProductoFacadeLocal {

    void create(Producto producto);

    void edit(Producto producto);

    void remove(Producto producto);

    Producto find(Object id);

    List<Producto> findAll();

    List<Producto> findRange(int[] range);

    int count();

    List<Producto> filtroProductosCategoria(String tipoRopa, String cat);

    boolean stockcero(int idProducto);

    public String nombreProducto(Producto p);

    public Double precioVenta(Producto po);

     List<Producto> filtroCategoria(String cat);
}
