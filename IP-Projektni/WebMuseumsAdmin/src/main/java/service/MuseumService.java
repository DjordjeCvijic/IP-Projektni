package service;

import java.util.LinkedList;
import java.util.List;

import beans.MuseumBean;
import dao.MuseumDao;
import dao.MuseumTypeDao;
import dto.MuseumDto;
import dto.MuseumTypeDto;

public class MuseumService {
	
	
	public static List<MuseumBean> getAllMuseums(){
		List<MuseumBean>resultList=new LinkedList<>();
		List<MuseumDto>museumDtoList=new LinkedList<>();
		museumDtoList=MuseumDao.getMuseums();
		museumDtoList.forEach(e->{
			MuseumTypeDto museumType=MuseumTypeDao.getMuseumTypeById(e.getMuseumTypeId());
			MuseumBean bean=new MuseumBean();
			bean.setAddress(e.getAddress());
			bean.setCityName(e.getCityName());
			bean.setCountryName(e.getCountryName());
			bean.setLatitude(e.getLatitude());
			bean.setLongitude(e.getLongitude());
			bean.setMuseumId(e.getMuseumId());
			bean.setMuseumTypeName(museumType.getName());
			bean.setName(e.getName());
			bean.setPhoneNumber(e.getPhoneNumber());
			resultList.add(bean);
		});
		
		
		return resultList;
	}

}
