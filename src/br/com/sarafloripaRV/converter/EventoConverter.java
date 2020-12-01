package br.com.sarafloripaRV.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sarafloripaRV.model.Evento;


@FacesConverter(value = "EventoConverter")
public class EventoConverter implements Converter{

	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		@SuppressWarnings("unchecked")
		List<Evento> listaEvento = (List<Evento>) arg1.getAttributes().get("listaEvento");
	    if (listaEvento != null) {
	        for (Evento evento : listaEvento) {
	            if (evento.getNome().equalsIgnoreCase(arg2)) {
	                return evento;
	            }
	        }
	    } else {
	    	Evento evento = new Evento();
	        return evento;
	    }
	    Evento evento = new Evento();
	    return evento;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2.toString().equalsIgnoreCase("0")) {
	        return "Selecione";
	    } else {
	    	Evento evento = (Evento) arg2;
	        return evento.getDescricao();
	    }
	}
}
