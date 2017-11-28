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
import pe.com.socialdata.hotel.model.CategoriaModel;
import pe.com.socialdata.hotel.model.PersonaModel;

import pe.com.socialdata.hotel.service.MensajeriaService;
import pe.com.socialdata.hotel.util.ToolFecha;

@Service
public class MensajeriaServiceImpl implements MensajeriaService {
	private static Logger log = Logger.getLogger(MensajeriaServiceImpl.class);
	

	
	@Override
	public  void sendCategorias(String correo, String path) {
		MailBean bean = new MailBean();
		bean.setAsunto("LISTA DE CATEGORIAS");
		bean.setEmailDestino(correo);
		//bean.setNomDestino(personaModel.getFullName());
		bean.setEmailOrigen("hostalmelanyapp@gmail.com");
		bean.setNomOrigen("Hotel Melany");
		bean.setFechaHora(ToolFecha.formatDateToDateDDMMYYYYHHMM_AMPM (new Date()));
		
		//generar Token
		
		
		String ls_body= MensajeriaUtil.sendEmailCategoria(bean);
		
		EnviarMail mail = new EnviarMail();
		//String file ="/tempo/pruebas.pdf";
		List<String> adjuntos =new ArrayList<String>();
		adjuntos.add(path);
	try {
		mail.enviarMailHtml(bean.getEmailOrigen(), bean.getEmailDestino(),bean.getAsunto(), ls_body, adjuntos);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
