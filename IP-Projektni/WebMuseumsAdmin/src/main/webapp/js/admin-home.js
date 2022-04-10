function showMuseum(id){
	console.log(id);
	window.location.assign("museum.jsp?id="+id);
	
}

function addMuseum(){
	console.log("sss");
	window.location.assign("add-museum.jsp");

}
function openUsersAdministrationPage(){
	window.location.assign("users.jsp");
}