/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Descuento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maynor.menjivarusam
 */
@Local
public interface DescuentoFacadeLocal {

    void create(Descuento descuento);

    void edit(Descuento descuento);

    void remove(Descuento descuento);

    Descuento find(Object id);

    List<Descuento> findAll();

    List<Descuento> findRange(int[] range);

    int count();
    public double descuento(Descuento d);
    
}
