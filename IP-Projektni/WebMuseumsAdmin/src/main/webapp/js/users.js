function selectChance(selectId){
	console.log(selectId);
	var button=document.getElementById(selectId);
    button.disabled=false;
}


function saveUserStatus(selectId,userId){
    var selectedValue=document.getElementById(selectId).value;
    console.log(selectId);
    console.log(userId);

    window.location.assign("users.jsp?userId="+userId+"&statusId="+selectedValue);
}

function goBack(){
	window.location.assign("admin-home.jsp");
}