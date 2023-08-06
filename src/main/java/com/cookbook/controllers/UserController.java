package com.cookbook.controllers;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cookbook.dto.UserDTO;
import com.cookbook.entities.User;
import com.cookbook.repositories.UserRepository;
import com.cookbook.util.Encryption;

import io.jsonwebtoken.Jwts;
@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	private SecretKey secretKey;
	@Value("${spring.security.token-duration}")
	private Integer tokenDuration;
	

	
	private String getJWTToken(User userEntity) {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
		.commaSeparatedStringToAuthorityList(userEntity.getRole().getName().name());
		String token = Jwts.builder().setId("softtekJWT").setSubject(userEntity.getUsername())
		.claim("authorities", grantedAuthorities.stream()
		.map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + this.tokenDuration))
		.signWith(this.secretKey).compact();
		return "Bearer " + token;
		}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password")
	String pwd) {
		User userEntity = userRepository.findByUsername(username).get();
		if (userEntity != null && Encryption.validatePassword(pwd, userEntity.getPassword())) {
			String token = getJWTToken(userEntity);
			UserDTO user = new UserDTO();
			user.setUser(username);
			user.setToken(token);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Wrong credentials", HttpStatus.UNAUTHORIZED);
	}
}
