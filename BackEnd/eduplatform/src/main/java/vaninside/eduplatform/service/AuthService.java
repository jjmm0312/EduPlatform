package vaninside.eduplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

import vaninside.eduplatform.dao.AcademyRepository;
import vaninside.eduplatform.dao.CodeRepository;
import vaninside.eduplatform.dao.MemberDao;
import vaninside.eduplatform.dao.UserRepository;
import vaninside.eduplatform.entity.Academy;
import vaninside.eduplatform.entity.Code;
import vaninside.eduplatform.entity.User;

@Service
public class AuthService {	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CodeRepository codeRepository;
	
	@Autowired
	AcademyRepository academyRepository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
	
	private static SecureRandom random = new SecureRandom();
	
	public void init() {
		// Create Admin Account
		createAdmin();
		
		// Create Invite Code
		Code code = new Code(generateCode(), generateCode());
		codeRepository.save(code);
		
		// Create Academy
		Academy academy = new Academy("UntactEdu", null, null, "UntactEdu / 서울시 동작구 상도1동 \r\n" + 
				"Tel. 010. 1234. 3285", "안녕하세요. 온라인 교육 플랫폼입니다.");
		academyRepository.save(academy);
	}

    public static String generateCode() {
    	
    	String ENGLISH_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String ENGLISH_UPPER = ENGLISH_LOWER.toUpperCase();
        String NUMBER = "0123456789";
        
        // 포함할 문자열
        String DATA = ENGLISH_LOWER + ENGLISH_UPPER + NUMBER;
        
        // 랜덤 문자열 길이
        int length=10;

        if (length < 1) throw new IllegalArgumentException("length must be a positive number.");
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append( DATA.charAt(
            		random.nextInt(DATA.length())
            		));
        }
        return sb.toString();
    }
    
    public void createAdmin() {
    	 // Creating admin
        User user = new User("admin", "untactedu",
                "manager");

        user.setPassword(passwordEncoder.encode("admin"));
        user.setRole("ROLE_ADMIN");

        User result = userRepository.save(user);
    }
}
