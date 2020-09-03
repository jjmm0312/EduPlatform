package vaninside.eduplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vaninside.eduplatform.dao.AcademyRepository;
import vaninside.eduplatform.entity.Academy;
import vaninside.eduplatform.payload.AcademyRequest;

@Service
public class ManageService {

	@Autowired
	AcademyRepository academyRepository;
	
	public void edit(AcademyRequest academyRequest) {
		Academy academy = academyRepository.findById(1);
		academy.setName(academyRequest.getName());
		academy.setLogo(academyRequest.getLogo());
		academy.setPic(academyRequest.getPic());
		academy.setPutter(academyRequest.getPutter());
		academy.setIntro(academyRequest.getIntro());
		
		academyRepository.save(academy);
	}
}
