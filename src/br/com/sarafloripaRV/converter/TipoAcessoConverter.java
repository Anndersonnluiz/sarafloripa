package br.com.sarafloripaRV.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sarafloripaRV.model.Tipoacesso;

@FacesConverter(value = "TipoAcessoConverter")
public class TipoAcessoConverter implements Converter{
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		@SuppressWarnings("unchecked")
		List<Tipoacesso> listaAcesso = (List<Tipoacesso>) arg1.getAttributes().get("listaAcesso");
	    if (listaAcesso != null) {
	        for (Tipoacesso tipoacesso : listaAcesso) {
	            if (tipoacesso.getDescricao().equalsIgnoreCase(arg2)) {
	                return tipoacesso;
	            }
	        }
	    } else {
	    	Tipoacesso tipoacesso = new Tipoacesso();
	        return tipoacesso;
	    }
	    Tipoacesso tipoacesso = new Tipoacesso();
	    return tipoacesso;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2.toString().equalsIgnoreCase("0")) {
	        return "Selecione";
	    } else {
	    	Tipoacesso tipoacesso = (Tipoacesso) arg2;
	        return tipoacesso.getDescricao();
	    }
	}

}
