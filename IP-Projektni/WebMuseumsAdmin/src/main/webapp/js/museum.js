function addVirtualTour(museumId){
    window.location.assign("add-virtual-tour.jsp?museumId="+museumId)
}

function deleteVirtualTour(museumId,virtualTourId){
	window.location.assign("museum.jsp?id="+museumId+"&delete="+virtualTourId);
}