
package EJB;

import Entity.Generador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jose.cortezusam
 */
@Local
public interface GeneradorFacadeLocal {

    void create(Generador generador);

    void edit(Generador generador);

    void remove(Generador generador);

    Generador find(Object id);

    List<Generador> findAll();

    List<Generador> findRange(int[] range);

    int count();
    
}
