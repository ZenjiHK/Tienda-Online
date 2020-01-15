/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.DetalleTarjeta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maynor.menjivarusam
 */
@Local
public interface DetalleTarjetaFacadeLocal {

    void create(DetalleTarjeta detalleTarjeta);

    void edit(DetalleTarjeta detalleTarjeta);

    void remove(DetalleTarjeta detalleTarjeta);

    DetalleTarjeta find(Object id);

    List<DetalleTarjeta> findAll();

    List<DetalleTarjeta> findRange(int[] range);

    int count();
    
    List<DetalleTarjeta> findByC(int idCliente);   
    
    void ocultar(DetalleTarjeta d);
    
    public List<DetalleTarjeta> taregetaEspecifica(int id);
}