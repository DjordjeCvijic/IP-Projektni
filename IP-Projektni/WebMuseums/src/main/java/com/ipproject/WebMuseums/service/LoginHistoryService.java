package com.ipproject.WebMuseums.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.dto.LoginCount;
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
		return now.minusMinutes(now.getMinute()).minusSeconds(now.getSecond());
	}
	
	private int getNumberOfLoginsInHour(LocalDateTime fromTime,LocalDateTime toTime) {
		return loginHistoryRepository.findAllByLoggedTimeBetween(fromTime, toTime).size();
	}
	
	public List<LoginCount> getNumberOfLoginList(){
		List<LoginCount>resultList=new LinkedList<>();
		LocalDateTime startOfHour=getStartOfHour();
		for(int i=0;i<24;i++) {
			int count=getNumberOfLoginsInHour(startOfHour.minusHours(i), startOfHour.minusHours(i-1));
			resultList.add(new LoginCount(startOfHour.minusHours(i).getHour()+1,count));
		}

		return resultList;
	}

}
