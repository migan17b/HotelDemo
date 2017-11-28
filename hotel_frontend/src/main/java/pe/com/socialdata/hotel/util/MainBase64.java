package pe.com.socialdata.hotel.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class MainBase64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] array;
		try {
			array = Files.readAllBytes(new File("D:\\tool\\HotelAPP\\hotel_frontend\\src\\main\\resources\\static\\images\\melany.png").toPath());
			String base64 =Base64.getEncoder().encodeToString(array);
			System.out.println(base64);
			base64 = org.apache.commons.codec.binary.Base64.encodeBase64String(array);
			System.out.println(base64);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
