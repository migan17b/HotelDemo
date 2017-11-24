package pe.com.socialdata.hotel.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:pasdoc-core.properties")
@ConfigurationProperties("pasdoc.redis")
public class ConstantesHotel {

	public static final String RESOURCE_BUNDLE_APPLICATION= "application-messages";
	public static final String RESOURCE_BUNDLE_MESSAGE= "application";
	public static final String RESOURCE_BUNDLE_CORREO= "application";
	
	public static final String MENSAJE_ERROR_GENERICO = "error.mensaje.generico";
	public static final String MENSAJE_ERROR_DATA_BD = "error.mensaje.database";
	public static final String MENSAJE_OPERACION_EXITOSA = "success.message.operacionExitosa";
	
	
	
	public static final String HABITACION_ESTADO_LIBRE_LABEL="LIBRE";
	public static final String HABITACION_ESTADO_OCUPADO_LABEL="OCUPADO";
	public static final String HABITACION_ESTADO_RESERVADO_LABEL="RESERVADO";
	public static final String HABITACION_ESTADO_LIBRE="01";
	public static final String HABITACION_ESTADO_OCUPADO="02";
	public static final String HABITACION_ESTADO_RESERVADO="03";
	
	
	public static final String RESERVA_ESTADO_RESERVADO="1";
	public static final String RESERVA_ESTADO_INICADO="2";
	public static final String RESERVA_ESTADO_TERMINADO="3";
	public static final String RESERVA_ESTADO_ANULADO="4";
	
	public static final String RESERVA_ESTADO_RESERVADO_LABEL="RESERVADO";
	public static final String RESERVA_ESTADO_INICADO_LABEL="INICIADO";
	public static final String RESERVA_ESTADO_TERMINADO_LABEL="TERMINADO";
	public static final String RESERVA_ESTADO_ANULADO_LABEL="ANULADO";
	
	public static final String ROLE_ADM="ROLE_ADM";
	public static final String ROLE_USER="ROLE_USER";
	
	public static final String TIPO_DOCUMENTO_DNI="1";
	public static final String TIPO_DOCUMENTO_CARNET_EXTRANJERIA="2";
	public static final String TIPO_DOCUMENTO_PASAPORTE="3";
	
	public static final Integer TIPO_PERSONA_CLIENTE=1;
	public static final Integer TIPO_PERSONA_TRABAJADOR=2;
	public static final Integer TIPO_PERSONA_ADMIN=3;
	
}
