package Controller;

import EJB.PaisFacadeLocal;
import Entity.Pais;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author maynor.menjivarusam
 */
@Named(value="paisController")
@SessionScoped
public class PaisController implements Serializable{
    @EJB
    private PaisFacadeLocal paisEJB;
    private Pais pais;
    private List<Pais> listaPais;
    private String msg;
//asdasdasdasdas
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Pais> getListaPais() {
        this.listaPais= paisEJB.findAll();
        return listaPais;
    }

    public void setListaPais(List<Pais> listaPais) {
        this.listaPais = listaPais;
    }
    
    @PostConstruct
    public void init(){
        this.pais=new Pais(1);
        this.listaPais=paisEJB.findAll();
        this.msg="";
    }
    
    public void limpiar(){
        this.pais=new Pais();
        this.listaPais=paisEJB.findAll();
        this.msg="";
    }

    public void crear(){
        try{
            paisEJB.create(pais);
            limpiar();
            msg="Exito";
        }catch(Exception e){
            this.msg="Error "+e.getMessage();
            e.printStackTrace();
        }
    }
    
    public void editar(){
        try{
            this.paisEJB.edit(pais);
            limpiar();
            msg="Exito";
        }catch(Exception e){
            this.msg="Error "+e.getMessage();
            e.printStackTrace();
        }
    }
    
    public void remover(Pais p){
        try{
            this.paisEJB.remove(p);
            limpiar();
            msg="Exito";
        }catch(Exception e){
            this.msg="Error "+e.getMessage();
            e.printStackTrace();
        }
    }
    
    public void cargarDatos(Pais p){
        try{
              limpiar();
            this.pais = p;
            msg="Exito";
        }catch(Exception e){
            this.msg="Error "+e.getMessage();
            e.printStackTrace();
        }
    }
}