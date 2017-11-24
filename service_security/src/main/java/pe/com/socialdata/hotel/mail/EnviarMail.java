package pe.com.socialdata.hotel.mail;


import java.io.File;

import java.util.List;
import java.util.Properties;
 

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnviarMail {
	

    private Properties props = new Properties();
 
    private String from,to,subject;
  
    MimeMultipart multipart = new MimeMultipart("related");
    
	public EnviarMail(){

        props = new Properties();	
      
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
 		props.put("mail.smtp.starttls.enable", "true");
 		props.put("mail.smtp.host", "smtp.gmail.com");
 		props.put("mail.smtp.port", "587");
 		props.put("mail.smtp.starttls.enable", "true");	
		
	}
	
	
	public void enviarMailHtml(String from, String to, String subject, String body, List<String> adjuntos) throws Exception{
	        // propiedades de conexion al servidor de correo
	        this.from = from;
	        this.subject = subject;
	        this.to = to;
	 
	 
	        String cabecera = "<HTML><BODY><img src='cid:cidcabecera' /> <br/> <br/>";
	        String pie = "<br/> <br/> <img src='cid:cidpie' /></BODY></HTML>";
	       // String boton = "<table><tr><td><form method='post' target='blank' action='http://"+ipServidor+":"+puertoServidor+"/"+nombreAplicacion+"/servlet/MiServlet?param="+parametros+"'> <input name='miBoton' type='submit' value='Boton' /></form>";
	        String formulario = String.format("%s%s%s%s", cabecera, body, "<br/> <br/>", pie);
	 
	        addContent(formulario);
	 
	        //añadir imagenes
	        addCID("cidcabecera", "d:/tempo/cabecera.png");
	        addCID("cidpie","d:/tempo/pie.png");
	 
	        // enviar adjuntos
	        if (adjuntos!=null){
	            for (String adjunto : adjuntos) {
	                addAttach(adjunto); //ruta donde se encuentra el fichero que queremos adjuntar.
	            }
	        }
	 
	        // enviar el correo MULTIPART
	        sendMultipart();
	    }
	
	
	
	public void addContent(String htmlText) throws Exception
    {
      
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(htmlText, "text/html");
      
        this.multipart.addBodyPart(messageBodyPart);
    }
	
	public void addCID(String cidname,String pathname) throws Exception
    {
        DataSource fds = new FileDataSource(pathname);
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID","<"+cidname+">");
        this.multipart.addBodyPart(messageBodyPart);
    }
	
	public void addAttach(String pathname) throws Exception
    {
        File file = new File(pathname);
        BodyPart messageBodyPart = new MimeBodyPart();
        DataSource ds = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(ds));
        messageBodyPart.setFileName(file.getName());
        messageBodyPart.setDisposition(Part.ATTACHMENT);
        this.multipart.addBodyPart(messageBodyPart);
    }
	
	
	public void sendMultipart() throws Exception
    {
		final String encoding = "UTF-8";
        Session mailSession = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("hostalmelanyapp@gmail.com","Pasatiempo22");
                    }
                });
        mailSession.setDebug(true);
        
        Transport transport = mailSession.getTransport();
        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(this.subject, encoding);
        message.setFrom(new InternetAddress(this.from));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(this.to));
       
        message.setContent(multipart);
        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();
        


		System.out.println("Send OK");
        
        
        
        
        
    }
	
	
	
	
}
