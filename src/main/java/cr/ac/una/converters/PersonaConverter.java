package cr.ac.una.converters;

import cr.ac.una.beans.PersonaBean;
import cr.ac.una.entities.Persona;
import cr.ac.una.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "personaConverter")
public class PersonaConverter implements Converter {

    @Autowired
    PersonaService personaService;

    @Override
    public Persona getAsObject(FacesContext facesContext, UIComponent uiComponent, String idPersona) {
        ValueExpression vex =
                FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
                        .createValueExpression(FacesContext.getCurrentInstance().getELContext(),
                                "#{personaBean}", PersonaBean.class);

        PersonaBean personas = (PersonaBean) vex.getValue(FacesContext.getCurrentInstance().getELContext());
        System.out.println(personas.obtienePersona(Integer.valueOf(idPersona)).toString());
        return personas.obtienePersona(Integer.valueOf(idPersona));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object persona) {
        //((TipoMocion)tipoMocion).getID_TIPO_MOCION();
        String idP = String.valueOf(((Persona)persona).getID_PERSONA());
        return idP;//.toString();
    }
}
