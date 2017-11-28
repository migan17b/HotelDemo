package pe.com.socialdata.hotel.mail;

public class MensajeriaUtil {
	
	
	public static String sendEmailCategoria(MailBean mail){
		
		
		StringBuilder str = new StringBuilder();
		str.append("<div style='margin-left: 20px;margin-right: 20px;'>");
		str.append("<table  border=0 cellspacing=0 cellpadding=0 style='width:100%;'>");
		str.append("<tr>");
		str.append("<td colspan='3' align='center'>");
		str.append("<p class=MsoNormalTitulo>");
		str.append("<strong><span >CATEGORIAS HOTEL MELANY </span></strong>");		
		str.append("</p>");		
		str.append("</td>");
		str.append("</tr>");
		str.append("<tr height='20'>");
		str.append("<td colspan='3'>");
		str.append("</td>");
		str.append("</tr>");
		str.append("<tr height='20'>");
		str.append("<td colspan='3'>");
		str.append("<p class=MsoNormalCentro >");
		str.append("<b>Se&ntilde;or (a) &nbsp;:&nbsp; " +" </b>");
		str.append("</p>");
		str.append("</td>");
		str.append("</tr>");
		str.append("<tr height='20'>");
		str.append("<td colspan='3' >");
		str.append("</td>");
		str.append("</tr>");
		str.append("<tr>");
		str.append("<td colspan='3' >");	
		str.append("<p class=MsoNormal style=''>&nbsp;</p>");
		str.append("<p class=MsoNormal >");
		str.append("<span>Se le adjunta la lista de Categorias<strong>");
	
		str.append("<br><br>");
		str.append("Cualquier consulta sobre el particular, s&iacute;rvase efectuarla a la direcci&oacute;n electr&oacute;nica "+ mail.getEmailOrigen()+"");	
		str.append("<br><br>Atentamente,<br>");
		str.append("<span class=MsoNormalCentro><b>"+mail.getNomOrigen()+"</b></span>");
		str.append("</span>");
		str.append("</p>");
		str.append("</td>");
		str.append("<tr height='20'>");
		str.append("<td colspan='1' style='width: 100px;'>");
		str.append("&nbsp;");
		str.append("</td>");
		str.append("<td colspan='1' style='width: 100px;'>");
		str.append("&nbsp;");
		str.append("</td>");
		str.append("<td colspan='1'  style='text-align: right;'>");
		str.append("<span class=MsoNormalCentro><b>"+mail.getFechaHora()+" </b></span>");
		str.append("</td>");
		str.append("</tr>");
		str.append("</tr>");
		str.append("</table>");
		str.append("</div>");

		
		return str.toString();
	}

	

	

}
