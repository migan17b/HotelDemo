package pe.com.socialdata.hotel.service;

import pe.com.socialdata.hotel.model.PersonaModel;

public interface MensajeriaService {
	public abstract void sendCreateUser(PersonaModel  personaModel,String url);
}
