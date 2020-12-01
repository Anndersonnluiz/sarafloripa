package br.com.sarafloripaRV.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sarafloripaRV.model.Equipe;


@FacesConverter(value = "EquipeConverter")
public class EquipeConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		@SuppressWarnings("unchecked")
		List<Equipe> listaEquipe = (List<Equipe>) arg1.getAttributes().get("listaEquipe");
	    if (listaEquipe != null) {
	        for (Equipe equipe : listaEquipe) {
	            if (equipe.getNome().equalsIgnoreCase(arg2)) {
	                return equipe;
	            }
	        }
	    } else {
	    	Equipe equipe = new Equipe();
	        return equipe;
	    }
	    Equipe equipe = new Equipe();
	    return equipe;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2.toString().equalsIgnoreCase("0")) {
	        return "Selecione";
	    } else {
	    	Equipe equipe = (Equipe) arg2;
	        return equipe.getNome();
	    }
	}
}
