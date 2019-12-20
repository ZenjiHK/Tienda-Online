package Controller;

import EJB.DetalleTarjetaFacadeLocal;
import Entity.Cliente;
import Entity.DetalleTarjeta;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "detalleTarjetaController")
@RequestScoped
public class DetalleTarjetaController {
    @EJB
    private DetalleTarjetaFacadeLocal detalleTarjetaEJB;
    private DetalleTarjeta detalleTarjeta;
    private List<DetalleTarjeta> lista_detalleTarjeta;
    private String msg;
    
    @PostConstruct
    public void init(){
        limpiar();
    }
    
    public void limpiar(){
        detalleTarjeta = new DetalleTarjeta();
        lista_detalleTarjeta=detalleTarjetaEJB.findAll();
        this.msg="";
    }
    /*
    public void consultarByC(){
        try{
            lista_detalleTarjeta=detalleTarjetaEJB.findByC(cliente.getIdCliente());
            msg="Exito";
            limpiar();
        }catch(Exception e){
            msg = "Error " + e.getMessage();
            e.printStackTrace();
        }
    }
*/
    public DetalleTarjeta getDetalleTarjeta() {
        return detalleTarjeta;
    }

    public void setDetalleTarjeta(DetalleTarjeta detalleTarjeta) {
        this.detalleTarjeta = detalleTarjeta;
    }

    public List<DetalleTarjeta> getLista_detalleTarjeta() {
        return lista_detalleTarjeta;
    }

    public void setLista_detalleTarjeta(List<DetalleTarjeta> lista_detalleTarjeta) {
        this.lista_detalleTarjeta = lista_detalleTarjeta;
    }
}