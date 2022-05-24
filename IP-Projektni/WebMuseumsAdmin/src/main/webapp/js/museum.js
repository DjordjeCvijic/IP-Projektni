function addVirtualTour(museumId){
    window.location.assign("add-virtual-tour.jsp?museumId="+museumId)
}

function deleteVirtualTour(museumId,virtualTourId){
	window.location.assign("museum.jsp?id="+museumId+"&deleteVirtualTourId="+virtualTourId);
}
function deleteMuseum(museumId){
	window.location.assign("museum.jsp?id="+museumId+"&deleteMuseum");
}
function returnToAdminHome(){
	window.location.assign("admin-home.jsp");
}