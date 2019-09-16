package cr.ac.una.beans;

import cr.ac.una.entities.Mocion;
import cr.ac.una.entities.Persona;
import cr.ac.una.entities.PersonaMocion;
import cr.ac.una.services.PersonaMocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Component
@ManagedBean
public class PersonaMocionBean {

    @Autowired
    PersonaMocionService personaMocionService;
    private PersonaMocion personaMocion = new PersonaMocion();
    private Mocion mocion = new Mocion();
    private Persona persona = new Persona();
    private List<PersonaMocion> personaMociones;

    @PostConstruct
    public String init() {
        personaMociones = personaMocionService.getAllPersonaMocions();
        return "personaMocionList.xhtml";
    }

    public PersonaMocion getPersonaMocion() {
        return personaMocion;
    }

    public void setPersonaMocion(PersonaMocion personaMocion) {
        this.personaMocion = personaMocion;
    }

    public Mocion getMocion() {
        return mocion;
    }

    public void setMocion(Mocion mocion) {
        this.mocion = mocion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<PersonaMocion> getPersonaMociones() {
        return personaMociones;
    }

    public void setPersonaMociones(List<PersonaMocion> personaMociones) {
        this.personaMociones = personaMociones;
    }
    

    public void create() {
        try{
            personaMocionService.createPersonaMocion(personaMocion);
            addMessage("Aviso", "Registro insertado correctamente.");
            personaMociones = personaMocionService.getAllPersonaMocions();
        }catch (Exception e){
        } finally {
            personaMocion = new PersonaMocion();
        }
    }

    public void delete(){
        Integer id = new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("PersonaMocionId"));
        personaMocionService.deletePersonaMocion(id);
        addMessage("Aviso", "Registro eliminado correctamente.");
        personaMociones = personaMocionService.getAllPersonaMocions();
    }

    public void update(){
        try{
            personaMocionService.updatePersonaMocion(personaMocion);
            addMessage("Aviso", "Registro modificado correctamente.");
            personaMociones = personaMocionService.getAllPersonaMocions();
        }catch (Exception e){
        } finally {
            personaMocion = new PersonaMocion();
        }
    }

    public String carga(){//Aca se carga la persona y se redirecciona a la ventana update
        Integer id = new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("PersonaMocionId"));
        personaMocion=personaMocionService.findPersonaMocion(id);
        return "personaMocionUpdate.xhtml";
    }

    public String vaciar(){//Aca se carga la persona y se redirecciona a la ventana update
        mocion=null;
        return "personaMocionCreate.xhtml";
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
