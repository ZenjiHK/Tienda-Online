
package Controller;

import EJB.UserFacadeLocal;
import Entity.User;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

@Named(value = "userController")
@RequestScoped
public class UserController {

    private String mensaje;
    
    @EJB
    private UserFacadeLocal userFacade;
    private User user;
    private List<User> listaUser;

    public List<User> getListaUser() {
        this.listaUser = this.userFacade.findAll();
        return listaUser;
    }

    public void setListaUser(List<User> listaUser) {
        this.listaUser = listaUser;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PostConstruct
    public void init(){
        user = new User();
    }
    
     
}
