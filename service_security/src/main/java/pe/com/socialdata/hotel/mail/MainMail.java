package pe.com.socialdata.hotel.mail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.sql.DATE;
import pe.com.socialdata.hotel.util.ToolFecha;

public class MainMail {

	public static void main(String[] args) {
		
		MailBean bean = new MailBean();
		bean.setAsunto("CREACIÓN CUENTA DE USUARIO");
		bean.setEmailDestino("edumar111@gmail.com");
		bean.setNomDestino("Eduardo Marchena");
		bean.setEmailOrigen("hostalmelanyapp@gmail.com");
		bean.setNomOrigen("Hotel Melany");
		bean.setFechaHora(ToolFecha.formatDateToDateDDMMYYYYHHMM_AMPM (new Date()));
		bean.setUrl("https://www.google.com.pe/");
		
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
