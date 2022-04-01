package service;

import java.util.List;

import dao.MuseumTypeDao;
import dto.MuseumTypeDto;

public class MuseumTypeService {
	
	public static List<MuseumTypeDto> getAllMuseumTypes(){
		return MuseumTypeDao.getAllMuseumType();
	}

}
