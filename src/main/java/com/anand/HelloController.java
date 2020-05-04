package com.anand;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anand.bean.User;

@RestController
@CrossOrigin(origins = "*")
public class HelloController {

	final String secretKey = "7061737323313233";
	
	@PostMapping("/hello")
	public void hello(@RequestBody User user) {
		System.out.println("Actual username from Angular : "+user.getUsername());
		System.out.println("Decrypted username : " + Encryption.decrypt(user.getUsername(), secretKey));
		System.out.println("password : "+user.getPassword());
	}
}
