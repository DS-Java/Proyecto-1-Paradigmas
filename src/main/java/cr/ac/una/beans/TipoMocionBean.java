package cr.ac.una.beans;

import cr.ac.una.entities.Mocion;
import cr.ac.una.entities.TipoMocion;
import cr.ac.una.services.MocionService;
import cr.ac.una.services.TipoMocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Component
@ManagedBean
public class TipoMocionBean {
    @Autowired
    TipoMocionService tipoMocionService;

    @Autowired
    MocionService mocionService;

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
            throw new IllegalArgumentException("no se provee el id");
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
            addMessage("Aviso", "Registro insertado correctamente.");
            tipoMocions = tipoMocionService.getAllTipoMocion();
        }catch (Exception e){
        }finally {
            tipoMocion = new TipoMocion();
        }
    }

    public void delete(){
        /*List<Mocion> mociones = mocionService.getAllMociones();//Se carga esta lista con todas la mociones que hay en la base
        Integer id = new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("TipoMocionId"));
        //Se consulta el id del tipo de mocion a eliminar
        for (Mocion m : mociones){//For que recorre toda la lista
            if(id==(m.getTipoMocion().getID_TIPO_MOCION())){//If que valida si se encuentra el id tipo mocion en alguna mocion de la lista de mociones
                addMessage("Aviso", "No es posible eliminar el registro, pues existen mociones de este tipo.");
            }else{
                //Integer id = new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("TipoMocionId"));
                tipoMocionService.deleteTipoMocion(id);
                addMessage("Aviso", "Registro eliminado correctamente.");
                tipoMocions = tipoMocionService.getAllTipoMocion();
            }
        }*/
        Integer id = new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("TipoMocionId"));
        tipoMocionService.deleteTipoMocion(id);
        addMessage("Aviso", "Registro eliminado correctamente.");
        tipoMocions = tipoMocionService.getAllTipoMocion();
    }

    public void update(){
        try{
            tipoMocionService.updateTipoMocion(tipoMocion);
            addMessage("Aviso", "Registro modificado correctamente.");
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

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
