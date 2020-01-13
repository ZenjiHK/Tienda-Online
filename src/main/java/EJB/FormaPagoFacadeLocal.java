/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.FormaPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maynor.menjivarusam
 */
@Local
public interface FormaPagoFacadeLocal {

    void create(FormaPago formaPago);

    void edit(FormaPago formaPago);

    void remove(FormaPago formaPago);

    FormaPago find(Object id);

    List<FormaPago> findAll();

    List<FormaPago> findRange(int[] range);

    int count();
    
    boolean escogerPago(int formp);
    
}
