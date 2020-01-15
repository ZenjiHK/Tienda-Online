/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maynor.menjivarusam
 */
@Local
public interface ClienteFacadeLocal {

    void create(Cliente cliente);

    void edit(Cliente cliente);

    void remove(Cliente cliente);

    Cliente find(Object id);

    List<Cliente> findAll();

    List<Cliente> findRange(int[] range);

    int count();

    public int ExisteCorreo(Cliente cl);

    public String nombreCliente(Cliente c);

    public List<Cliente> bucarCliente(int id);
    
}
