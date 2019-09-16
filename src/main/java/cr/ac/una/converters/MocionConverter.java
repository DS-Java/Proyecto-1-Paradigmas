package cr.ac.una.converters;

import cr.ac.una.beans.MocionBean;
import cr.ac.una.entities.Mocion;
import cr.ac.una.services.MocionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "mocionConverter")
public class MocionConverter implements Converter {

    @Autowired
    MocionService mocionService;

    @Override
    public Mocion getAsObject(FacesContext facesContext, UIComponent uiComponent, String idMocion) {
        ValueExpression vex =
                FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
                        .createValueExpression(FacesContext.getCurrentInstance().getELContext(),
                                "#{mocionBean}", MocionBean.class);

        MocionBean mociones = (MocionBean) vex.getValue(FacesContext.getCurrentInstance().getELContext());
        System.out.println(mociones.obtieneMocion(Integer.valueOf(idMocion)).toString());
        return mociones.obtieneMocion(Integer.valueOf(idMocion));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object mocion) {
        //((TipoMocion)tipoMocion).getID_TIPO_MOCION();
        String idM = String.valueOf(((Mocion)mocion).getID_MOCION());
        return idM;//.toString();
    }
}
