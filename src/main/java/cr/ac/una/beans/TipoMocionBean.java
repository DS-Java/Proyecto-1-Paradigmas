package cr.ac.una.beans;

import cr.ac.una.entities.TipoMocion;
import cr.ac.una.services.TipoMocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.util.List;

@Component
@ManagedBean
public class TipoMocionBean {
    @Autowired
    TipoMocionService tipoMocionService;

    private TipoMocion tipoMocion = new TipoMocion();
    private List<TipoMocion> tipoMocions;

    @PostConstruct
    public void init() {
        tipoMocions = tipoMocionService.getAllTipoMocion();
    }

    public TipoMocion getTipoMocion() {
        return tipoMocion;
    }

    public void setTipoMocion(TipoMocion tipoMocion) {
        this.tipoMocion = tipoMocion;
    }

    public List<TipoMocion> getTipoMocions() { return tipoMocions; }

    public void setTipoMocions(List<TipoMocion> tipoMocions) {
        this.tipoMocions = tipoMocions;
    }

    public TipoMocion obtieneTipoMocion(Integer id)
    {
        if(id == null){
            throw new IllegalArgumentException("no se proveyo el id");
        }
        for (TipoMocion tm : tipoMocions){
            if(id.equals(tm.getID_TIPO_MOCION())){
                return tm;
            }
        }
        return null;
    }

    public void create() {
        try {
            tipoMocionService.createTipoMocion(tipoMocion);
            tipoMocions = tipoMocionService.getAllTipoMocion();
        }catch (Exception e){
        }finally {
            tipoMocion = new TipoMocion();
        }

    }

    public void delete(){
        Integer id = new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("TipoMocionId"));
        tipoMocionService.deleteTipoMocion(id);
        tipoMocions = tipoMocionService.getAllTipoMocion();
    }

    public void update(){
        try{
            tipoMocionService.updateTipoMocion(tipoMocion);
            tipoMocions = tipoMocionService.getAllTipoMocion();
        }catch (Exception e){
        }finally {
            tipoMocion = new TipoMocion();
        }
    }
    //@RequestMapping(value = "/personaUpdate.xhtml", method = RequestMethod.GET)
    public String carga(){//Aca se carga la persona y se redirecciona a la ventana update
        Integer id = new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("TipoMocionId"));
        tipoMocion = tipoMocionService.findTipoMocion(id);
        return "tipoMocionUpdate.xhtml";
    }

    public String vaciar(){//Aca se carga la persona y se redirecciona a la ventana update
        tipoMocion=null;
        return "personaCreate.xhtml";
    }
}
