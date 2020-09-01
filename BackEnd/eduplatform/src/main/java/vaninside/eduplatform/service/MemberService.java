package vaninside.eduplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vaninside.eduplatform.dao.MemberDao;
import vaninside.eduplatform.dao.UserRepository;
import vaninside.eduplatform.entity.User;

@Service
public class MemberService {
	@Autowired
	MemberDao dao;
	
	@Autowired
	UserRepository memberRepository;
	
	public void login() {
		return;
	}
	
	public void signup() {
		/*
		MemberRole role = new MemberRole();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		member.setUpw(passwordEncoder.encode(member.getUpw()));
		role.setRoleName("BASIC");
		member.setRoles(Arrays.asList(role));
		memberRepository.save(member);
		*/
	}
}
