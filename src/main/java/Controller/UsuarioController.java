
package Controller;

import EJB.UsuarioFacadeLocal;
import Entity.Usuario;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author jose.cortezusam
 */
@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private Usuario usuario;
    private List<Usuario> lista;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLista() {
        this.lista = this.usuarioEJB.findAll();
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    public void insertar(){
        try {
           usuarioEJB.create(usuario);
        } catch (Exception e) {
        }
    }
    
    public void listar(){
        try {
            lista = usuarioEJB.findAll();
        } catch (Exception e) {
        }
    }
}
