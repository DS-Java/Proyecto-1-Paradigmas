package cr.ac.una.beans;

import cr.ac.una.entities.Auditoria;
import cr.ac.una.services.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.util.List;

@Component
@ManagedBean
public class AuditoriaBean {
    @Autowired
    AuditoriaService auditoriaService;
    private Auditoria auditoria = new Auditoria();

    private List<Auditoria> auditorias;

    @PostConstruct
    public String init() {
        auditorias = auditoriaService.getAllAuditorias();
            return "auditoriaList.xhtml";
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public List<Auditoria> getAuditorias() {
        return auditorias;
    }

    public void setAuditorias(List<Auditoria> auditorias) {
        this.auditorias = auditorias;
    }

    public void delete(){
        Integer id = new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("AuditoriaId"));
        auditoriaService.deleteAuditoria(id);
        /*Auditoria a = new Auditoria();
        a.setTransaccion("Eliminado");
        a.setTabla("Auditoria");
        auditoriaService.createAuditoria(a);*/
        auditorias = auditoriaService.getAllAuditorias();

    }
}
