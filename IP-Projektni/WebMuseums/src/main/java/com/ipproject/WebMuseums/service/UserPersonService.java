package com.ipproject.WebMuseums.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.compositekey.UserPersonRoleKey;
import com.ipproject.WebMuseums.dto.EmailRequestDto;
import com.ipproject.WebMuseums.dto.UserPersonDto;
import com.ipproject.WebMuseums.dto.UserPersonResponseDto;
import com.ipproject.WebMuseums.model.Role;
import com.ipproject.WebMuseums.model.UserPerson;
import com.ipproject.WebMuseums.model.UserPersonRole;
import com.ipproject.WebMuseums.model.UserStatus;
import com.ipproject.WebMuseums.repository.RoleRepository;
import com.ipproject.WebMuseums.repository.UserPersonRepository;
import com.ipproject.WebMuseums.repository.UserPersonRoleRepository;

@Service
public class UserPersonService {
	
	@Autowired
	private UserPersonRepository userPersonRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	 @Autowired
	 private   RoleRepository roleRepository;
	 @Autowired
	 private  UserPersonRoleRepository userPersonRoleRepository;
	 @Autowired
	 private UserStatusService userStatusService;
	 @Autowired
	 private EmailSenderService emailSenderService;

	public Optional<UserPerson> getUserPersonByUsername(String username) {
		return userPersonRepository.findByUsername(username);
	}

    public UserPersonResponseDto saveUserPerson(UserPersonDto userPersonDto) {
    	System.out.println("uslo u registraciju");
    	//1 ok,2 usernamealready exists,3 email already exists 
    	if(userPersonRepository.countByUsername(userPersonDto.getUsername())!=0) {
    		return new UserPersonResponseDto("2",false);
    	}
    	if(userPersonRepository.countByEmail(userPersonDto.getEmail())!=0) {
    		return new UserPersonResponseDto("3",false);
    	}
    	
    	UserPerson userToSave=buildUserFromDto(userPersonDto);
    	UserStatus status=userStatusService.getUserStatusById(1);
    	userToSave.setUserStatus(status);
        UserPerson savedUser = userPersonRepository.save(userToSave);
        
        Integer userRoleId=2;//registrovati se mogu samo obicni korisnici
        UserPersonRoleKey key = new UserPersonRoleKey(savedUser.getUserPersonId(), userRoleId);
        Role role = roleRepository.getById(userRoleId);
        userPersonRoleRepository.save(new UserPersonRole(key, savedUser, role));

        return buildUserToReply(savedUser);
        
    }

	private UserPersonResponseDto buildUserToReply(UserPerson savedUser) {
		UserPersonResponseDto user=new UserPersonResponseDto();
		user.setStatus("1");
		user.setEmail(savedUser.getEmail());
		user.setFirstName(savedUser.getEmail());
		user.setLastName(savedUser.getLastName());
		user.setPassword(savedUser.getPassword());
		user.setUsername(savedUser.getUsername());
		user.setUserPersonId(savedUser.getUserPersonId());
		user.setUserStatus(savedUser.getUserStatus());
		
		return user;
	}

	private UserPerson buildUserFromDto(UserPersonDto userPersonDto) {
		UserPerson userPerson = new UserPerson();
//        if (userPersonDto.getUserPersonId() != null)
//            userPerson.setUserPersonId(userPersonDto.getUserPersonId());

        userPerson.setFirstName(userPersonDto.getFirstName());
        userPerson.setLastName(userPersonDto.getLastName());
        userPerson.setUsername(userPersonDto.getUsername());
        userPerson.setPassword(passwordEncoder.encode(userPersonDto.getPassword()));
        userPerson.setEmail(userPersonDto.getEmail());
        userPerson.setToken("");

        return userPerson;
	}

	public void saveToken(String username, String jwt) {
		UserPerson userPerson=userPersonRepository.findByUsername(username).get();
		userPerson.setToken(jwt);
		userPersonRepository.save(userPerson);
		
	}
	
	public void logOutUser(String token) {
		UserPerson user=userPersonRepository.findByToken(token).get();
		user.setToken("");
		userPersonRepository.save(user);
	}

	public Integer getActiveUsersCount() {
		long number=userPersonRepository.count()- userPersonRepository.countByToken("");
		return Long.valueOf(number).intValue();
	}

	public Integer getRegisteredUsersCount() {
		return Long.valueOf(userPersonRepository.countByUserStatus(userStatusService.getUserStatusById(2))).intValue();
	}
	
	public UserPerson getUserPersonById(Integer id) {
		return userPersonRepository.findByUserPersonId(id).get();
	}

	public boolean changePassword(Integer userId) {
		boolean result=false;
		try {
			 String alphabet = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
				String newPassword="";
				Random r = new Random();
				for (int i = 0; i < 10; i++) {
			        newPassword=newPassword+alphabet.charAt(r.nextInt(alphabet.length()));
			    } 
				
				UserPerson user=userPersonRepository.findByUserPersonId(userId).get();
				user.setPassword(passwordEncoder.encode(newPassword));
				userPersonRepository.save(user);
				EmailRequestDto emailRequestDto=new EmailRequestDto();
				emailRequestDto.setReceiverEmail(user.getEmail());
				emailRequestDto.setMailSubject("New password for WebMuseumApp");
				emailRequestDto.setMailBody("Your new password is: "+newPassword);
				emailSenderService.sendSimpleEmail(emailRequestDto);
				result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}
