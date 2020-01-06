
import EJB.ClienteFacadeLocal;
import Entity.Cliente;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;

@Named(value="reporte")
@SessionScoped
public class reporte implements Serializable{
      @EJB
      private ClienteFacadeLocal clienteEJB;
      private Cliente cliente;
      private List<Cliente> lista;
      private String msg;
      JasperPrint jPrint;
      
      @PostConstruct
      public void init(){
            this.cliente = new Cliente();
            this.lista = clienteEJB.findAll();
      }

      public Cliente getCliente() {
            return cliente;
      }

      public void setCliente(Cliente cliente) {
            this.cliente = cliente;
      }

      public List<Cliente> getLista() {
            return lista;
      }

      public void setLista(List<Cliente> lista) {
            this.lista = lista;
      }
      
      public void hola(Map<String,Object> params, String jasperPath, List<?> dataSource, String fileName){
            /*Map parameterMap = new HashMap();
            FacesContext ctx = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse)ctx.getExternalContext().getResponse();
            InputStream reportStream = ctx.getExternalContext().getResourceAsStream("C:\\Users\\alex.lemususam\\Desktop\\prueba2\\Tienda-Online\\report.jasper");
            try {
                  ServletOutputStream servletOutputStream = response.getOutputStream();
                  servletOutputStream.flush();
                  response.setContentType("application/pdf");
                  JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, parameterMap, new JREmptyDataSource());
                  servletOutputStream.flush();
                  servletOutputStream.close();
            } catch (IOException ex) {
                  System.out.println("Error " + ex.getMessage());
                  ex.printStackTrace();
            } catch (JRException ex) {
                  System.out.println("Error " + ex.getMessage());
                  ex.printStackTrace();
            }
            ctx.responseComplete();*/
            String realativeWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasperPath);
            File file = new File(relativeWebPath);
            JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(dataSource, false);
            jPrint = JasperFillManager.fillReport(file.getPath,params,source);
            HttpServletResponse response = (HttpServletResponse)ctx.getExternalContext().getResponse();
            
      }
}
