function addVirtualTour(){
    window.location.assign("add-virtual-tour.jsp")
}

function deleteVirtualTour(museumId,virtualTourId){
	window.location.assign("museum.jsp?id="+museumId+"&delete="+virtualTourId);
}