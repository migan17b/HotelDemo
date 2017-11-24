package pe.com.socialdata.hotel.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public TestCrypt() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BCryptPasswordEncoder pe= new BCryptPasswordEncoder();
		System.out.println("pas: "  + pe.encode("emarchena"));

	}

}
