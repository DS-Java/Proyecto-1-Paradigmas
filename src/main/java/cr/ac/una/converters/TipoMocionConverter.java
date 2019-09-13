package cr.ac.una.converters;

import cr.ac.una.beans.TipoMocionBean;
import cr.ac.una.entities.TipoMocion;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tipoMocionConverter")
public class TipoMocionConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String idTipoMocion) {
        ValueExpression vex =
                FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
                        .createValueExpression(FacesContext.getCurrentInstance().getELContext(),
                                "#{tipoMocionBean}", TipoMocionBean.class);

        TipoMocionBean tipoMociones = (TipoMocionBean) vex.getValue(FacesContext.getCurrentInstance().getELContext());
        return tipoMociones.obtieneTipoMocion(Integer.valueOf(idTipoMocion));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object tipoMocion) {
        return ((TipoMocion)tipoMocion).toString();
    }
}
