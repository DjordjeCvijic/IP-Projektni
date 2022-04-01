function addVirtualTour(museumId){
    window.location.assign("add-virtual-tour.jsp?museumId="+museumId)
}

function deleteVirtualTour(museumId,virtualTourId){
	window.location.assign("museum.jsp?id="+museumId+"&delete="+virtualTourId);
	//treba dodati da se na stranici prepozna ovo i pozove servis za brisanje virtuelne posjete
}
function returnToAdminHome(){
	window.location.assign("admin-home.jsp");
}