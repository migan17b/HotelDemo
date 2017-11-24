package pe.com.socialdata.hotel.model.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import pe.com.socialdata.hotel.entity.Persona;

import pe.com.socialdata.hotel.model.PersonaModel;


@Component
public class PersonaConvert  extends ConvertBase {
	
	public Persona convertPersonaModel2Persona( PersonaModel personaModel){
		Persona persona = new Persona();
		
			BeanUtils.copyProperties(personaModel,persona,getNullPropertyNames(personaModel) );
	
		return persona;
	}
	public PersonaModel convertPersona2PersonaModel(Persona persona){
		PersonaModel personaModel = new PersonaModel();

		BeanUtils.copyProperties( persona,  personaModel,getNullPropertyNames(persona));
	
		return personaModel;
	}
}
