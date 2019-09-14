package cr.ac.una.beans;

import cr.ac.una.entities.Persona;
import cr.ac.una.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;
/*
import cr.ac.una.entities.Persona;
import cr.ac.una.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Optional;
*/
@Component
@ManagedBean
public class PersonaBean {
    @Autowired
    PersonaService personaService;
    private Persona persona = new Persona();

    private List<Persona> personas;

    @PostConstruct
    public String init() {
        personas = personaService.getAllPersonas();
        return "personaList.xhtml";

    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void create() {
        try{
            personaService.createPersona(persona);
            addMessage("Aviso", "Registro insertado correctamente.");
            personas = personaService.getAllPersonas();
        }catch (Exception e){
        } finally {
            persona = new Persona();
        }
    }

    public void delete(){
        Integer id = new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("PersonaId"));
        personaService.deletePersona(id);
        addMessage("Aviso", "Registro eliminado correctamente.");
        personas = personaService.getAllPersonas();
    }

    public void update(){
        try{
            personaService.updatePersona(persona);
            addMessage("Aviso", "Registro modificado correctamente.");
            personas = personaService.getAllPersonas();
        }catch (Exception e){
        } finally {
            persona = new Persona();
        }
    }
    //@RequestMapping(value = "/personaUpdate.xhtml", method = RequestMethod.GET)
    public String carga(){//Aca se carga la persona y se redirecciona a la ventana update
        Integer id = new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("PersonaId"));
        persona=personaService.findPersona(id);
        return "personaUpdate.xhtml";
    }

    public String vaciar(){//Aca se carga la persona y se redirecciona a la ventana update
        persona=null;
        return "personaCreate.xhtml";
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
