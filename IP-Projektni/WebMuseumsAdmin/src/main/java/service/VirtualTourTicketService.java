package service;

import dao.VirtualTourTicketDao;

public class VirtualTourTicketService {
	
	public static void deleteVirtualTourTicketByVirtualTourId(Integer virtualTourId) {
		VirtualTourTicketDao.deleteVirtualTourTicketByVirtualTourId(virtualTourId);
		
	}

}
