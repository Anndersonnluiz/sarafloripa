package br.com.sarafloripaRV.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sarafloripaRV.model.Tipoevento;


@FacesConverter(value = "TipoEventoConverter")
public class TipoEventoConverter implements Converter{

	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		@SuppressWarnings("unchecked")
		List<Tipoevento> listaTipoEvento = (List<Tipoevento>) arg1.getAttributes().get("listaTipoEvento");
	    if (listaTipoEvento != null) {
	        for (Tipoevento tipoevento : listaTipoEvento) {
	            if (tipoevento.getDescricao().equalsIgnoreCase(arg2)) {
	                return tipoevento;
	            }
	        }
	    } else {
	    	Tipoevento tipoevento = new Tipoevento();
	        return tipoevento;
	    }
	    Tipoevento tipoevento = new Tipoevento();
	    return tipoevento;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2.toString().equalsIgnoreCase("0")) {
	        return "Selecione";
	    } else {
	    	Tipoevento tipoevento = (Tipoevento) arg2;
	        return tipoevento.getDescricao();
	    }
	}
}
