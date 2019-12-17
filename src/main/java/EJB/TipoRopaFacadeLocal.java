/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.TipoRopa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maynor.menjivarusam
 */
@Local
public interface TipoRopaFacadeLocal {

    void create(TipoRopa tipoRopa);

    void edit(TipoRopa tipoRopa);

    void remove(TipoRopa tipoRopa);

    TipoRopa find(Object id);

    List<TipoRopa> findAll();

    List<TipoRopa> findRange(int[] range);

    int count();
    
}
