package vaninside.eduplatform.security;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vaninside.eduplatform.dao.UserRepository;
import vaninside.eduplatform.entity.User;

// 사용자의 데이터를 로드한다.
@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	// 아이디로 로그인할 떄 사용. 현재는 이름.
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
        return UserPrincipal.create(user);
	}
	
	// This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(int id) {
    	User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
            );

            return UserPrincipal.create(user);
    }
}
