package com.ipproject.WebMuseums.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.model.LoginHistory;
import com.ipproject.WebMuseums.model.UserPerson;
import com.ipproject.WebMuseums.repository.LoginHistoryRepository;

@Service
public class LoginHistoryService {
	@Autowired
	private LoginHistoryRepository loginHistoryRepository;
	
	
	public LoginHistory save(UserPerson user) {
		List<LoginHistory> currentHourLogged=getCurrentHourLogged();
		System.out.println("Ukupan broj u ovom satu "+currentHourLogged.size());

		for(LoginHistory lh : currentHourLogged) {
			if(lh.getUserPerson().getUserPersonId()==user.getUserPersonId()) {
				System.out.println("nasao je da se vec ulogovao ovaj sat");
				return lh;
			}
		}
		System.out.println("nema poklapanja");
		LoginHistory dataToSave=new LoginHistory();
		dataToSave.setUserPerson(user);
		dataToSave.setLoggedTime(LocalDateTime.now());
		return loginHistoryRepository.save(dataToSave);
		
	}


	private List<LoginHistory> getCurrentHourLogged() {//vraca podatke o logovanju u trenutnom satu
		LocalDateTime startOfHour=getStartOfHour();
		System.out.println("pocetak sata "+startOfHour.toString());
		return loginHistoryRepository.findAllByLoggedTimeBetween(startOfHour, LocalDateTime.now());
	}
	private LocalDateTime getStartOfHour() {
		LocalDateTime now=LocalDateTime.now();
//		LocalDateTime startOfHour=LocalDateTime.now().minusMinutes(LocalDateTime.now().getMinute());
//		return startOfHour.minusSeconds(startOfHour.getSecond());
		return now.minusMinutes(now.getMinute()).minusSeconds(now.getSecond());
	}

}
