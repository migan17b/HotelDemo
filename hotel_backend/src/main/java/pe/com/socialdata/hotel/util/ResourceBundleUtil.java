package pe.com.socialdata.hotel.util;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ResourceBundleUtil implements Serializable {

	private static final long serialVersionUID = -8867485255949572950L;
	protected static Log log = LogFactory.getLog(ResourceBundleUtil.class);

	public static String getMessage(String key) {
		try {
			return ResourceBundle.getBundle(ConstantesHotel.RESOURCE_BUNDLE_APPLICATION).getString(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return "No se Encuentra el bundle";
		}
	}
	
	public static String getMessage(String keyProperty, Object... params) {
		String message = FormatoConstantes.CADENA_VACIA;
		try {
			message = MessageFormat.format(ResourceBundle.getBundle(ConstantesHotel.RESOURCE_BUNDLE_APPLICATION).getString(keyProperty), params);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return message;
	}

	public static String getMessageIndividual(String keyProperty) {
		String message = FormatoConstantes.CADENA_VACIA;
		try {
			message = ResourceBundle.getBundle(ConstantesHotel.RESOURCE_BUNDLE_MESSAGE).getString(keyProperty);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return message;
	}

	public static String getMessageIndividual(String keyProperty, Object... params) {
		String message = FormatoConstantes.CADENA_VACIA;
		try {
			message = MessageFormat.format(ResourceBundle.getBundle(ConstantesHotel.RESOURCE_BUNDLE_MESSAGE).getString(keyProperty), params);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return message;
	}


	public static String getMessageCorreo(String keyProperty) {
		String message = FormatoConstantes.CADENA_VACIA;
		try {
			message = ResourceBundle.getBundle(ConstantesHotel.RESOURCE_BUNDLE_CORREO).getString(keyProperty);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return message;
	}

	public static String getMessageCorreo(String keyProperty, Object... params) {
		String message = FormatoConstantes.CADENA_VACIA;
		try {
			message = MessageFormat.format(ResourceBundle.getBundle(ConstantesHotel.RESOURCE_BUNDLE_CORREO).getString(keyProperty), params);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return message;
	}
	
	
	
}
