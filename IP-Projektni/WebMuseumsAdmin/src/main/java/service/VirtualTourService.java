package service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import beans.VirtualTourBean;
import dao.VirtualTourDao;
import dto.VirtualTourDto;

public class VirtualTourService {
	
	
	public static List<VirtualTourBean> getAllVirtualToursInMuseum(String museumId) {
		List<VirtualTourDto>virtualTourDtos= VirtualTourDao.getVirtualToursOfMuseum(Integer.valueOf(museumId));
		List<VirtualTourBean> result=new LinkedList<>();
		virtualTourDtos.forEach(e->{
			VirtualTourBean bean=new VirtualTourBean();
			bean.setDuration(e.getDuration());
			bean.setName(e.getName());
			bean.setStartDateTime(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(e.getStartDateTime()));
			bean.setVirtualTourId(e.getVirtualTourId());
			bean.setYoutubeUrl(e.getYoutubeUrl());
			result.add(bean);
		});
		
		
		
		
		return result;
		
		
	}

}
