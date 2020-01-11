package Controller;

import EJB.ClienteFacadeLocal;
import EJB.RolFacadeLocal;
import EJB.UserFacadeLocal;
import Entity.Cliente;
import Entity.Rol;
import Entity.User;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "userController")
@RequestScoped
public class UserController {

    @EJB
    private UserFacadeLocal userFacade;
    private User user;
    private List<User> listaUser;
    private String mensaje;

    @EJB
    private RolFacadeLocal rolFacade;
    private Rol rol;
    private List<Rol> listaRol;

    @EJB
    private ClienteFacadeLocal clienteFacade;
    private Cliente cliente;
    private List<Cliente> listaCliente;

    public List<User> getListaUser() {
        try {
            this.listaUser = this.userFacade.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en ListaUser: " + e.getMessage());
        }
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getListaRol() {
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    @PostConstruct
    public void init() {
        this.user = new User();
        this.rol = new Rol();
        this.cliente = new Cliente();
        this.listaUser = userFacade.findAll();
        this.listaRol = rolFacade.findAll();
        this.listaCliente = clienteFacade.findAll();
    }

    public void consultarRol() {
        try {
            listaRol = rolFacade.findAll();
        } catch (Exception e) {
        }
    }

    public void consultarCliente() {
        try {
            listaCliente = clienteFacade.findAll();
        } catch (Exception e) {
        }
    }

    public void insertar() {
        try {
            this.user.setEstado(true);
            this.user.setCliente(cliente);
            this.user.setRol(rol);
            this.userFacade.create(user);
            this.mensaje = "Insertado con éxito";
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (Exception e) {
            this.mensaje = "Error: " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void editar() {
        try {
            this.user.setCliente(cliente);
            this.user.setRol(rol);
            this.userFacade.edit(user);
            this.mensaje = "Actualizado con éxito";
        } catch (Exception e) {
            this.mensaje = "Error: " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void cargarDatos(User u) {
        try {
            this.cliente.setIdCliente(this.user.getCliente().getIdCliente());
            this.rol.setIdRol(this.user.getRol().getIdRol());
            this.user = u;
        } catch (Exception e) {
        }
    }

    public void eliminar(User u) {
        try {
            this.user.setCliente(cliente);
            this.user.setRol(rol);
            this.userFacade.remove(u);
            this.mensaje = "Eliminado con éxito";
        } catch (Exception e) {
            this.mensaje = "Error: " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void limpiar() {
        this.user = new User();
        this.rol = new Rol();
        this.cliente = new Cliente();
        this.listaUser = userFacade.findAll();
        this.listaRol = rolFacade.findAll();
        this.listaCliente = clienteFacade.findAll();
    }

    public String login() {
        User us;
        String redireccion = "";
        try {
            us = this.userFacade.Sesion(this.user);
            if (us != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", us);
                if (us.getRol().getNombreRol().equalsIgnoreCase("cliente")) {
                    redireccion = "/prueba/producto?faces-redirect=true";
                } else if (us.getRol().getNombreRol().equalsIgnoreCase("admin")) {
                    redireccion = "/prueba/user?faces-redirect=true";
                }
                int idUser = us.getCliente().getIdCliente();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idUser", idUser);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Uusuario o clave incorrecta"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage((null), new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
        return redireccion;
    }
}
