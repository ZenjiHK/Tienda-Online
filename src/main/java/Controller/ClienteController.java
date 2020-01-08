package Controller;

import EJB.ClienteFacadeLocal;
import Entity.Cliente;
import Entity.Pais;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author evelyn.andradeusam
 */
@ManagedBean
@SessionScoped
public class ClienteController implements Serializable {

      @EJB
      private ClienteFacadeLocal clienteEJB;
      private List<Cliente> listaCliente;
      private Cliente cliente;
      private Pais pais;
      String msj;
      JasperPrint jPrint;
      JasperReport jasperReport;

      public List<Cliente> getListaCliente() {
            this.listaCliente = this.clienteEJB.findAll();
            return listaCliente;
      }

      public void setListaCliente(List<Cliente> listaCliente) {
            this.listaCliente = listaCliente;
      }

      public Cliente getCliente() {
            return cliente;
      }

      public void setCliente(Cliente cliente) {
            this.cliente = cliente;
      }

      public Pais getPais() {
            return pais;
      }

      public void setPais(Pais pais) {
            this.pais = pais;
      }

      @PostConstruct
      public void init() {
            limpiar();
            JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(listaCliente);
            String path = "C:\\Users\\alex.lemususam\\Desktop\\Reporte\\reporte.jasper";
            try {
                  jPrint = JasperFillManager.fillReport(path, new HashMap(), source);
            } catch (JRException ex) {
                  System.out.println("Error "+ ex.getMessage());
                  ex.printStackTrace();
            }
      }
      
      public void PDF(){
            init();
            HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporte.pdf");
            ServletOutputStream servletOutputStream;
            try {
                  servletOutputStream = httpServletResponse.getOutputStream();
                  JasperExportManager.exportReportToPdfStream(jPrint, servletOutputStream);
            } catch (IOException ex) {
                  System.out.println("Error "+ ex.getMessage());
                  ex.printStackTrace();
            } catch (JRException ex) {
                  System.out.println("Error "+ ex.getMessage());
                  ex.printStackTrace();
            }
            
            FacesContext.getCurrentInstance().responseComplete();
      }

      public void insertar() {
            try {
                  this.cliente.setPais(pais);
                  this.clienteEJB.create(cliente);
                  limpiar();
                  this.msj = "Cliente Ingresado correctamente";
            } catch (Exception e) {
                  this.msj = "Error al ingresar Cliente " + e.getMessage();
                  e.printStackTrace();
            }
            FacesMessage mensaje = new FacesMessage(this.msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
      }

      public void cargarCliente(Cliente c) {
            this.pais.setIdPais(c.getPais().getIdPais());
            this.cliente = c;
      }

      public void editar() {
            try {
                  this.cliente.setPais(pais);
                  this.clienteEJB.edit(cliente);
                  this.cliente = new Cliente();
                  this.pais = new Pais();
                  this.msj = "Cliente Actualizado correctamente";
            } catch (Exception e) {
                  this.msj = "Error al Actualizar Cliente " + e.getMessage();
                  e.printStackTrace();
            }
            FacesMessage mensaje = new FacesMessage(this.msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
      }

      public void limpiar() {
            this.cliente = new Cliente();
            this.pais = new Pais();
            this.listaCliente = clienteEJB.findAll();
            this.msj = "";
            this.cliente.setPais(pais);
      }

      public void eliminar(Cliente cl) {
            try {
                  this.clienteEJB.remove(cl);
                  this.cliente = new Cliente();
                  this.msj = "Cliente Eliminado correctamente";
            } catch (Exception e) {
                  this.msj = "Error al Eliminar Cliente " + e.getMessage();
                  e.printStackTrace();
            }
            FacesMessage mensaje = new FacesMessage(this.msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
      }
}
