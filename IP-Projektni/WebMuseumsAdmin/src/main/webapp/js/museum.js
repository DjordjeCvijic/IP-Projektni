function addVirtualTour(museumId){
    window.location.assign("add-virtual-tour.jsp?museumId="+museumId)
}

function deleteVirtualTour(museumId,virtualTourId){
	window.location.assign("museum.jsp?id="+museumId+"&deleteVirtualTourId="+virtualTourId);
}
function returnToAdminHome(){
	window.location.assign("admin-home.jsp");
}