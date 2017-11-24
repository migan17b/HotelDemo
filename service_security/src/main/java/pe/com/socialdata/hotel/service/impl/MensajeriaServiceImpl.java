package pe.com.socialdata.hotel.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.mail.EnviarMail;
import pe.com.socialdata.hotel.mail.MailBean;
import pe.com.socialdata.hotel.mail.MensajeriaUtil;
import pe.com.socialdata.hotel.model.PersonaModel;
import pe.com.socialdata.hotel.security.TokenMessageService;
import pe.com.socialdata.hotel.service.MensajeriaService;
import pe.com.socialdata.hotel.util.ToolFecha;

@Service
public class MensajeriaServiceImpl implements MensajeriaService {
	private static Logger log = Logger.getLogger(MensajeriaServiceImpl.class);
	
	@Autowired
	TokenMessageService tokenMessageService;
	
	@Override
	public void sendCreateUser(PersonaModel personaModel, String url) {
		MailBean bean = new MailBean();
		bean.setAsunto("CREACIÓN CUENTA DE USUARIO");
		bean.setEmailDestino(personaModel.getCorreo());
		bean.setNomDestino(personaModel.getFullName());
		bean.setEmailOrigen("hostalmelanyapp@gmail.com");
		bean.setNomOrigen("Hotel Melany");
		bean.setFechaHora(ToolFecha.formatDateToDateDDMMYYYYHHMM_AMPM (new Date()));
		log.debug("URL " + url);
		//generar Token
		String token=tokenMessageService.addAuthentication(personaModel.getUsername());
		bean.setUrl(url+token);
		
		String ls_body= MensajeriaUtil.sendEmailUser(bean);
		
		EnviarMail mail = new EnviarMail();
		String file ="/tempo/pruebas.pdf";
		List<String> adjuntos =new ArrayList<String>();
		adjuntos.add(file);
	try {
		mail.enviarMailHtml(bean.getEmailOrigen(), bean.getEmailDestino(),bean.getAsunto(), ls_body, adjuntos);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
