package vaninside.eduplatform.controller;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import vaninside.eduplatform.dao.UserRepository;
import vaninside.eduplatform.entity.User;
import vaninside.eduplatform.payload.ApiResponse;
import vaninside.eduplatform.payload.JwtAuthenticationResponse;
import vaninside.eduplatform.payload.LoginRequest;
import vaninside.eduplatform.payload.SignUpRequest;
import vaninside.eduplatform.security.JwtTokenProvider;
import vaninside.eduplatform.service.MemberService;

@Api(tags = {"1. User Auth"})
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	MemberService service;
	
	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
    private JwtTokenProvider tokenProvider;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
	@ApiOperation(value = "�׽�Ʈ �޼ҵ�", notes = "�׽�Ʈ �Դϴ�.")
	@GetMapping(value = "/")
	public String HelloWorld() {
		User user = userRepository.findByUsername("aaaaa");
		return user.toString();
	}
	   
	 @ApiOperation(value = "�α���", notes = "�α����� �Ѵ�.")
	    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@ApiParam(value="�α��� ����", required=true) @RequestBody LoginRequest loginRequest) {
	    	
	    	UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

	        // AuthenticationManager �� token �� �ѱ�� UserDetailsService �� �޾� ó���ϵ��� �Ѵ�.
	        Authentication authentication = authenticationManager.authenticate(token);

	        // ���� SecurityContext �� authentication ������ ����Ѵ�.
	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        String jwt = tokenProvider.generateToken(authentication);
	        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	    }
	    
	 @ApiOperation(value = "ȸ������", notes = "ȸ�������� �Ѵ�.")
	    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@ApiParam(value="ȸ������ ����", required=true) @RequestBody SignUpRequest signUpRequest) {
	        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
	            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
	                    HttpStatus.BAD_REQUEST);
	        }

	        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
	            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
	                    HttpStatus.BAD_REQUEST);
	        }

	        // Creating user's account
	        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
	                signUpRequest.getName());

	        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
	        user.setRole(signUpRequest.getRole());

	        User result = userRepository.save(user);
	        
	        URI location = ServletUriComponentsBuilder
	                .fromCurrentContextPath().path("/api/users/{username}")
	                .buildAndExpand(result.getUsername()).toUri();

	        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	    }
}
